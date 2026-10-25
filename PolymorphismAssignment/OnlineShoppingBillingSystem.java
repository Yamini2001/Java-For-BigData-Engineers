package PolymorphismAssignment;
import java.util.Scanner;
class Billing{
	public double calculateBill(double price) {
		return price;
	}
	public double calculateBill(double price,int quantity) {
		return price * quantity;
		
	}
	public double calculateBill(double price,int quantity,double discount) {
		return price * quantity -discount;
	}
	
}
public class OnlineShoppingBillingSystem {
	public static void main(String[] args) {
		Billing b = new Billing();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of price: ");
		double price = sc.nextDouble();
		System.out.println("Enter the value of quantity: ");
		int quantity = sc.nextInt();
		System.out.println("Enter the value of discount: ");
		double discount = sc.nextDouble();
		System.out.println(b.calculateBill(price));
		System.out.println(b.calculateBill(price, quantity));
		System.out.println(b.calculateBill(price, quantity, discount));
		
	}

}
