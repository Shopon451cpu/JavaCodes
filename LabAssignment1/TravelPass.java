package LabAssignment1;

class TravelPass{
    private String holderName;
    private String passId;
    private double balance;
    private int totalRidesTaken;

    TravelPass(String holderName,String passId,double balance){
         this.holderName=holderName;
         this.passId=passId;
         if(balance<0){
             this.balance=0.00;
         }else{
             this.balance=balance;
         }
         this.totalRidesTaken=0;
    }
    public void addBalance(double amount){
          if(amount>0.00){
              balance+=amount;
          }else{
              System.out.println("Invalid amount");
          }
    }

    public void takeRide(double fare){
        if(fare<0.00){
            System.out.println("Invalid fare.");
        }
         if(balance>=fare) {
             balance-=fare;
             totalRidesTaken++;
         }else{
             System.out.println("Insufficient balance.");
         }

    }

    public void displayInfo(){
        System.out.println("Holder Name: "+holderName);
        System.out.println("Pass ID: "+passId);
        System.out.println("Balance: "+balance);
        System.out.println("Total Rides Taken: "+totalRidesTaken);
    }

    public double getBalance() {
        return balance;
    }

    public int getTotalRidesTaken() {
        return totalRidesTaken;
    }
}
