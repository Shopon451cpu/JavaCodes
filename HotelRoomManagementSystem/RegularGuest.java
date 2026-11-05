package HotelRoomManagementSystem;

class RegularGuest extends Guest {
    RegularGuest(String name, int id, int NofN, double chargePerNight) {
        super(name,id,NofN,chargePerNight);
    }

    @Override
    public void processBooking() {
       if(getNofN()>=2){
         setStatus("Confirmed");
       }else{
           setStatus("Cancelled");
       }
    }

    @Override
     public void showDetails() {
        System.out.println("________________regular Guest___________________");
        showInfo();
    }
}
