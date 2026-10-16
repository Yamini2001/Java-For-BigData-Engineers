package JavaAssignment1;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float principal = sc.nextFloat();
		int rate = sc.nextInt();
		int time = sc.nextInt();
		System.out.println("Enter the value of principal,rate,time: ");
		float simpleInterest = principal * rate * time / 100;
		System.out.println(simpleInterest);
		float amount = principal + simpleInterest;
		System.out.println(amount);

	}

}
