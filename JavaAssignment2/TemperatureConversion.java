package JavaAssignment2;
import java.util.Scanner;

public class TemperatureConversion {

    public static double convertTemperature(double celsius) {
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        return fahrenheit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        
        double fahrenheit = convertTemperature(celsius);
        
        System.out.println("Temperature in Fahrenheit: " + fahrenheit + "°F");
        
        // Check if the temperature is above 100°F using an if condition
        if (fahrenheit > 100) {
            System.out.println("Warning: The temperature is above 100°F!");
        } else {
            System.out.println("The temperature is 100°F or below.");
        }
        
    }
}