import java.util.Scanner;

public class AtmMachine{
    
    private static Scanner in;
    private static double balance =0; //Initial balance to 0 for everyone
    private static int anotherTransaction;


    public static void main(String args[]){
        in = new Scanner (System.in);
        Transaction();

    }

    private static void Transaction(){

        int choice;
        System.out.println("Please select an option");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");

        choice = in.nextInt();
        if(choice ==1){
            float amount;
            System.out.println("Please enter amount to withdraw: ");
            amount = in.nextFloat();
            if(amount > balance || amount ==0 ){
                System.out.println("You have insufficent funds\n");
                anotherTransaction();
            }
            else{
                balance -= amount;
                System.out.println("You have withdrawn: "+ amount +" and your balance is : "+ balance +"\n");
                anotherTransaction();
            }
        }
        else if(choice ==2){
            float deposit;
            System.out.println("Please enter amount you would wish to deposit: \n");
            deposit = in.nextFloat();
            balance += deposit;
            System.out.println("You have deposited: "+ deposit +" new balance is :"+ balance +"\n");
            anotherTransaction();
        }
        else if(choice == 3){
            System.out.println("Your balance is: "+ balance +"\n" );
            anotherTransaction();

        }

    }

    private static void anotherTransaction(){
        System.out.println("Do you want another transaction? \n Press 1 for another \n Press 2 to exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            Transaction();
        }
        else if( anotherTransaction == 2){
            System.out.println("Thanks for stopping by");
        }
        else{
            System.out.println("Invalid choice");
            anotherTransaction();
        }
    }
}