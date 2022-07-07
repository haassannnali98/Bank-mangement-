package finalProject;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedWriter;


public class Transaction extends Account {
    private String x;
    private ArrayList<Transaction> tr=new ArrayList<Transaction>();
    private double transactionAmount;
    private Account sender;
    private Account receiver;
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static final Date date = new Date();
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Transaction(double transactionAmount, Account sender, Account receiver, Timestamp timestamp) {
        this.transactionAmount = transactionAmount;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp=timestamp;
    }

    public Transaction() {
        this(0, null, null,null);
    }

    private void moveMoney(Account sender, Account receiver) {
        this.receiver = receiver;
        this.sender = sender;
        System.out.println("Enter the transaction amount");
        if (scanner.hasNextDouble()) {
            this.transactionAmount = scanner.nextDouble();
        } else {
            System.out.println("Enter a number please");
        }
        if (sender.getAbal() < transactionAmount) {
            System.out.println("Not Enough MONEY !");
        }
        if ((100 < transactionAmount) && (500 > transactionAmount)) {
            sender.setAbal(sender.getAbal() - (transactionAmount + (transactionAmount * 0.01)));
            receiver.setAbal(receiver.getAbal() + transactionAmount);
            Timestamp timestamp = new Timestamp(date.getTime());

            System.out.println("transaction is done at " + timestamp);
            transactions.add(new Transaction(transactionAmount, sender, receiver,timestamp));

        } else {
            System.out.println("you can only do Transaction between 100 and 500 Dollar");
        }
    }

    public void doTransaction(Account sender, Account receiver) {
        if (sender.getAbal() < 300) {
            System.out.println(sender.getName() + " Doesn't have enough MONEY, it should be have more than 300$");
        } else {
            moveMoney(sender, receiver);
        }
    }

    public void printTransaction() {
        this.transactionsTravers();
    }

    private void transactionsTravers() {
        for (Transaction transaction : transactions) {

            x= transaction.transactionAmount + " ,from, " + transaction.sender.getName() + ", in, " + transaction.sender.getAdd()
                    + ", to, " + transaction.receiver.getName() + ", from ," + transaction.receiver.getAdd() +" ,at ," +transaction.getTimestamp();
            System.out.println(x);

        }


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("myTransaction.txt",true));
            writer.write(x);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }







    }}



