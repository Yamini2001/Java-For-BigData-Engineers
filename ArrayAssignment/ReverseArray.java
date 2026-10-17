package ArrayAssignment;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		int[] reverse = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			reverse[i] = arr[arr.length-1-i];
		}
		System.out.println("Reversed array: ");
		for(int i=0;i<arr.length;i++) {
			System.out.println(reverse[i]+" ");
		}
		
	}

}
