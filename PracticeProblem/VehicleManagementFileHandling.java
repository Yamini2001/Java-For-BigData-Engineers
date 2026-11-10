package JavaPractice;
import java.io.*;
import java.util.*;

// STEP 1: MODEL CLASS

class VehicleRental implements Serializable {

    private static final long serialVersionUID = 1L;

    int rentalId;
    String customerName;
    String vehicleType;
    String vehicleNumber;
    String pickupLocation;
    String dropLocation;
    int rentalDays;
    double rentPerDay;
    double totalAmount;
    String rentalStatus;

    // Constructor
    VehicleRental(int rentalId, String customerName,
            String vehicleType, String vehicleNumber,
            String pickupLocation, String dropLocation,
            int rentalDays, double rentPerDay,
            String rentalStatus) {

        this.rentalId = rentalId;
        this.customerName = customerName;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.rentalDays = rentalDays;
        this.rentPerDay = rentPerDay;
        this.totalAmount = rentalDays * rentPerDay;
        this.rentalStatus = rentalStatus;
    }

    // Display method
    void display() {
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Customer: " + customerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Pickup: " + pickupLocation);
        System.out.println("Drop: " + dropLocation);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Rent Per Day: " + rentPerDay);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Status: " + rentalStatus);
        System.out.println("-------------------------");
    }
}


// STEP 2: MANAGEMENT CLASS

public class VehicleManagement {

    static Scanner sc = new Scanner(System.in);

    static String filename = "rental.dat";


    // STEP 3: READ EXISTING OBJECTS FROM FILE

    static ArrayList<VehicleRental> readRentals() {

        ArrayList<VehicleRental> rentals = new ArrayList<>();

        File file = new File(filename);

        if (!file.exists() || file.length() == 0) {
            return rentals;
        }

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(file))) {

            rentals = (ArrayList<VehicleRental>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return rentals;
    }


    // STEP 4: WRITE OBJECTS INTO FILE

    static void writeRentals(ArrayList<VehicleRental> rentals) {

        try (ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(filename))) {

            oos.writeObject(rentals);

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }


    // STEP 5: ADD NEW RENTAL

    static void addRental() {

        ArrayList<VehicleRental> rentals = readRentals();

        System.out.println("Enter Rental ID:");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (VehicleRental v : rentals) {
            if (v.rentalId == id) {
                System.out.println("Rental ID already exists.");
                return;
            }
        }

        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();

        System.out.println("Enter Vehicle Type:");
        String type = sc.nextLine();

        System.out.println("Enter Vehicle Number:");
        String number = sc.nextLine();

        System.out.println("Enter Pickup Location:");
        String pickup = sc.nextLine();

        System.out.println("Enter Drop Location:");
        String drop = sc.nextLine();

        System.out.println("Enter Rental Days:");
        int days = sc.nextInt();

        System.out.println("Enter Rent Per Day:");
        double rent = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter Rental Status:");
        String status = sc.nextLine();

        VehicleRental v = new VehicleRental(
                id, name, type, number,
                pickup, drop, days, rent, status
        );

        rentals.add(v);

        writeRentals(rentals);
    }


    // STEP 6: DISPLAY ALL RENTALS

    static void displayAllRentals() {

        ArrayList<VehicleRental> rentals = readRentals();

        if (rentals.isEmpty()) {
            System.out.println("No rental records found.");
            return;
        }

        for (VehicleRental v : rentals) {
            v.display();
        }
    }


    // SEARCH RENTAL BY ID

    static void searchRental() {

        ArrayList<VehicleRental> rentals = readRentals();

        System.out.println("Enter Rental ID to search:");
        int id = sc.nextInt();

        for (VehicleRental v : rentals) {

            if (v.rentalId == id) {
                System.out.println("Rental Found:");
                v.display();
                return;
            }
        }

        System.out.println("Rental not found.");
    }


    // UPDATE RENTAL DETAILS

    static void updateRental() {

        ArrayList<VehicleRental> rentals = readRentals();

        System.out.println("Enter Rental ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        for (VehicleRental v : rentals) {

            if (v.rentalId == id) {

                System.out.println("Enter New Drop Location:");
                v.dropLocation = sc.nextLine();

                System.out.println("Enter New Rental Days:");
                v.rentalDays = sc.nextInt();

                System.out.println("Enter New Rent Per Day:");
                v.rentPerDay = sc.nextDouble();
                sc.nextLine();

                // Recalculate total amount
                v.totalAmount = v.rentalDays * v.rentPerDay;

                System.out.println("Enter New Status:");
                v.rentalStatus = sc.nextLine();

                writeRentals(rentals);

                System.out.println("Rental updated successfully.");
                return;
            }
        }

        System.out.println("Rental not found.");
    }


    // DELETE RENTAL

    static void deleteRental() {

        ArrayList<VehicleRental> rentals = readRentals();

        System.out.println("Enter Rental ID to delete:");
        int id = sc.nextInt();

        boolean removed = rentals.removeIf(
                v -> v.rentalId == id
        );

        if (removed) {
            writeRentals(rentals);
            System.out.println("Rental deleted successfully.");
        } else {
            System.out.println("Rental not found.");
        }
    }


    // STEP 7: GENERATE RENTAL REPORT

    static void generateRentalReport() {

        ArrayList<VehicleRental> rentals = readRentals();

        int completedCount = 0;
        double totalRevenue = 0;
        double highestAmount = 0;

        for (VehicleRental v : rentals) {

            if (v.rentalStatus.equalsIgnoreCase("Completed")) {

                completedCount++;
                totalRevenue += v.totalAmount;
            }

            if (v.totalAmount > highestAmount) {
                highestAmount = v.totalAmount;
            }
        }

        System.out.println("Completed Rentals: " + completedCount);
        System.out.println("Total Revenue: " + totalRevenue);
        System.out.println("Highest Rental Amount: " + highestAmount);
    }


    // STEP 8: MAIN MENU

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== VEHICLE RENTAL SYSTEM =====");
            System.out.println("1. Add Rental");
            System.out.println("2. Display All Rentals");
            System.out.println("3. Search Rental");
            System.out.println("4. Update Rental");
            System.out.println("5. Delete Rental");
            System.out.println("6. Generate Report");
            System.out.println("7. Exit");

            System.out.println("Enter Your Choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addRental();
                    break;

                case 2:
                    displayAllRentals();
                    break;

                case 3:
                    searchRental();
                    break;

                case 4:
                    updateRental();
                    break;

                case 5:
                    deleteRental();
                    break;

                case 6:
                    generateRentalReport();
                    break;

                case 7:
                    System.out.println("Exiting Application...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}