package JavaAssignment2;
import java.util.Scanner;

public class BusTicketFare {

    // Static method to calculate fare based on age and return the value
    public static int calculateFare(int age) {
        if (age < 5) {
            return 0; // Free
        } 
        else if (age >= 5 && age <= 12) {
            return 20;
        } 
        else if (age >= 13 && age <= 59) {
            return 40;
        } 
        else {
            return 25; // 60 and above
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter passenger age: ");
        int age = sc.nextInt();
        
        // Pass age to the static method and store the returned fare
        int fare = calculateFare(age);
        
        // Display passenger name, age, and fare
        System.out.println("\n--- Bus Ticket Details ---");
        System.out.println("Passenger Name: " + name);
        System.out.println("Passenger Age: " + age);
        
        if (fare == 0) {
            System.out.println("Ticket Fare: Free");
        } else {
            System.out.println("Ticket Fare: ₹" + fare);
        }
        
    }
}