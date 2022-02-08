import java.util.Scanner;

public class ComboLockTester {
    
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in) ; 
        int command = 0 ; 
        int num1 , num2 , num3 ; 
        int count = 0 ; 
        boolean a = true ; 

        do{
            System.out.println("Enter 3 integers to lock your Combo Lock: (bwteen 0 and 39) / ( enter three 0 to exit) ");
            num1 = sc1.nextInt() ; 
            num2 = sc1.nextInt() ; 
            num3 = sc1.nextInt() ; 
            if( num1 < 0  || num1 > 39 || num2 < 0  || num2 > 39 ||num3 < 0  || num3 > 39 ){
                System.out.println("invalid  enteries! please follow the guidline!"); 
                continue ; 
            }

            ComboLock A = new ComboLock(num1, num2, num3) ; 
            while (a){

                if( count> 3 ){
                     
                    System.out.println("You 've failed to unlock the lock, would you like to try the same combination again?");
                    System.out.println("1. Yes\n2. No") ; 
                    num2 = sc1.nextInt() ; 
                    if( num2 == 1){
                        count = 0 ; 
                         
                    } 
                    else {
                        count = 0 ;  
                        a = false ;
                    }
                    continue ; 
                
                }

                System.out.println("Enter the number of the action you'd like to take:");
                System.out.println("0.Reset the dial\n1.TurnLeft\n2.TurnRight\n3.Try_To_Open\n4.forfit&retry");
                command = sc1.nextInt() ; 

                switch (command) {
                    case 0 : 
                        A.reset(); 
                        break ; 

                    case 1:
                        System.out.println("How many units to left?");
                        num1 = sc1.nextInt() ; 
                        A.turnLeft(num1);
                        System.out.println("|Dial is on number:" + A.getDial() + " |");
                        count++ ; 
                        break;
                
                    case 2 : 
                        System.out.println("How many units to right?");
                        num1 = sc1.nextInt() ; 
                        A.turnRight(num1);
                        System.out.println("|Dial is on number:" + A.getDial() + " |");
                        count++ ; 
                        break ; 

                    case 3 : 
                        boolean b ; 
                        b = A.open() ; 
                        if(b){
                            System.out.println("You've Successfully Unlocked it!");
                            count = 0 ; 
                        }
                        else { 
                            System.out.println("Unsuccessfull attempt to open the Lock!");
                            count = 0 ; 
                        }
                        break ; 

                    case 4 :
                        a = false ; 
                        count = 0 ; 
                        break ; 

                    default:
                        System.out.println("Wrong entry! try again: ");
                        break;
                }
                
                





            } 



        }while ( num1 != 0 && num2 != 0 && num3 != 0); 

        System.out.println("Thanks for using our program!!");
        sc1.close();


    }
}
