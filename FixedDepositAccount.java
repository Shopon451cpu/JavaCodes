package FinalProject;
//overriding
class FixedDepositAccount extends Account {

    public FixedDepositAccount(String name, int age,String idNumber,String phoneNumber,int accNo, double balance) {
        super(name,age,idNumber,phoneNumber,accNo,balance);
    }

    @Override
    public void deposit(double amt) throws InvalidAmountException {
        throw new InvalidAmountException("FD account cannot deposit!");
    }

    @Override
    public void withdraw(double amt) throws InvalidAmountException {
        throw new InvalidAmountException("FD account cannot withdraw!");
    }
}
