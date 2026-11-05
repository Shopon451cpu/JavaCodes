package FoodDeliverySystem;

class Biker implements EarningCalculable,Rateable {
     private String name;
     private int completedDeliveries;
     private double earningPerDelivery;
     private double fuelSupport;

     Biker(String name, int completedDeliveries,double earningPerDelivery,double fuelSupport){
         this.name=name;
         this.completedDeliveries=completedDeliveries;
         this.earningPerDelivery=earningPerDelivery;
         this.fuelSupport=fuelSupport;
     }

    @Override
    public double CalculateEarning() {
        return (completedDeliveries*earningPerDelivery)+fuelSupport;
    }

    @Override
    public boolean hasGoodRating() {
        if(CalculateEarning()>=20000){
            return true;
        }else{
            return false;
        }
    }
      public void addFuelSupport(double amount){
         fuelSupport+=amount;
     }
    public void updateDelivery(int completedDeliveries){
         this.completedDeliveries=completedDeliveries;
    }
    public void updateDelivery(int completedDeliveries, double fuelSupport){
         this.completedDeliveries=completedDeliveries;
         this.fuelSupport=fuelSupport;
    }
    String getName(){
         return name;
    }
}
