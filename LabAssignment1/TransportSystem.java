package LabAssignment1;

public class TransportSystem {
    public static void main() {
     StudentPass student = new StudentPass("Shopon","ST101",250.00);
     PremiumPass premium = new PremiumPass("Eiyhiya","PR101B",500.00);
     CorporatePass Corporate = new CorporatePass("Mohammad","CR101C",400.00);

        for (int i = 0; i < 6; i++) {
            student.takeRide(30);
        }

        for (int i = 0; i < 12; i++) {
            premium.takeRide(40);
        }

        for (int i = 0; i < 3; i++) {
            Corporate.takeRide(20);
        }
        System.out.println("Student pass info: ");
        student.displayInfo();
        System.out.println("\n");

        System.out.println("Premium pass info: ");
        premium.displayInfo();
        System.out.println("\n");

        System.out.println("Corporate pass info: ");
        Corporate.displayInfo();

    }
}
