
public class ComboLock {
    private int secrete1 ; 
    private int secrete2 ; 
    private int secrete3 ; 

    //storing all the moves in 2 arrays
    private int[] arr1 =  new int[3] ;    
    private String[] arr2  =  new String[3]; 

    private int pointer =  0 ; 
    private int dial = 0 ; 

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secrete1 = secret1 ; 
        this.secrete2 = secret2 ; 
        this.secrete3 = secret3 ; 
    }

    //setter method for the 3 input values ; 
    

    public void reset() { 
        pointer = 0 ; 
        dial = 0 ; 
        
    }
    public void turnLeft(int ticks) {
       
 
        if( ticks < 0 ){// we make sure ticks stays positive
            ticks = -ticks ; 
        }

        if ( (dial - ticks) < 0  ){
            this.dial = dial - ticks ;
        }
        else { 
            ticks = ticks - dial  ;
            reset();
            turnLeft(ticks - dial);   
        }
        
        if( dial < 0 ){// we make sure ticks stays positive
            dial = -dial ; 
        }

        if ( pointer < 3 ){
            pointer++ ; 
            arr1[pointer - 1] = dial ; // stores the number in the combination array 
            arr2[pointer - 1] = "l" ; //stores r in the direction array
        }

    }

    public void turnRight(int ticks) {
        if ( ticks < 0 ){
            ticks = -ticks ; 
        }
        if(dial + ticks > 40 ){
            dial  = (dial+ticks) % 40 ; // this condition is for the time th user rotate too much , 
        }
        else{ 
            dial = dial + ticks ; 
        }
        
        if ( pointer < 3 ){
            pointer++ ; 
            arr2[pointer - 1] = "r" ; //stores r in the direction array
            arr1[pointer - 1] = dial ; // stores the number in the combination array 
        }

        
    }


    public boolean open() {
        if( arr2[0] == "r" && arr2[1] == "l" && arr2[2] == "r"){
            if( secrete1 == arr1[0] && secrete2 == arr1[1] && secrete3 == arr1[2]){
                return true; 
            }
        }
        return false ;        
    }      
    
    
    // this function is to help us to keep track of the dial 

    public int getDial(){
        return this.dial ; 
    }

}
