package FinalProject;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankSystem bank = new BankSystem();
        bank.loadFromFile();

        while (true) {
            System.out.println("============Welcome===================");
            System.out.println("Press "+ 1 +" if you are a customer: ");
            System.out.println("Press "+ 2 +" if you are a bank staff: ");
            System.out.println("Press "+ 0 +" to exit.");

            int role;
            try {
                role = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid option! please enter 1,2 or 0 only.");
                continue;
            }

            // ================= EXIT =================
            if (role == 0) {
                System.out.println("EXIT SELECTED - SAVING DATA...");
                bank.saveToFile();
                System.out.println("Program End");
                break;
            }

            // ================= CUSTOMER =================
            if (role == 1) {

                while (true) {

                    try {
                        System.out.println("\nCustomer Menu:");
                        System.out.println("1.Deposit money.");
                        System.out.println("2.Withdraw money.");
                        System.out.println("3.Transfer money.");
                        System.out.println("4.Check Balance.");
                        System.out.println("5.View History.");
                        System.out.println("6.Back");
                        System.out.println("Please choose an option: ");

                        int ch;
                        try {
                            ch = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Invalid choice!");
                            continue;
                        }

                        if (ch < 1 || ch > 6) {
                            System.out.println("Invalid option!");
                            continue;
                        }

                        if (ch == 6) break;
                        System.out.print("Acc: ");
                        int acc = Integer.parseInt(sc.nextLine());

                        switch (ch) {
                            case 1 -> {
                                System.out.print("Amount: ");
                                double amt = Double.parseDouble(sc.nextLine());
                                bank.deposit(acc, amt);
                                bank.saveToFile();
                            }
                            case 2 -> {
                                System.out.print("Amount: ");
                                double amt = Double.parseDouble(sc.nextLine());
                                bank.withdraw(acc, amt);
                                bank.saveToFile();
                            }

                            case 3 -> {
                                System.out.print("To Acc: ");
                                int to = Integer.parseInt(sc.nextLine());
                                System.out.print("Amount: ");
                                double amt = Double.parseDouble(sc.nextLine());
                                bank.transfer(acc, to, amt);
                                bank.saveToFile();
                            }

                            case 4 -> bank.checkBalance(acc);

                            case 5 -> bank.showHistory(acc);

                            default -> System.out.println("Invalid choice!");
                        }

                    } catch (Exception e) {

                        System.out.println("Invalid input!");
                    }
                }
            }

            // ================= STAFF =================
            else if (role == 2) {

                while (true) {

                    try {

                        System.out.println("\nStaff Menu");
                        System.out.println("1.Create Account: ");
                        System.out.println("2.Show all Accounts: ");
                        System.out.println("3.Delete an Account: ");
                        System.out.println("4.Search an Account: ");
                        System.out.println("5.See Total number of Accounts: ");
                        System.out.println("6.Back.");
                        System.out.println("Choose an option: ");

                        int ch;
                        try {
                            ch = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            System.out.println("Invalid choice!");
                            continue;
                        }

                        if (ch == 6)
                            break;

                        switch (ch) {

                            // ===== CREATE =====
                            case 1 -> {

                                System.out.print("Name: ");
                                String n = sc.nextLine();

                                System.out.print("Age: ");
                                int age=Integer.parseInt(sc.nextLine());

                                System.out.print("National ID card Number: ");
                                String id= sc.nextLine();

                                System.out.print("Phone Number: ");
                                String pn= sc.nextLine();

                                System.out.print("Acc: ");
                                int a = Integer.parseInt(sc.nextLine());

                                System.out.print("Balance: ");
                                double b = Double.parseDouble(sc.nextLine());

                                System.out.print("Type:");
                                System.out.println("\n1.Savings");
                                System.out.println("2.Current");
                                System.out.println("3.FD");

                                int t = Integer.parseInt(sc.nextLine());

                                if (t == 1) {

                                    bank.createAccount(new SavingsAccount(n,age,id,pn,a, b));
                                    bank.saveToFile();

                                } else if (t == 2) {

                                    bank.createAccount(new CurrentAccount(n,age,id,pn, a, b));

                                } else if (t == 3) {

                                    bank.createAccount(new FixedDepositAccount(n,age,id,pn, a, b));

                                } else {

                                    System.out.println("Invalid type!");
                                }
                            }

                            // ===== SHOW =====
                            case 2 -> bank.showAll();

                            // ===== DELETE =====
                            case 3 -> {

                                System.out.print("Acc: ");

                                int a = Integer.parseInt(sc.nextLine());

                                bank.delete(a);
                            }

                            // ===== SEARCH =====
                            case 4 -> {
                                System.out.println("Enter Name or Account number to find account: ");

                                String input = sc.nextLine();

                                try {
                                    int accNo = Integer.parseInt(input);
                                    bank.search(accNo);
                                } catch (Exception e) {
                                    bank.search(input);
                                }
                            }

                            // ===== COUNT =====
                            case 5 -> bank.countAccounts();

                            default -> System.out.println("Invalid choice!");
                        }

                    } catch (Exception e) {

                        System.out.println("Invalid input!");
                    }
                }
            }

            else {
                System.out.println("Invalid Role!");
            }
        }
        bank.saveToFile();
        sc.close();

    }
}
