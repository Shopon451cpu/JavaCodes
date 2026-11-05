package HotelRoomManagementSystem;

class CorporateGuest extends Guest {
      private String comName;

    CorporateGuest(String name, int id, int NofN, double chargePerNight, String comName) {
        super(name, id, NofN, chargePerNight);
        this.comName=comName;
    }

    @Override
    void processBooking() {
        if(getNofN()*getChargePerNight()<=15000.00){
            setStatus("Confirmed");
        }else{
            setStatus("Cancelled");
        }
    }

    @Override
    void showDetails() {
        System.out.println("___________________Corporate Guest________________________");
        showInfo();
        System.out.println("Company name: "+comName);
    }
}
