
package ArrayAssignment;

import java.util.Scanner;

public class SearchElement {

    public static int searchElement(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50};

        System.out.println("Enter the value to search:");
        int target = sc.nextInt();

        int searchValue = searchElement(arr, target);

        if (searchValue != -1) {
            System.out.println("Element found at index " + searchValue);
        } else {
            System.out.println("Element not found");
        }

    }
}
