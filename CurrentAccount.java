package FinalProject;
//just overriding of deposit and withdraw methods.
class CurrentAccount extends Account {

    public CurrentAccount(String name, int age,String idNumber,String phoneNumber,int accNo, double balance) {

        super(name,age,idNumber,phoneNumber,accNo,balance);
    }

    @Override
    public void deposit(double amt) throws InvalidAmountException {

        if (amt <= 0)
            throw new InvalidAmountException("Invalid deposit amount!");

        addBalance(amt);
        addHistory("Deposited: " + amt);
    }

    @Override
    public void withdraw(double amt) throws InvalidAmountException {

        if (amt <= 0)
            throw new InvalidAmountException("Invalid amount!");

        if (amt > getBalance())
            throw new InvalidAmountException("Insufficient balance!");

        deductBalance(amt);
        addHistory("Withdraw: " + amt); //auto conversion of amt into String.
    }
}