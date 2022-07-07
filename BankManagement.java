package finalProject;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BankManagement extends Account  {


    Scanner sc = new Scanner(System.in);
    static ArrayList<Account> bankArray = new ArrayList<Account>();
    static InterstRate intR = new InterstRate();


    public void addCustomer()
    {

        Account myAccount= new Account();

        System.out.println("Enter Customer Username : ");
        this.name = sc.next();
        myAccount.setName(this.name);

        System.out.println("Enter Customer Address : ");
        this.add = sc.next();
        myAccount.setAdd(this.add);


        int lastIndex = bankArray.size() -1; // index-1 bo away axir index bdozetawa.
        int accountNumber;
        if (lastIndex <0){ // agar size array la sfr bchuktr bu kawata array'aka batalaw account number sfra.
            accountNumber = 0;
        }
        else{
            accountNumber = Integer.parseInt(bankArray.get(lastIndex).getAid()); // agar gawratr bu ID indexaka axwenetawa.
        }
        accountNumber = accountNumber + 1; // har kam law dwanay saraway xwendawa zayd yaki akat.
        String aid = String.valueOf(accountNumber); //aykatawa ba string
        myAccount.setAid(aid);
        System.out.println("Account number is:\n" + aid);



        System.out.println("Enter Customer Balance ($): ");
        while (true) {
            if(sc.hasNextDouble()){
                this.abal = sc.nextDouble();
                myAccount.setAbal(this.abal);
                bankArray.add(myAccount);
                System.out.println("New Customer Added! ");
                break;
            }else
                sc.next();
            System.out.println("Invalid value, please Enter a number!");
        }
    }




    public  void deleteAccount() {
        System.out.println("Available account: ");
        for (int i = 0; i < bankArray.size(); i++) {
            System.out.println(bankArray.get(i).getAid() + "  " + bankArray.get(i).getName()); // it will show you the available account ID and username.
        }
        System.out.println("Write the account number that you want to delete: ");
        String a = sc.next();

        for(int i=0;i< bankArray.size();i++) {
            if(bankArray.get(i).getAid().equalsIgnoreCase(a)) { // it will compare the account number that you enter with the available account to check if it is exist or not.
                System.out.println("Dear " + bankArray.get(i).getName() + ", your account has been successfully Deleted.");
                bankArray.remove(i);
            }
        }
    }


    public  void viewAccount() {

        System.out.println("Available account: ");
        for (int i = 0; i < bankArray.size(); i++) {
            System.out.println(bankArray.get(i).getAid() + "  " + bankArray.get(i).getName()); // it will show you the available account number and username.
        }
        System.out.println("Write account number you want to check");
        String a = sc.next();

        for(int i=0;i< bankArray.size();i++) {
            if(bankArray.get(i).getAid().equalsIgnoreCase(a)) {
                System.out.println(bankArray.get(i));
            } }
    }



    public  void savedata() {
        String a ="";
        for(int i=0;i< bankArray.size();i++) { // here we will save the user data.
            a += bankArray.get(i).getName() + "     ," + bankArray.get(i).getAdd() +"   ," +bankArray.get(i).getAid() + "     ," + bankArray.get(i).getAbal() + "\n";
        }


        try (FileWriter b = new FileWriter("112.txt", false);
             PrintWriter p = new PrintWriter(b);) {
            p.write(a);
            System.out.println("Your current data has been successfully saved");
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }




    public void loadAccounts() throws FileNotFoundException { // instead of surrounding by try and catch.

        Scanner sc=new Scanner(new File("112.txt"));
        int j = 0;
        while (sc.hasNextLine()){
            String[] accounts; // it will split them index by index depends on ",".

            accounts = sc.nextLine().split(",");
            bankArray.add(new Account()); // it will generate an object for each line that would be read.
            for (int i = 0; i < accounts.length; i++) {
                if(i == 0){
                    bankArray.get(j).setName(accounts[0].strip()); // we will separate each index, here username is the first index and we remove the space by (.strip)
                }
                if(i == 1){
                    bankArray.get(j).setAdd(accounts[1].strip());
                }
                if(i == 2){
                    bankArray.get(j).setAid(accounts[2].strip());
                }
                if(i == 3){
                    String tempRead = accounts[3].strip();
                    Double tempBal = Double.parseDouble(tempRead); // here we will change balance from string to double.
                    bankArray.get(j).setAbal(tempBal);
                }



            }
            j++; // it increases the number for each line.
        }
    }






    public void transacteAccount() throws FileNotFoundException {
        System.out.println("Enter the account ID that transact the amount of money: ");
        String a = sc.next();
        System.out.println("Enter the account ID that will receieve the amount of money:");
        String b = sc.next();
        Account _transact1 = new Account();
        System.out.println("Enter the amount that you want to transact: ");
        Account _transact2 = new Account();

        for (int i = 0; i < bankArray.size(); i++) {
            if (bankArray.get(i).getAid().equalsIgnoreCase(a)) {
                _transact1 = bankArray.get(i);

            }
            if (bankArray.get(i).getAid().equalsIgnoreCase(b)) {
                _transact2 = bankArray.get(i);

            }
        }

        myTransaction.doTransaction(_transact1, _transact2);
    }


    Transaction myTransaction = new Transaction();

    private void showTransactions() {

        myTransaction.printTransaction();
    }

    public static void main(String args[]) throws FileNotFoundException {

        Transaction t= new Transaction();
        BankManagement myBank = new BankManagement();
        Scanner sc = new Scanner(System.in);

        myBank.loadAccounts();
        System.out.println("---------------------------------------------");
        System.out.println("\t       Welcome To Suli Bank");

        boolean roll = false;
        while(!roll){

            System.out.println("---------------------------------------------");
            System.out.println("Press 0 to Exist the System");
            System.out.println("Press 1 to Add new Customer");
            System.out.println("Press 2 to Delete Customer Account");
            System.out.println("Press 3 to Check Customer Account Information");
            System.out.println("Press 4 to Save Customer Information");
            System.out.println("Press 5 to Transact Money");
            System.out.println("press 6 to Show all Transactions");
            System.out.println("press 7 to Show Your Interest");
           
            System.out.println("---------------------------------------------");
            System.out.println("Choose an Option: ");

            String choice = sc.nextLine(); // we initialize the choice as integer.


            switch (choice) {
                case "0":
                    System.out.println("The system has been successfully exited ");
                    System.exit(0);
                case "1":
                    myBank.addCustomer();
                    break;
                case "2":
                    myBank.deleteAccount();
                    break;
                case "3":
                    myBank.viewAccount();
                    break;
                case "4":
                    myBank.savedata();
                    break;
                case "5":
                    myBank.transacteAccount();
                    break;
                case "6":
                    myBank.showTransactions();
                    break;
                case "7":
                    intR.interest(myBank.bankArray);

                default:
                    System.out.println("You Enter an Invalid Choice");
                    break;
            }

        }}}
