package JavaAssignment2;
import java.util.Scanner;

public class MobileDataUsage {

    // Static method to calculate charge based on data usage and return the result
    public static double calculateCharge(double dataUsage) {
        if (dataUsage <= 1.0) {
            return 50.0;
        } 
        else if (dataUsage <= 5.0) {
            return 100.0;
        } 
        else if (dataUsage <= 10.0) {
            return 200.0;
        } 
        else {
            return 350.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter mobile number: ");
        long mobileNumber = sc.nextLong();
        
        System.out.print("Enter data usage (in GB): ");
        double dataUsage = sc.nextDouble();
        
        // Pass data usage to the static method and store the returned charge
        double finalCharge = calculateCharge(dataUsage);
        
        // Display mobile number, data usage, and final charge
        System.out.println("\n--- Mobile Data Usage Details ---");
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Data Usage: " + dataUsage + " GB");
        System.out.println("Final Charge: ₹" + finalCharge);
        
    }
}