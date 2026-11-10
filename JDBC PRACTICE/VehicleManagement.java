
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VehicleManagement {

    // One Scanner shared by all methods
    static Scanner sc = new Scanner(System.in);

    // Database connection details
    static String url = "jdbc:mysql://localhost:3306/vehicle_rental";
    static String username = "root";
    static String password = "Yamini.2001.k";

    // Common database connection method
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Common method to display vehicle details
    public static void displayVehicle(ResultSet rs) throws SQLException {

        System.out.println("-----------------------------------");
        System.out.println("Vehicle ID       : " + rs.getInt("vehicle_id"));
        System.out.println("Vehicle Number   : " + rs.getString("vehicle_number"));
        System.out.println("Vehicle Model    : " + rs.getString("vehicle_model"));
        System.out.println("Vehicle Type     : " + rs.getString("vehicle_type"));
        System.out.println("Rental Rate      : " + rs.getDouble("rental_rate"));
        System.out.println("Available Days   : " + rs.getInt("available_days"));
        System.out.println("Status           : " + rs.getString("status"));
        System.out.println("-----------------------------------");
    }

    // 1. ADD VEHICLE
    public static void addVehicle() throws SQLException {

        System.out.println("\nEnter vehicle ID:");
        int vehicle_id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vehicle number:");
        String vehicle_number = sc.nextLine();

        System.out.println("Enter vehicle model:");
        String vehicle_model = sc.nextLine();

        System.out.println("Enter vehicle type:");
        String vehicle_type = sc.nextLine();

        System.out.println("Enter rental rate:");
        double rental_rate = sc.nextDouble();

        System.out.println("Enter available days:");
        int available_days = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter status:");
        String status = sc.nextLine();

        try (Connection con = getConnection()) {

            // Check duplicate vehicle number
            String checkQuery =
                    "SELECT * FROM vehicle WHERE vehicle_number = ?";

            try (PreparedStatement checkPst =
                    con.prepareStatement(checkQuery)) {

                checkPst.setString(1, vehicle_number);

                try (ResultSet rs = checkPst.executeQuery()) {

                    if (rs.next()) {
                        System.out.println("Vehicle number already exists.");
                        return;
                    }
                }
            }

            // Insert vehicle details
            String insertQuery =
                    "INSERT INTO vehicle VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst =
                    con.prepareStatement(insertQuery)) {

                pst.setInt(1, vehicle_id);
                pst.setString(2, vehicle_number);
                pst.setString(3, vehicle_model);
                pst.setString(4, vehicle_type);
                pst.setDouble(5, rental_rate);
                pst.setInt(6, available_days);
                pst.setString(7, status);

                int rows = pst.executeUpdate();

                if (rows > 0) {
                    System.out.println("Vehicle added successfully.");
                }
            }
        }
    }

    // 2. UPDATE VEHICLE
    public static void updateVehicle() throws SQLException {

        System.out.println("\nEnter vehicle ID to update:");
        int vehicle_id = sc.nextInt();
        sc.nextLine();

        try (Connection con = getConnection()) {

            // First check whether vehicle exists
            String checkQuery =
                    "SELECT * FROM vehicle WHERE vehicle_id = ?";

            try (PreparedStatement checkPst =
                    con.prepareStatement(checkQuery)) {

                checkPst.setInt(1, vehicle_id);

                try (ResultSet rs = checkPst.executeQuery()) {

                    if (!rs.next()) {
                        System.out.println("Vehicle not found.");
                        return;
                    }
                }
            }

            // Accept new details only if vehicle exists
            System.out.println("Enter new vehicle model:");
            String vehicle_model = sc.nextLine();

            System.out.println("Enter new rental rate:");
            double rental_rate = sc.nextDouble();

            System.out.println("Enter new available days:");
            int available_days = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter new status:");
            String status = sc.nextLine();

            // Update query
            String query =
                    "UPDATE vehicle SET vehicle_model = ?, " +
                    "rental_rate = ?, available_days = ?, " +
                    "status = ? WHERE vehicle_id = ?";

            try (PreparedStatement pst =
                    con.prepareStatement(query)) {

                pst.setString(1, vehicle_model);
                pst.setDouble(2, rental_rate);
                pst.setInt(3, available_days);
                pst.setString(4, status);
                pst.setInt(5, vehicle_id);

                int rows = pst.executeUpdate();

                if (rows > 0) {
                    System.out.println("Vehicle updated successfully.");
                } else {
                    System.out.println("Vehicle not updated.");
                }
            }
        }
    }

    // 3. DELETE VEHICLE
    public static void deleteVehicle() throws SQLException {

        System.out.println("\nEnter vehicle ID to delete:");
        int vehicle_id = sc.nextInt();

        String query =
                "DELETE FROM vehicle WHERE vehicle_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, vehicle_id);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Vehicle deleted successfully.");
            } else {
                System.out.println("Vehicle not found.");
            }
        }
    }

    // 4. FIND VEHICLE BY ID
    public static void findVehicleById() throws SQLException {

        System.out.println("\nEnter vehicle ID to search:");
        int vehicle_id = sc.nextInt();

        String query =
                "SELECT * FROM vehicle WHERE vehicle_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, vehicle_id);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    System.out.println("\nVehicle found:");
                    displayVehicle(rs);
                } else {
                    System.out.println("Vehicle not found.");
                }
            }
        }
    }

    // 5. DISPLAY ALL VEHICLES
    public static void displayAllVehicles() throws SQLException {

        String query = "SELECT * FROM vehicle";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            boolean found = false;

            System.out.println("\n========== ALL VEHICLES ==========");

            while (rs.next()) {
                found = true;
                displayVehicle(rs);
            }

            if (!found) {
                System.out.println("No vehicle records found.");
            }
        }
    }

    // 6. CALCULATE RENTAL ESTIMATE
    public static void calculateRentalEstimate() throws SQLException {

        System.out.println("\nEnter vehicle ID:");
        int vehicle_id = sc.nextInt();

        System.out.println("Enter number of rental days:");
        int rental_days = sc.nextInt();

        String query =
                "SELECT rental_rate, available_days, status " +
                "FROM vehicle WHERE vehicle_id = ?";

        try (Connection con = getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, vehicle_id);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    double rental_rate = rs.getDouble("rental_rate");
                    int available_days = rs.getInt("available_days");
                    String status = rs.getString("status");

                    if (!status.equalsIgnoreCase("Available")) {
                        System.out.println("Vehicle is currently not available.");
                    } else if (rental_days <= 0 ||
                               rental_days > available_days) {
                        System.out.println("Invalid rental days or insufficient availability.");
                    } else {

                        double total_amount = rental_rate * rental_days;

                        System.out.println("\n===== RENTAL ESTIMATE =====");
                        System.out.println("Vehicle ID       : " + vehicle_id);
                        System.out.println("Rental Rate/Day  : " + rental_rate);
                        System.out.println("Rental Days      : " + rental_days);
                        System.out.println("Total Amount     : " + total_amount);
                    }

                } else {
                    System.out.println("Vehicle not found.");
                }
            }
        }
    }

    // 7. MAIN METHOD
    public static void main(String[] args) {

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

            try {

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
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (SQLException e) {
                System.out.println("Database operation failed.");
                e.printStackTrace();
            }

        } while (choice != 7);

        sc.close();
    }
}
