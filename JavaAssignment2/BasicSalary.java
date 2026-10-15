package JavaAssignment2;

import java.util.Scanner;

public class BasicSalary {
	public static double calculateSalary(double basic_salary) {
		double HRA_Percentage = 0;
		if(basic_salary >=50000) {
			HRA_Percentage = 0.20;
		}
		else {
			HRA_Percentage =0;
		}
		double calculateSalary = basic_salary * HRA_Percentage;
		return calculateSalary;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the basic salary: ");
		double basic_salary = sc.nextDouble();
		double salary = calculateSalary(basic_salary);
		System.out.println("Calculate the basic salary: "+salary);
		
	}

}
