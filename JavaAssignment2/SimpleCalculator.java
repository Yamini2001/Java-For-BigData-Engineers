package JavaAssignment2;
import java.util.Scanner;

public class SimpleCalculator {

    // Static method to perform the calculation based on the operator
    public static double calculate(double num1, double num2, char operator) {
        if (operator == '+') {
            return num1 + num2;
        } 
        else if (operator == '-') {
            return num1 - num2;
        } 
        else if (operator == '*') {
            return num1 * num2;
        } 
        else if (operator == '/') {
            // Handle division by zero using a conditional statement
            if (num2 == 0) {
                System.out.println("Error: Division by zero is not allowed.");
                return 0.0; // Returning 0 as a default fallback
            } else {
                return num1 / num2;
            }
        } 
        else {
            System.out.println("Error: Invalid operator entered.");
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);
        
        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();
        
        // Pass all three values to the static method and store the result
        double result = calculate(num1, num2, operator);
        
        System.out.println("Result: " + result);
        
    }
}