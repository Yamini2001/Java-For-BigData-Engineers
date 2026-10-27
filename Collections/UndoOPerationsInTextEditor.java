
package Collections;

import java.util.Stack;

public class UndoOPerationsInTextEditor {

    public static void main(String[] args) {

        Stack<String> actions = new Stack<>();

        // 1. Add editing actions
        actions.push("Typing Hello");
        actions.push("Deleting Text");
        actions.push("Formatting Text");

        // 2. Display the most recent action without removing it
        if (!actions.isEmpty()) {
            System.out.println("Most recent action: " + actions.peek());
        } else {
            System.out.println("No actions available");
        }

        // 3. Undo the most recent action
        if (actions.isEmpty()) {
            System.out.println("No actions available to undo");
        } else {
            String undoneAction = actions.pop();
            System.out.println("Undo action: " + undoneAction);
        }

        // 4. Display all remaining actions
        System.out.println("\nRemaining actions:");

        if (actions.isEmpty()) {
            System.out.println("No actions in history");
        } else {
            for (int i = actions.size() - 1; i >= 0; i--) {
                System.out.println(actions.get(i));
            }
        }

        // 5. Display total remaining actions
        System.out.println("\nTotal remaining actions: " + actions.size());
    }
}
