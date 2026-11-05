package LabAssignment1;

public class CorporatePass extends TravelPass{
   CorporatePass(String holderName,String passId,double balance){
       super(holderName, passId, balance);
   }

    @Override
    public void takeRide(double fare) {
        if(getBalance()<20.00){
            System.out.println("Insufficient balance.");
        }else{
            super.addBalance(20.00);
        }
        if(getBalance()<100.00){
            System.out.println("Low corporate balance alert.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}
