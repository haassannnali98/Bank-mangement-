package finalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class InterstRate {
    private static Scanner scanner = new Scanner(System.in); //a static scanner object that can be used with all the methods
    /**
     *this method is for showing the customer the interest based on the offers of the bank
     * it takes the arrayList of the accounts that have saved in the systme as a parameter to find the coustumers infromation
     * like balance and name from the Id
     */
    public void interest(ArrayList<Account> accounts) {
        System.out.println("Enter the ID of the Customer: ");
        String ID = scanner.nextLine(); // takes the ID form the consul
        
        
        for (Account account : accounts) { // a loop to traversal in the array list
            if (ID.equalsIgnoreCase(account.getAid())) { // an if statment to see if we have an ID like that in the system
                double balance = account.getAbal(); // a variabel to have the balance of coustmer since we need to calculate the intrest
                System.out.println("The Costumer with Name ( " + account.getName() + " ) Found and it is balance : " + account.getAbal() + "$"); // this shows that the coustemer have been found
                System.out.println("Enter the Interest Rate:");
                double interestRate = scanner.nextDouble(); // thakes the interest Rate from the counsul
                System.out.println("For how Long in Years do you want ? ");
                
                while (true) { // this loop is to get the intger from the counsul and not any number with a floting point since years is an integer
                    if (scanner.hasNextInt()) { // if there is an integer so this if statment will be true and runs the logic
                        int years = scanner.nextInt();
                        
                        double interest = ((interestRate / 100) * years * balance); // this is how the interest rate is beeing calculated
                        double amount = interest + balance; // and this addes it to the courent balance to tell the coustemer
                        System.out.println("Your total interest will be " + amount + "$ After " + years + " Years, With Profit of " + (int) interest + "$"); // and then fainaly it prints it to the consul
                        break; // brakes the while loop
                    } else { // this block gets exicuted when the value is passed is not an integer
                        System.out.println("Please Enter an Integer value: ");
                        scanner.next();
                    }
                }
                break; // brakes the for loop since we have fund the coustumer we are looking for
            }
            System.out.println("This Account is not Found !"); // if there is't any account in the system with that ID so it well say we did not faund the accoutnt
        }
    }
    
}