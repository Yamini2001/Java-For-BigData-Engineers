package JDBCPractice;
import java.sql.*;
import java.util.Scanner;

public class VehicleRentalManagement {

    static Scanner sc = new Scanner(System.in);

    // Database connection details
    static String url = "jdbc:mysql://localhost:3306/vehicle_rental";
    static String username = "root";
    static String password = "root";

    static Connection con;

    // Establish database connection
    public static void connect() {

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully.");

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }


    // 1. ADD VEHICLE
    public static void addVehicle() {

        try {

            System.out.println("Enter Vehicle ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Vehicle Number:");
            String number = sc.nextLine();

            // Check whether vehicle number already exists
            String checkQuery = "SELECT * FROM vehicle WHERE vehicle_number = ?";

            PreparedStatement ps1 = con.prepareStatement(checkQuery);

            ps1.setString(1, number);

            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                System.out.println("Vehicle number already registered.");
                return;
            }

            System.out.println("Enter Vehicle Model:");
            String model = sc.nextLine();

            System.out.println("Enter Vehicle Type:");
            String type = sc.nextLine();

            System.out.println("Enter Rental Rate:");
            double rate = sc.nextDouble();

            System.out.println("Enter Available Days:");
            int days = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Status:");
            String status = sc.nextLine();

            String query = "INSERT INTO vehicle VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, number);
            ps.setString(3, model);
            ps.setString(4, type);
            ps.setDouble(5, rate);
            ps.setInt(6, days);
            ps.setString(7, status);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Vehicle added successfully.");
            }

            ps1.close();
            ps.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error adding vehicle: " + e.getMessage());
        }
    }


    // 2. UPDATE VEHICLE
    public static void updateVehicle() {

        try {

            System.out.println("Enter Vehicle ID:");
            int id = sc.nextInt();
            sc.nextLine();

            // Check vehicle exists
            String checkQuery = "SELECT * FROM vehicle WHERE vehicle_id = ?";

            PreparedStatement ps1 = con.prepareStatement(checkQuery);

            ps1.setInt(1, id);

            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Vehicle not found.");
                rs.close();
                ps1.close();
                return;
            }

            System.out.println("Enter New Vehicle Model:");
            String model = sc.nextLine();

            System.out.println("Enter New Rental Rate:");
            double rate = sc.nextDouble();

            System.out.println("Enter New Available Days:");
            int days = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Status:");
            String status = sc.nextLine();

            String query = "UPDATE vehicle SET vehicle_model = ?, "
                    + "rental_rate = ?, available_days = ?, status = ? "
                    + "WHERE vehicle_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, model);
            ps.setDouble(2, rate);
            ps.setInt(3, days);
            ps.setString(4, status);
            ps.setInt(5, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Vehicle updated successfully.");
            } else {
                System.out.println("Vehicle not found.");
            }

            rs.close();
            ps1.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error updating vehicle: " + e.getMessage());
        }
    }


    // 3. DELETE VEHICLE
    public static void deleteVehicle() {

        try {

            System.out.println("Enter Vehicle ID:");
            int id = sc.nextInt();

            String query = "DELETE FROM vehicle WHERE vehicle_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Vehicle deleted successfully.");
            } else {
                System.out.println("Vehicle not found.");
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Error deleting vehicle: " + e.getMessage());
        }
    }


    // 4. FIND VEHICLE BY ID
    public static void findVehicleById() {

        try {

            System.out.println("Enter Vehicle ID:");
            int id = sc.nextInt();

            String query = "SELECT * FROM vehicle WHERE vehicle_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n----- VEHICLE DETAILS -----");

                System.out.println("Vehicle ID: "
                        + rs.getInt("vehicle_id"));

                System.out.println("Vehicle Number: "
                        + rs.getString("vehicle_number"));

                System.out.println("Vehicle Model: "
                        + rs.getString("vehicle_model"));

                System.out.println("Vehicle Type: "
                        + rs.getString("vehicle_type"));

                System.out.println("Rental Rate: "
                        + rs.getDouble("rental_rate"));

                System.out.println("Available Days: "
                        + rs.getInt("available_days"));

                System.out.println("Status: "
                        + rs.getString("status"));

            } else {
                System.out.println("Vehicle not found.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error finding vehicle: " + e.getMessage());
        }
    }


    // 5. DISPLAY ALL VEHICLES
    public static void displayAllVehicles() {

        try {

            String query = "SELECT * FROM vehicle";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== VEHICLE RECORDS ==========");

            System.out.printf("%-10s %-15s %-15s %-10s %-12s %-8s %-12s%n",
                    "ID", "Number", "Model", "Type",
                    "Rate", "Days", "Status");

            System.out.println("--------------------------------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-10d %-15s %-15s %-10s %-12.2f %-8d %-12s%n",
                        rs.getInt("vehicle_id"),
                        rs.getString("vehicle_number"),
                        rs.getString("vehicle_model"),
                        rs.getString("vehicle_type"),
                        rs.getDouble("rental_rate"),
                        rs.getInt("available_days"),
                        rs.getString("status"));
            }

            if (!found) {
                System.out.println("No vehicle records available.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error displaying vehicles: " + e.getMessage());
        }
    }


    // 6. CALCULATE RENTAL ESTIMATE
    public static void calculateRentalEstimate() {

        try {

            System.out.println("Enter Vehicle ID:");
            int id = sc.nextInt();

            String query = "SELECT * FROM vehicle WHERE vehicle_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String status = rs.getString("status");

                if (status.equalsIgnoreCase("Available")) {

                    System.out.println("Enter Number of Rental Days:");
                    int rentalDays = sc.nextInt();

                    int availableDays = rs.getInt("available_days");

                    if (rentalDays > 0 && rentalDays <= availableDays) {

                        double rate = rs.getDouble("rental_rate");

                        double total = rate * rentalDays;

                        System.out.println("\n----- RENTAL ESTIMATE -----");

                        System.out.println("Vehicle Model: "
                                + rs.getString("vehicle_model"));

                        System.out.println("Rental Rate Per Day: " + rate);

                        System.out.println("Rental Days: " + rentalDays);

                        System.out.println("Total Rental Amount: " + total);

                    } else {
                        System.out.println("Invalid rental days or insufficient availability.");
                    }

                } else {
                    System.out.println("Vehicle is currently not available.");
                }

            } else {
                System.out.println("Vehicle not found.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error calculating estimate: " + e.getMessage());
        }
    }


    // MAIN METHOD
    public static void main(String[] args) {

        connect();

        if (con == null) {
            System.out.println("Unable to start application.");
            return;
        }

        int choice;

        do {

            System.out.println("\n===== VEHICLE RENTAL MANAGEMENT =====");

            System.out.println("1. Add Vehicle");
            System.out.println("2. Update Vehicle");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. Find Vehicle by ID");
            System.out.println("5. Display All Vehicles");
            System.out.println("6. Calculate Rental Estimate");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addVehicle();
                    break;

                case 2:
                    updateVehicle();
                    break;

                case 3:
                    deleteVehicle();
                    break;

                case 4:
                    findVehicleById();
                    break;

                case 5:
                    displayAllVehicles();
                    break;

                case 6:
                    calculateRentalEstimate();
                    break;

                case 7:
                    System.out.println("Thank you for using Vehicle Rental Management System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        try {
            con.close();
            sc.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
