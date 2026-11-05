package LabAssignment1;

class PremiumPass extends TravelPass {
    PremiumPass(String holderName,String passId,double balance){
        super(holderName, passId, balance);
    }

    @Override
    public void takeRide(double fare) {
       if(getTotalRidesTaken()<10){
           super.takeRide(0.00);
           super.addBalance(0.00);
       }else{
           super.takeRide(fare);
       }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        if(getTotalRidesTaken()<10){
            System.out.println("Free rides remaining: "+(10-getTotalRidesTaken()));
        }else{
            System.out.println(0);
        }
    }
}

