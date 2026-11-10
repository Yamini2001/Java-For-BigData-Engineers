package JavaPractice;
abstract class Booking {

    int bookingId;
    String passengerName;
    String source;
    String destination;
    int numberOfPassengers;

    static int totalBookings = 0;

    Booking(int bookingId, String passengerName, String source,
            String destination, int numberOfPassengers) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;

        totalBookings++;
    }

    void displayBookingDetails() {

        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Number of Passengers: " + numberOfPassengers);
    }

    abstract double calculateFare();
}


// Interface
interface DiscountApplicable {

    double calculateDiscount(double fare);
}


// BusBooking Class
class BusBooking extends Booking implements DiscountApplicable {

    String busNumber;
    String busType;
    int seatNumber;
    double farePerPassenger;

    BusBooking(int bookingId, String passengerName, String source,
               String destination, int numberOfPassengers,
               String busNumber, String busType, int seatNumber,
               double farePerPassenger) {

        super(bookingId, passengerName, source, destination,
              numberOfPassengers);

        this.busNumber = busNumber;
        this.busType = busType;
        this.seatNumber = seatNumber;
        this.farePerPassenger = farePerPassenger;
    }

    @Override
    double calculateFare() {

        return farePerPassenger * numberOfPassengers;
    }

    @Override
    public double calculateDiscount(double fare) {

        if (numberOfPassengers >= 4) {
            return fare * 0.10;
        }

        return 0;
    }

    void displayBusDetails() {

        displayBookingDetails();

        System.out.println("Bus Number: " + busNumber);
        System.out.println("Bus Type: " + busType);
        System.out.println("Seat Number: " + seatNumber);

        double fare = calculateFare();
        double discount = calculateDiscount(fare);

        System.out.println("Total Fare: " + fare);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + (fare - discount));
    }
}


// TrainBooking Class
class TrainBooking extends Booking implements DiscountApplicable {

    String trainNumber;
    String trainName;
    String coachType;
    int berthNumber;
    double farePerPassenger;

    TrainBooking(int bookingId, String passengerName, String source,
                 String destination, int numberOfPassengers,
                 String trainNumber, String trainName,
                 String coachType, int berthNumber,
                 double farePerPassenger) {

        super(bookingId, passengerName, source, destination,
              numberOfPassengers);

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.coachType = coachType;
        this.berthNumber = berthNumber;
        this.farePerPassenger = farePerPassenger;
    }

    @Override
    double calculateFare() {

        return farePerPassenger * numberOfPassengers;
    }

    @Override
    public double calculateDiscount(double fare) {

        if (numberOfPassengers >= 3) {
            return fare * 0.05;
        }

        return 0;
    }

    void displayTrainDetails() {

        displayBookingDetails();

        System.out.println("Train Number: " + trainNumber);
        System.out.println("Train Name: " + trainName);
        System.out.println("Coach Type: " + coachType);
        System.out.println("Berth Number: " + berthNumber);

        double fare = calculateFare();
        double discount = calculateDiscount(fare);

        System.out.println("Total Fare: " + fare);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + (fare - discount));
    }
}


// Main Class
public class TravelBookingManagement {

    public static void main(String[] args) {

        // Creating 2 BusBooking objects

        BusBooking b1 = new BusBooking(
            101, "Yamini", "Delhi", "Jaipur",
            4, "B101", "AC Sleeper", 12, 500
        );

        BusBooking b2 = new BusBooking(
            102, "Priya", "Delhi", "Agra",
            2, "B102", "Non AC", 15, 300
        );


        // Creating 2 TrainBooking objects

        TrainBooking t1 = new TrainBooking(
            201, "Shreya", "Delhi", "Mumbai",
            3, "T101", "Rajdhani Express",
            "AC 3 Tier", 25, 1200
        );

        TrainBooking t2 = new TrainBooking(
            202, "Riya", "Delhi", "Chandigarh",
            2, "T102", "Shatabdi Express",
            "AC Chair Car", 10, 600
        );


        // Display Bus Booking 1

        System.out.println("\n===== BUS BOOKING 1 =====");
        b1.displayBusDetails();


        // Display Bus Booking 2

        System.out.println("\n===== BUS BOOKING 2 =====");
        b2.displayBusDetails();


        // Display Train Booking 1

        System.out.println("\n===== TRAIN BOOKING 1 =====");
        t1.displayTrainDetails();


        // Display Train Booking 2

        System.out.println("\n===== TRAIN BOOKING 2 =====");
        t2.displayTrainDetails();


        // Display Total Bookings

        System.out.println("\nTotal Bookings Created: "
                           + Booking.totalBookings);
    }
}
