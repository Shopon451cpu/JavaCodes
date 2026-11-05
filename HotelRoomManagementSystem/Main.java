package HotelRoomManagementSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Guest[] G = new Guest[4];
        System.out.println("Enter Corporate Guest: (name, id, nigts, charge, company name)");
        G[0] = new CorporateGuest(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.next());

        System.out.println("Enter Regular Guest: (name,id,nigts,charge)");
        G[1] = new RegularGuest(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());


        System.out.println("Enter Premium Guest: (name,id,nigts,charge,points)");
        G[2] = new PremiumGuest(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.nextDouble());

        System.out.println("Enter Corporate Guest: (name, id, nigts, charge, company name)");
        G[3] = new CorporateGuest(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.next());

        for (Guest i : G) {
            i.processBooking();
        }
        for (Guest i : G) {
            i.showDetails();
        }
        System.out.println("Enter guest ID: ");
        int searchId = sc.nextInt();
         boolean found=false;
        for (Guest i : G) {
            if (i.getId() == searchId) {
                i.showDetails();
                found=true;
                break;
            }
        }
         if(!found){
             System.out.println("Not found.");
         }
        int confirmed = 0, cancelled = 0, priority = 0;

        for (Guest i : G) {
            if (i.getBookingStatus().equals("Confirmed")) {
                confirmed++;
            } else if (i.getBookingStatus().equals("Cancelled")) {
                cancelled++;
            }else if(i.getBookingStatus().equals("Priority Confirmed")){
                priority++;
            }
        }
        System.out.println("\n=====Summary=========");
        System.out.println("Confirmed: " + confirmed);
        System.out.println("Cancelled: " + cancelled);
        System.out.println("Priority Confirmed: " + priority);

    }
}