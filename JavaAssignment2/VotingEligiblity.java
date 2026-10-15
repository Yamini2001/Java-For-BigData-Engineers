package JavaAssignment2;

import java.util.Scanner;

public class VotingEligiblity {
	public static boolean isEligible(int age) {
		if(age >=18) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of age: ");
		int age = sc.nextInt();
		boolean isEligible = isEligible(age);
		if(isEligible) {
			System.out.println("You are eligible for vote");
		}
		else {
			System.out.println("You are not eligible for vote");
		}
	}

}
