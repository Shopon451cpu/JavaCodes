package HotelRoomManagementSystem;

class PremiumGuest extends Guest {
    private double membershipPoints;
    PremiumGuest(String name, int id, int NofN, double chargePerNight,double membershipPoints) {
        super(name, id, NofN, chargePerNight);
        this.membershipPoints=membershipPoints;
    }

    @Override
    void processBooking() {
        if(membershipPoints>=5000.00){
            setStatus("Priority Confirmed.");
        }else{
            setStatus("Confirmed");
        }
    }

    @Override
    void showDetails() {
        System.out.println("__________________Premium Guest_____________________");
        showInfo();
        System.out.println("Membership points: "+membershipPoints);
    }
}
