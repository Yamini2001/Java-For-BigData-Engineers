package InheritanceAssignment;
class Order{
	int id;
	String date;
	double amount;
	public Order(int id,String date,double amount) {
		this.id = id;
		this.date = date;
		this.amount = amount;
	}
	public void displayOrder(){
		System.out.println("Order ID: "+id);
		System.out.println("Order Date: "+date);
		System.out.println("Order amount: "+amount);
		
	}
}
class DeliveryOrder extends Order{
	String address;
	double charges;
	int noOfDays;
	public DeliveryOrder(int id,String date,double amount,String address,double charges,int noOfDays) {
		super(id,date,amount);
		this.address = address;
		this.charges = charges;
		this.noOfDays = noOfDays;
	}
	public double calculateTotal() {
		return amount + charges;
	}
	public void displayDeliveryOrder() {
		displayOrder();
		System.out.println("Delivery address: "+address);
		System.out.println("Delivery charges: "+charges);
		System.out.println("Expected delivery days: "+noOfDays);
		System.out.println("Total payable amount: "+calculateTotal());
	}
	
	
}
public class OnlineShoppingOrderManagement {
	public static void main(String[] args) {
	DeliveryOrder o = new DeliveryOrder(1001,"24-10-2026",1500.0,"Triumala",1200.0,5);
	o.displayDeliveryOrder();
	}
}
