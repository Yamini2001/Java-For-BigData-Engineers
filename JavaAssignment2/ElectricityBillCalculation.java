package JavaAssignment2;

import java.util.Scanner;

public class ElectricityBillCalculation {

    // Method to calculate the electricity bill
    public static int calculateBill(int units) {
        int bill = 0;

        if (units <= 100) {
            bill = units * 2;
        }
        else if (units <= 200) {
            bill = (100 * 2) + ((units - 100) * 3);
        }
        else if (units <= 300) {
            bill = (100 * 2) + (100 * 3) + ((units - 200) * 5);
        }
        else {
            bill = (100 * 2) + (100 * 3) + (100 * 5) + ((units - 300) * 7);
        }

        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total units consumed: ");
        int total_consumed = sc.nextInt();

        int bill_amount = calculateBill(total_consumed);

        System.out.println("Total bill amount: ₹" + bill_amount);

        sc.close();
    }
}