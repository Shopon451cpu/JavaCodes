package FinalProject;
import java.util.*;
import java.io.Serializable;
//variables,getters,addBalance(), deductBalance(),addHistory(),showHistory(), abstract deposit(),abstract withdraw(),display().
abstract class Account implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String nationalIdNumber;
    private String phoneNumber;
    private int accNo;
    private double balance;
    protected ArrayList<String> history = new ArrayList<>();

    public Account(String name,int age, String nationalIdNumber, String phoneNumber, int accNo, double balance) {
        this.name = name;
        this.age=age;
        this.nationalIdNumber=nationalIdNumber;
        this.phoneNumber=phoneNumber;
        this.accNo = accNo;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccNo() {
        return accNo;
    }

    public double getBalance() {
        return balance;
    }

    protected void addBalance(double amt) {
        balance += amt;
    }

    protected void deductBalance(double amt) {
        balance -= amt;
    }
     //for transection
    public void addHistory(String msg) {
        history.add(msg);
    }
     //transection history
    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transaction yet.");
            return;
        }

        for (String h : history) {
            System.out.println(h);
        }
    }

    public abstract void deposit(double amt) throws InvalidAmountException;

    public abstract void withdraw(double amt) throws InvalidAmountException;
    //account information
    public void display() {
        System.out.println("Name: "+ name +"| Acc: " + accNo + "| Age: "+age+"| Balance: " + balance+"| National ID Number: "
                +nationalIdNumber+"| Phone Number: "+phoneNumber+"| Type: " + this.getClass().getSimpleName());
    }
}
