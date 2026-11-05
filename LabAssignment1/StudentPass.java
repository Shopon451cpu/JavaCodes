package LabAssignment1;

class StudentPass extends TravelPass{
    private int discountedRidesToday;
    StudentPass(String holderName,String passId,double balance){
        super(holderName, passId, balance);
        this.discountedRidesToday=0;
    }

    @Override
    public void takeRide(double fare) {
        double finalFare;
        if(discountedRidesToday<4){
            finalFare=0.5*fare;
        }else{
            finalFare=fare;
        }
        super.takeRide(finalFare);
        }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Discounted ride today: "+discountedRidesToday);
    }
}

