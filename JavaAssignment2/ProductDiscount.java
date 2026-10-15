package JavaAssignment2;
import java.util.Scanner;

public class ProductDiscount {

    // Method calculates and returns the final price to main
    public static double calculateFinalPrice(int purchase_amount) {
        double discountPercentage = 0;
        
        if (purchase_amount >= 10000) {
            discountPercentage = 0.20;
        } else if (purchase_amount >= 5000) {
            discountPercentage = 0.10;
        } else if (purchase_amount >= 2000) {
            discountPercentage = 0.05;
        } else {
            discountPercentage = 0.0;
        }
        
        double discountAmount = purchase_amount * discountPercentage;
        double finalPrice = purchase_amount - discountAmount;
        
        return finalPrice; // Returning the final price to main
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the Product ID (integer): ");
        int productID = sc.nextInt();
        
        // Consume the leftover newline character
        sc.nextLine(); 

        System.out.print("Enter the Product Name: ");
        String productName = sc.nextLine();

        System.out.print("Enter the Purchase Amount: ");
        int purchase_amount = sc.nextInt();

        // Call the method and store the returned final price
        double finalPrice = calculateFinalPrice(purchase_amount);

        System.out.println("\n--- Display Product Details ---");
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Original Purchase Amount: " + purchase_amount);
        System.out.println("Final Price to Pay: " + finalPrice);
        

    }
}