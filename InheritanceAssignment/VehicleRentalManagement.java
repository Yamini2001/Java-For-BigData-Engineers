
package InheritanceAssignment;

class RentalVehicle {
    String registrationNumber;
    String brand;
    double rentalRate;

    public RentalVehicle(String registrationNumber, String brand,
                         double rentalRate) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.rentalRate = rentalRate;
    }

    public void displayVehicle() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Brand: " + brand);
        System.out.println("Rental Rate Per Day: " + rentalRate);
    }
}

class CarRental extends RentalVehicle {
    int seats;
    double driverCharges;

    public CarRental(String registrationNumber, String brand,
                     double rentalRate, int seats,
                     double driverCharges) {
        super(registrationNumber, brand, rentalRate);
        this.seats = seats;
        this.driverCharges = driverCharges;
    }

    public double calculateRental(int days) {
        return (rentalRate + driverCharges) * days;
    }

    public void displayCarRental(int days) {
        displayVehicle();

        System.out.println("Number of Seats: " + seats);
        System.out.println("Driver Charges Per Day: " + driverCharges);
        System.out.println("Rental Days: " + days);
        System.out.println("Total Car Rental: " + calculateRental(days));
    }
}

class BikeRental extends RentalVehicle {
    int engineCapacity;
    double helmetCharges;

    public BikeRental(String registrationNumber, String brand,
                      double rentalRate, int engineCapacity,
                      double helmetCharges) {
        super(registrationNumber, brand, rentalRate);
        this.engineCapacity = engineCapacity;
        this.helmetCharges = helmetCharges;
    }

    public double calculateRental(int days) {
        return (rentalRate * days) + helmetCharges;
    }

    public void displayBikeRental(int days) {
        displayVehicle();

        System.out.println("Engine Capacity: " + engineCapacity + " CC");
        System.out.println("Helmet Charges: " + helmetCharges);
        System.out.println("Rental Days: " + days);
        System.out.println("Total Bike Rental: " + calculateRental(days));
    }
}

public class VehicleRentalManagement {
    public static void main(String[] args) {
        CarRental car = new CarRental(
                "HR26AB1234", "Hyundai", 2500.0, 5, 500.0
        );

        BikeRental bike = new BikeRental(
                "HR26XY5678", "Honda", 800.0, 150, 100.0
        );

        System.out.println("===== CAR RENTAL DETAILS =====");
        car.displayCarRental(3);

        System.out.println();

        System.out.println("===== BIKE RENTAL DETAILS =====");
        bike.displayBikeRental(3);
    }
}
