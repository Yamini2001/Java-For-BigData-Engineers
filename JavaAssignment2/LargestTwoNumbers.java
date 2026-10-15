package JavaAssignment2;
import java.util.Scanner;

public class LargestTwoNumbers {
	public static int findLargest(int num1,int num2) {
		if(num1 > num2) {
			return num1;
		}
		else if(num2 > num1) {
			return num2;
		}
		else {
			return num1;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of num1 and num2: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int largest = findLargest(num1,num2);
		System.out.println("Largest number is: "+largest);
		
	}

}
