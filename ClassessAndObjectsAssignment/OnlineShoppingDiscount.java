
package ClassessAndObjectsAssignment;

import java.util.Scanner;

class ShoppingBill {
    int customerId;
    String customerName;
    float purchaseAmount;

    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the customer ID:");
        customerId = sc.nextInt();

        System.out.println("Enter the customer name:");
        customerName = sc.next();

        System.out.println("Enter the purchase amount:");
        purchaseAmount = sc.nextFloat();
    }

    public void display() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Purchase Amount: Rs. " + purchaseAmount);
    }

    public float calculateDiscount() {
        float discount;

        if (purchaseAmount <= 1000) {
            discount = 0;
        } else if (purchaseAmount <= 5000) {
            discount = 5;
        } else if (purchaseAmount <= 10000) {
            discount = 10;
        } else {
            discount = 15;
        }

        return discount;
    }

    public float shoppingBill() {
        float discountAmount =
                purchaseAmount * calculateDiscount() / 100;

        float finalAmount = purchaseAmount - discountAmount;

        return finalAmount;
    }

    public void displayBill() {
        float discount = calculateDiscount();
        float discountAmount = purchaseAmount * discount / 100;
        float finalAmount = shoppingBill();

        System.out.println("Discount: " + discount + "%");
        System.out.println("Discount Amount: Rs. " + discountAmount);
        System.out.println("Final Bill: Rs. " + finalAmount);
    }
}

public class OnlineShoppingDiscount {
    public static void main(String[] args) {
        ShoppingBill s1 = new ShoppingBill();
        ShoppingBill s2 = new ShoppingBill();
        ShoppingBill s3 = new ShoppingBill();

        System.out.println("\n--- Customer 1 ---");
        s1.read();
        s1.display();
        s1.displayBill();

        System.out.println("\n--- Customer 2 ---");
        s2.read();
        s2.display();
        s2.displayBill();

        System.out.println("\n--- Customer 3 ---");
        s3.read();
        s3.display();
        s3.displayBill();
    }
}
