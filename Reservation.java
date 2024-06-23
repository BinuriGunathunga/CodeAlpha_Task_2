public class Reservation {
    private Room room;
    private String guestName;
    private int nights;
    private double amountPaid;

    public Reservation(Room room, String guestName, int nights, double amountPaid) {
        this.room = room;
        this.guestName = guestName;
        this.nights = nights;
        this.amountPaid = amountPaid;
        room.setAvailable(false); // Mark room as unavailable
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getNights() {
        return nights;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}
