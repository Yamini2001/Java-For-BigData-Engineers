package ArrayAssignment;
import java.util.Scanner;
public class FindSumAndAverage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array elements: ");
		int[] arr = new int[6];
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		System.out.println("Sum of the elements: "+sum);
		float average = sum/5;
		System.out.println("Average of the elements: "+average);
		
	}

}
