package FoodDeliverySystem;

public class Main {
    public static void main(String[] args) {
        EarningCalculable[] riders=new EarningCalculable[4];
        riders[0]=new Biker("Rahim",100,150,2000);
        riders[1] = new CarRider("Karim", 80, 500, 5000);
        riders[2] = new Biker("Sakib", 120, 130, 3000);
        riders[3] = new CarRider("Jamal", 90, 600, 8000);
        int bikeCount = 0;
        int carCount = 0;
        int goodRatingCount = 0;
        System.out.println("---------initial data----------------");
        for(int i=0; i<riders.length;i++){
            System.out.println("\nRider " + (i + 1));
            if(riders[i] instanceof Biker b){
                System.out.println("Type: BikerRider.");
                System.out.println("Name: "+b.getName());
                System.out.println("Earning: "+b.CalculateEarning());
                System.out.println("Target: "+b.isTargetReached(18000.00));
                System.out.println("Rating status: "+b.ratingStatus());
                bikeCount++;
                if(b.hasGoodRating())
                    goodRatingCount++;
            }
            if(riders[i] instanceof CarRider c){
                System.out.println("Type: CarRider.");
                System.out.println("Name: "+c.getName());
                System.out.println("Earning: "+c.CalculateEarning());
                System.out.println("Target: "+c.isTargetReached(18000.00));
                System.out.println("Rating status: "+c.ratingStatus());
                carCount++;
                if(c.hasGoodRating())
                    goodRatingCount++;
            }

        }
        ((Biker) riders[0]).addFuelSupport(500);
        ((CarRider)riders[1]).increaseTrips(2);
        System.out.println("After update: ");
        Biker b=(Biker)riders[0];
        CarRider c= (CarRider) riders[1];

        System.out.println("Biker new Earning: "+b.CalculateEarning());
        System.out.println("Updated status: "+b.ratingStatus());

        System.out.println("CarRider new Earning: "+c.CalculateEarning());
        System.out.println("Updated status: "+c.ratingStatus());

        System.out.println("\nTotal BikeRiders: " + bikeCount);
        System.out.println("Total CarRiders: " + carCount);
        System.out.println("Total Good Ratings: " + goodRatingCount);

    }
}
