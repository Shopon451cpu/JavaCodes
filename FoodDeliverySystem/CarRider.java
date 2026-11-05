package FoodDeliverySystem;

class CarRider implements EarningCalculable,Rateable {
    private String name;
    private int completedTrips;
    private double earningPerTrip;
    private double maintenanceCost;

    CarRider(String name, int completedTrips, double earningPerTrip, double maintenanceCost){
        this.name=name;
        this.completedTrips=completedTrips;
        this.earningPerTrip=earningPerTrip;
        this.maintenanceCost=maintenanceCost;
    }
    String getName(){
        return name;
    }

    @Override
    public double CalculateEarning() {
        return (completedTrips*earningPerTrip)-maintenanceCost;
    }

    @Override
    public boolean hasGoodRating() {
        return CalculateEarning()>=30000;
    }
    void increaseTrips(int extraTrips){
        completedTrips+=extraTrips;
    }
    void updateTrip(int completedTrips){
        this.completedTrips=completedTrips;
    }
    void updateTrip(int completedTrips, double maintenanceCost){
        this.completedTrips=completedTrips;
        this.maintenanceCost=maintenanceCost;
    }
}
