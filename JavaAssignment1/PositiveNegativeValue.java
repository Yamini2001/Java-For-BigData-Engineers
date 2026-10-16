package JavaAssignment1;

import java.util.Scanner;

public class PositiveNegativeValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		if (n > 0) {
			System.out.println("Positive");
		} else if (n < 0) {
			System.out.println("Negative");
		} else {
			System.out.println("Zero");
		}

	}

}
