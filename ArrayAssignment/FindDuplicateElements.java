package ArrayAssignment;
import java.util.Scanner;
public class FindDuplicateElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array: ");
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Find the duplicates of an array: ");
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println(arr[i]+" ");
					break;
				}
			}
		}
	}

}

