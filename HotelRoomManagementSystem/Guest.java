package HotelRoomManagementSystem;

abstract class Guest {
    private String name;
    private int id;
    private int NofN;
    private double chargePerNight;
    private String bookingStatus;

    Guest(String name, int id, int NofN, double chargePerNight){
        this.name=name;
        this.id=id;
        this.NofN=NofN;
        this.chargePerNight=chargePerNight;
        this.bookingStatus="pending";
    }
    void setStatus(String bookingStatus){
        this.bookingStatus=bookingStatus;
    }

    public void showInfo(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Number of Nights: "+NofN);
        System.out.println("Charge per Night: "+chargePerNight);
        System.out.println("Booking status: "+bookingStatus);
    }
    abstract void showDetails();
    abstract void processBooking();

     int getNofN(){
         return NofN;
     }
     double getChargePerNight(){
         return chargePerNight;
     }
     int getId(){
         return id;
     }
     String getBookingStatus(){
         return bookingStatus;
     }

}
