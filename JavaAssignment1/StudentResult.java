package JavaAssignment1;

import java.util.Scanner;

public class StudentResult {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the marks: ");
		float marks = sc.nextFloat();
		if (marks >= 40) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
