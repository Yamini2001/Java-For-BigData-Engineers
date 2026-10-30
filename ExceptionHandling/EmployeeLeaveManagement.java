
package ExceptionHandling;

// Custom Exception Class
class InsufficientLeaveException extends Exception {

    public InsufficientLeaveException(String message) {

        super(message);

    }

}

// Employee Class
class Employee {

    int employeeId;
    String employeeName;
    int leaveDays;

    public Employee(int employeeId, String employeeName, int leaveDays) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.leaveDays = leaveDays;

    }

    public void applyLeave(int days) {

        try {

            if(days <= 0) {

                throw new InsufficientLeaveException(
                    "Requested leave days must be positive"
                );

            }

            if(days > leaveDays) {

                throw new InsufficientLeaveException(
                    "Insufficient leave balance"
                );

            }

            leaveDays = leaveDays - days;

            System.out.println("Leave request successful");

            System.out.println("Remaining Leave Days: " + leaveDays);

        }

        catch(InsufficientLeaveException e) {

            System.out.println("Leave request failed: " + e.getMessage());

        }

    }

}

// Main Class
public class EmployeeLeaveManagement {

    public static void main(String[] args) {

        Employee e = new Employee(1002, "Shrishti", 10);

        e.applyLeave(4);

    }

}
