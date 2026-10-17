package ArrayAssignment;

public class LargestAndSmallest {
	public static void main(String[] args) {
		int[] arr = {25,10, 75, 40, 60};
		int max = arr[0];
		int min = arr[0];
		for(int num:arr) {
			if(num>max) {
				max = num;
			}
			else if(num<min) {
				min = num;
			}
			
		}
		System.out.println("Find the largest element: "+max);
		System.out.println("Find the smallest element: "+min);
	}

}
