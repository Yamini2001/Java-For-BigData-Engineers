
package ArrayAssignment;

import java.util.Scanner;

public class SupposePositiveNegativeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        int zero_count = 0;

        // Step 1: Store numbers in the array
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 2: Display positive numbers
        System.out.print("Positive numbers: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        // Step 3: Display negative numbers
        System.out.print("Negative numbers: ");
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

        // Step 4: Count zero values
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zero_count++;
            }
        }

        System.out.println("Zero values: " + zero_count);

    }
}
