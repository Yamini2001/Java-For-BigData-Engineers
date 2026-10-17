package ClassessAndObjectsAssignment;
import java.util.Scanner;
class ElectricityBill{
	int consumerNumber;
	String consumerName;
	int units;
	public void read() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the consumer number: ");
		consumerNumber = sc.nextInt();
		System.out.println("Enter the consumer name: ");
		consumerName = sc.next();
		System.out.println("Enter the units: ");
		units = sc.nextInt();
		
	}
	public void display() {
		System.out.println("Enter the consumerNumber: "+consumerNumber);
		System.out.println("Enter the consumerName: "+consumerName);
		System.out.println("Enter the units: "+units);
	}
	public void calculateBill() {
		int total_bill = 0;
		 if (units <= 100) {
		        total_bill = units * 3;
		    }
		    else if (units <= 200) {
		        total_bill = (100 * 3) + ((units - 100) * 5);
		    }
		    else {
		        total_bill = (100 * 3) + (100 * 5)
		                     + ((units - 200) * 8);
		    }

		    System.out.println("Total Electricity Bill: ₹" + total_bill);
		
	}
	public String ElectricityBill() {
		// TODO Auto-generated method stub
		return null;
	}
}
public class ElectricityBillCalculation {
	public static void main(String[] args) {
		ElectricityBill eB1 = new ElectricityBill();
		ElectricityBill eB2 = new ElectricityBill();
		ElectricityBill eB3 = new ElectricityBill();
		
		eB1.read();
		eB1.display();
		System.out.println("Electricity bill: "+eB1.ElectricityBill());
		
		eB2.read();
		eB2.display();
		System.out.println("Electricity bill: "+eB2.ElectricityBill());
		
		eB3.read();
		eB3.display();
		System.out.println("Electricity bill: "+eB3.ElectricityBill());
		
	}

}
