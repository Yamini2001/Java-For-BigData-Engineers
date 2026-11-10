
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

// VehicleService class
class VehicleService {

    int serviceId;
    String vehicleNumber;
    String ownerName;
    String vehicleType;
    String serviceType;
    double serviceCost;
    String serviceStatus;

    // Parameterized constructor
    public VehicleService(int serviceId, String vehicleNumber,
            String ownerName, String vehicleType,
            String serviceType, double serviceCost,
            String serviceStatus) {

        this.serviceId = serviceId;
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.serviceType = serviceType;
        this.serviceCost = serviceCost;
        this.serviceStatus = serviceStatus;
    }

    // Display method
    public void display() {

        System.out.println("----------------------------------");
        System.out.println("Service ID     : " + serviceId);
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Service Type   : " + serviceType);
        System.out.println("Service Cost   : " + serviceCost);
        System.out.println("Service Status : " + serviceStatus);
        System.out.println("----------------------------------");
    }
}


// Main class
public class VehicleServiceManagement {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<VehicleService> services = new ArrayList<>();

    // 1. Add Service
    public static void addService() {

        System.out.println("Enter Service ID:");
        int serviceId = sc.nextInt();
        sc.nextLine();

        // Check unique service ID
        for (VehicleService v : services) {

            if (v.serviceId == serviceId) {
                System.out.println("Service ID already exists.");
                return;
            }
        }

        System.out.println("Enter Vehicle Number:");
        String vehicleNumber = sc.nextLine();

        System.out.println("Enter Owner Name:");
        String ownerName = sc.nextLine();

        System.out.println("Enter Vehicle Type (Car/Bike/SUV):");
        String vehicleType = sc.nextLine();

        System.out.println("Enter Service Type:");
        String serviceType = sc.nextLine();

        System.out.println("Enter Service Cost:");
        double serviceCost = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter Service Status (Pending/In Progress/Completed):");
        String serviceStatus = sc.nextLine();

        VehicleService v = new VehicleService(
                serviceId, vehicleNumber, ownerName,
                vehicleType, serviceType, serviceCost,
                serviceStatus);

        services.add(v);

        System.out.println("Service added successfully.");
    }


    // Display All Services
    public static void displayAllServices() {

        if (services.isEmpty()) {
            System.out.println("No service records available.");
            return;
        }

        for (VehicleService v : services) {
            v.display();
        }
    }


    // 2. Search Service By Vehicle Number
    public static void searchByVehicleNumber() {

        System.out.println("Enter Vehicle Number:");
        String searchNumber = sc.nextLine();

        boolean found = false;

        for (VehicleService v : services) {

            if (v.vehicleNumber.equalsIgnoreCase(searchNumber)) {

                v.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Service record not found.");
        }
    }


    // 3. Update Service
    public static void updateService() {

        System.out.println("Enter Service ID:");
        int searchId = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (VehicleService v : services) {

            if (v.serviceId == searchId) {

                System.out.println("Enter New Service Type:");
                v.serviceType = sc.nextLine();

                System.out.println("Enter New Service Cost:");
                v.serviceCost = sc.nextDouble();
                sc.nextLine();

                System.out.println("Enter New Service Status:");
                v.serviceStatus = sc.nextLine();

                System.out.println("Service updated successfully.");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Service record not found.");
        }
    }


    // 4. Remove Service
    public static void removeService() {

        System.out.println("Enter Service ID:");
        int searchId = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (VehicleService v : services) {

            if (v.serviceId == searchId) {

                services.remove(v);

                System.out.println("Service removed successfully.");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Service record not found.");
        }
    }


    // 5. Sort Services By Cost (Descending)
    public static void sortByServiceCost() {

        services.sort(
            Comparator.comparingDouble(
                (VehicleService v) -> v.serviceCost
            ).reversed()
        );

        System.out.println("Services sorted by cost in descending order.");

        displayAllServices();
    }


    // 6. Generate Service Report
    public static void generateServiceReport() {

        double totalRevenue = 0;

        double highestCost = -1;

        String highestVehicle = "No vehicle";

        if (services.isEmpty()) {
            System.out.println("No service records available.");
            return;
        }

        for (VehicleService v : services) {

            // Calculate revenue from completed services
            if (v.serviceStatus.equalsIgnoreCase("Completed")) {

                totalRevenue = totalRevenue + v.serviceCost;
            }

            // Find highest service cost
            if (v.serviceCost > highestCost) {

                highestCost = v.serviceCost;

                highestVehicle = v.vehicleNumber;
            }
        }

        System.out.println("========== SERVICE REPORT ==========");

        System.out.println("Total Revenue from Completed Services: "
                + totalRevenue);

        System.out.println("Vehicle with Highest Service Cost: "
                + highestVehicle);

        System.out.println("Highest Service Cost: " + highestCost);

        System.out.println("====================================");
    }


    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n===== VEHICLE SERVICE MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Service");
            System.out.println("2. Display All Services");
            System.out.println("3. Search By Vehicle Number");
            System.out.println("4. Update Service");
            System.out.println("5. Remove Service");
            System.out.println("6. Sort By Service Cost");
            System.out.println("7. Generate Service Report");
            System.out.println("8. Exit");

            System.out.println("Enter your choice:");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addService();
                    break;

                case 2:
                    displayAllServices();
                    break;

                case 3:
                    searchByVehicleNumber();
                    break;

                case 4:
                    updateService();
                    break;

                case 5:
                    removeService();
                    break;

                case 6:
                    sortByServiceCost();
                    break;

                case 7:
                    generateServiceReport();
                    break;

                case 8:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}
