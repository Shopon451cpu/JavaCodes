package FinalProject;
import java.util.ArrayList;
import java.io.*;

public class BankSystem {
    private ArrayList<Account> list = new ArrayList<>();
    private final String filePath = "bank_data.dat";

    //creating method
    public void createAccount(Account a) {   //passing account type.
        if (find(a.getAccNo()) != null) {
            System.out.println("Account already exists!");
            return;
        }

        list.add(a);
        System.out.println("✔ Account Created");
    }

     //method to find account if exists.
    public Account find(int acc) {

        for (Account a : list) {

            if (a.getAccNo() == acc)
                return a;
        }

        return null;
    }

    //method to show all accounts
    public void showAll() {

        if (list.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (Account a : list) {
            a.display();
        }
    }

    //method to delete account
    public void delete(int acc) {

      Account a = find(acc);   //account search kore pele Account type er variable a teh store korbe. then a delete kore dbe.

        if (a != null) {

            list.remove(a);

            System.out.println("✔ Account Deleted Successfully.");

        } else {

            System.out.println("Account not found!");
        }
    }
     //method for counting accounts
    public void countAccounts() {

        int savings = 0;
        int current = 0;
        int fd = 0;

        for (Account a : list) {

            if (a instanceof SavingsAccount)
                savings++;

            else if (a instanceof CurrentAccount)
                current++;

            else if (a instanceof FixedDepositAccount)
                fd++;
        }

        System.out.println("Total Accounts: " + list.size());
        System.out.println("Saving Accounts: " + savings);
        System.out.println("Current Accounts: " + current);
        System.out.println("Fixed Deposit Accounts: " + fd);
    }

    //deposit method
    public void deposit(int acc, double amt) {

        try {

            Account a = find(acc);  //jeheto deposit exception throw kore tai try, catch block use kora hoise.

            if (a == null) {
                System.out.println("Account not found!");
                return;
            }

            a.deposit(amt);

            System.out.println("✔ Deposit Successful");

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }
    }

    //withdraw method
    public void withdraw(int acc, double amt) {

        try {

            Account a = find(acc);

            if (a == null) {
                System.out.println("Account not found!");
                return;
            }

            a.withdraw(amt);

            System.out.println("✔ Withdraw Successful");

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }
    }
    //TRANSFER method
    public void transfer(int from, int to, double amt) {

        Account sender = find(from);
        Account receiver = find(to);

        if (sender == null || receiver == null) {
            System.out.println("Account missing!");
            return;
        }

        // FD cannot receive deposit
        if (receiver instanceof FixedDepositAccount) {
            System.out.println("Cannot transfer to FD account!");
            return;
        }

        try {

            sender.withdraw(amt);
            receiver.deposit(amt);

            sender.addHistory("Transferred to " + to + " : " + amt);

            receiver.addHistory("Received from " + from + " : " + amt);

            System.out.println("✔ Transfer Successful");

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }
    }
    //balance check method
    public void checkBalance(int acc) {

       Account a = find(acc);

        if (a != null) {

            System.out.println("Balance: " + a.getBalance());

        } else {

            System.out.println("Account not found!");
        }
    }
    //method to check history
    public void showHistory(int acc) {

        Account a = find(acc);

        if (a != null) {

            a.showHistory();

        } else {

            System.out.println("Account not found!");
        }
    }
    //generic search method
    public <T> void search(T key) {

        boolean found = false;

        for (Account a : list) {

            if (key instanceof Integer &&
                    a.getAccNo() == (Integer) key) {

                a.display();
                found = true;
            }

            else if (key instanceof String &&
                    a.getName().equalsIgnoreCase((String) key)) {

                a.display();
                found = true;
            }
        }

        if (!found)
            System.out.println("Account not found!");
    }
      //saving file
      public void saveToFile() {

          try {

              File file = new File(filePath);  //file khollam

              System.out.println("========== SAVE START ==========");
              System.out.println("Path: " + file.getAbsolutePath());  //path tah show korbe

              FileOutputStream fos = new FileOutputStream(file);  //byte akare data rakhar jonno stream toiri korbe

              ObjectOutputStream out = new ObjectOutputStream(fos); // jeheto object save dicci tai object rakhar stream.

              out.writeObject(list);  // asol kaj hocce. data save hocce. serialization.

              out.flush();  //buffer clear.

              out.close();//ObjectOutputStream off freeing space.
              fos.close(); //FileOutputStream off properly saving data.

              System.out.println("File Exists After Save: " + file.exists()); //true false returns.

              System.out.println("File Size: " + file.length());  //size of file

              System.out.println("✔ SAVE SUCCESS");

          } catch (Exception e) {

              System.out.println("SAVE FAILED");

              e.printStackTrace();  //prints the exact error.
          }
      }

    @SuppressWarnings("unchecked")

    public void loadFromFile() {

        try {

            File file = new File(filePath);

            System.out.println("========== LOAD START ==========");
            System.out.println("Path: " + file.getAbsolutePath());

            System.out.println("Exists: " + file.exists());

            if (!file.exists()) {

                System.out.println("NO FILE FOUND");

                list = new ArrayList<>();

                return;
            }

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            list = (ArrayList<Account>) in.readObject();

            in.close();

            System.out.println("✔ LOADED: " + list.size());

        } catch (Exception e) {

            System.out.println("LOAD FAILED");

            e.printStackTrace();
        }
    }

}
