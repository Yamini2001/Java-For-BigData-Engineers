package JavaAssignment2;
import java.util.Scanner;

public class StudentGradeCalculation {
	public static char calculateGrade(int marks) {
		if (marks >=90) {
			return 'A';
		}
		else if (marks>=80) {
			return 'B';
		}
		else if(marks >=70) {
			return 'C';
		}
		else if(marks >=60) {
			return 'D';
		}
		else {
			return 'F';
		}
		
		
	}
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks: ");
		int marks = sc.nextInt();
		char grade = calculateGrade(marks);
		System.out.println(grade);
		
		
		
		
		
	}

}
