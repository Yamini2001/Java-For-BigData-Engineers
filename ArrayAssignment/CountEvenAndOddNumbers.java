package ArrayAssignment;

public class CountEvenAndOddNumbers {
	public static void main(String[] args) {
		int[] arr = {10,15,20,25,30,35};
		int even_count = 0;
		int odd_count = 0;
		for(int num:arr) {
			if(num%2==0) {
				even_count++;
			}
			else {
				odd_count++;
			}
		}
		System.out.println("Even numbers: "+even_count);
		System.out.println("Odd numbers: "+odd_count);
	}

}
