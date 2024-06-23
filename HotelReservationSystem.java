import java.util.List;
import java.util.Scanner;


public class HotelReservationSystem  {
    public static void main(String[] args) {

        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        // Adding some rooms
        hotel.addRoom(new Room(101, "Single"));
        hotel.addRoom(new Room(102, "Double"));
        hotel.addRoom(new Room(206, "Single"));
        hotel.addRoom(new Room(204, "Suite"));



        int choice;
        do {

            System.out.println("");
            System.out.println("------Hotel Reservation System Menu-----");

            System.out.println("");

            System.out.println("1. Search available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View bookings");
            System.out.println("4. Exit");
            System.out.println("");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("");




            switch (choice) {

                case 1:

                    System.out.print("-----Enter room category to search (Single/Double/Suite-----): ");
                    System.out.println("");
                    String category = scanner.next();
                    List<Room> availableRooms = hotel.getAvailableRooms(category);
                    System.out.println("");



                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms in this category.");
                    } else {
                        System.out.println("Available rooms:");
                        System.out.println("");

                        for (Room room : availableRooms) {
                            System.out.println("Room Number: " + room.getRoomNumber());
                        }
                    }
                    break;

                case 2:
                    System.out.print("-----Enter room number to reserve: ------");
                    System.out.println("");
                    
                
                    int roomNumber = scanner.nextInt();
                    Room roomToReserve = null;
                    System.out.println("");

                    for (Room room : hotel.getAvailableRooms("")) {
                        if (room.getRoomNumber() == roomNumber) {
                            roomToReserve = room;
                            break;
                        }
                    }

                    if (roomToReserve == null || !roomToReserve.isAvailable()) {
                        System.out.println("Room not available!!!...");
                    } else {
                        System.out.print("Enter guest name: ");
                        System.out.print("");                       
                        String guestName = scanner.next();
                        System.out.println("");


                        System.out.print("Enter number of nights: ");
                        int nights = scanner.nextInt();
                        System.out.println("");
                       


                        System.out.print("Enter amount to pay: ");
                        System.out.print("");

                        double amountPaid = scanner.nextDouble();


                        if (Payment.processPayment(amountPaid)) {
                            Reservation reservation = hotel.makeReservation(roomToReserve, guestName, nights, amountPaid);

                            System.out.println("");
                            System.out.println("Reservation successful for Room " + reservation.getRoom().getRoomNumber()+ "......!!!");
                            System.out.println("");
                        } else {
                            System.out.println("Payment failed. Reservation not made.!!!");
                            System.out.println("");
                        }
                    }
                    break;

                case 3:

                    List<Reservation> reservations = hotel.getReservations();
                    if (reservations.isEmpty()) {
                        System.out.println("No bookings found......");
                    } else {
                        System.out.println("");
                        System.out.println("---Bookings:--- ");
                        System.out.println("");

                        for (Reservation reservation : reservations) {
                            System.out.println("Room Number: " + reservation.getRoom().getRoomNumber() +
                                               ", Guest Name: " + reservation.getGuestName() +
                                               ", Nights: " + reservation.getNights() +
                                               ", Amount Paid: $" + reservation.getAmountPaid());

                           
                          System.out.println("");
                        }
                    }
                    break;

                case 4:

                    System.out.println("");
                    System.out.println("Exiting...");
                    System.out.println("");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
