package JavaAssignment1;

import java.util.Scanner;

public class VotingEligibility {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age of person which is eligible for the vote: ");
		int age = sc.nextInt();
		if (age >= 18) {
			System.out.println("Eligible for vote");
		} else {
			System.out.println("Not Eligible for vote");
		}
	}

}
