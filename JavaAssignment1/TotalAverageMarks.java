package MyFirstProject;
import java.util.Scanner;

public class TotalAverageMarks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mathematics = sc.nextInt();
		int science = sc.nextInt();
		int english = sc.nextInt();
		System.out.println("Enter the marksof three subjects: ");
		int total = mathematics + science + english;
		System.out.println(total);
		float average = total/3;
		System.out.println(average);
	}

}
