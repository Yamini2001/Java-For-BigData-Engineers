
package ArrayAssignment;

public class StudentMarksUsingCommandArguments {
    public static void main(String[] args) {

        // Step 1: Check whether all 4 arguments are provided
        if (args.length != 4) {
            System.out.println("Please provide student name and three subject marks.");
            System.out.println("Example: Ravi 80 75 90");
            return;
        }

        // Step 2: Read command-line arguments
        String name = args[0];

        int mark1;
        int mark2;
        int mark3;

        // Step 3: Convert marks from String to int
        try {
            mark1 = Integer.parseInt(args[1]);
            mark2 = Integer.parseInt(args[2]);
            mark3 = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integer marks.");
            return;
        }

        // Step 4: Calculate total and average
        int total = mark1 + mark2 + mark3;
        double average = total / 3.0;

        // Step 5: Check the result
        String result;

        if (mark1 >= 40 && mark2 >= 40 && mark3 >= 40) {
            result = "PASS";
        } else {
            result = "FAIL";
        }

        // Step 6: Display the result
        System.out.println("Student Name: " + name);
        System.out.println("Mark 1: " + mark1);
        System.out.println("Mark 2: " + mark2);
        System.out.println("Mark 3: " + mark3);
        System.out.println("Total: " + total);
        System.out.printf("Average: %.2f%n", average);
        System.out.println("Result: " + result);
    }
}
