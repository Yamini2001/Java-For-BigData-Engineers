package JavaAssignment2;
import java.util.Scanner;

public class ElectricityBillCalculation {
    
    // Method to calculate the bill based on consumption slabs
    public static int calculateBill(int units) {
        int ratePerUnit;
        
        // Check slabs in descending order
        if (units >= 300) {
            ratePerUnit = 7;
        } 
        else if (units >= 200) {
            ratePerUnit = 5;
        } 
        else if (units >= 100) {
            ratePerUnit = 3;
        } 
        else {
            ratePerUnit = 2;
        }
        
        // Calculate total bill (units * rate)
        return units * ratePerUnit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total units consumed: ");
        int total_consumed = sc.nextInt();
        
        // Call the method and store the result
        int bill_amount = calculateBill(total_consumed);
        
        System.out.println("Total bill amount: ₹" + bill_amount);
        

    }
}