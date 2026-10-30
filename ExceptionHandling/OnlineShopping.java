package ExceptionHandling;
class ShoppingCart{
	float price;
	int quantity;
	float total_cost;
	public ShoppingCart(float price,int quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	public void calculateCost() {
		try {
		if(quantity==0) {
			throw new ArithmeticException("number of items is zero: ");
		}
		total_cost = price*quantity;
		float average_cost = total_cost/quantity;
		System.out.println(total_cost);
		System.out.println(average_cost);
		}
		catch(ArithmeticException e) {
			System.out.println("Error occured in calculation: "+e.getMessage());
			
		}
		
		
	}
}
public class OnlineShopping{
	public static void main(String[] args) {
		ShoppingCart s = new ShoppingCart(430,4);
		s.calculateCost();
		
		
		
	}
}