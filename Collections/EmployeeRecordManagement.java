
package Collections;

import java.util.HashMap;
import java.util.Map.Entry;

class Employee {

    int employeeId;
    String employeeName;
    String department;
    double salary;

    public Employee(int employeeId, String employeeName,
                    String department, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Department: " + department);
        System.out.println("Employee Salary: " + salary);
        System.out.println("--------------------");
    }
}

public class EmployeeRecordManagement {

    public static void main(String[] args) {

        HashMap<Integer, Employee> employee = new HashMap<>();

        // Create
        employee.put(1001, new Employee(1001, "Shreya", "CSE", 56000));
        employee.put(1002, new Employee(1002, "Neha", "IT", 43000));
        employee.put(1004, new Employee(1004, "Antima", "Civil", 76000));

        // Display
        System.out.println("All Employees:");

        for (Entry<Integer, Employee> entry : employee.entrySet()) {
            entry.getValue().displayEmployee();
        }

        // Search
        Integer searchId = 1002;

        if (employee.containsKey(searchId)) {
            System.out.println("Employee found:");
            employee.get(searchId).displayEmployee();
        } else {
            System.out.println("Employee not found");
        }

        // Update salary
        Integer updateId = 1002;

        if (employee.containsKey(updateId)) {
            Employee emp = employee.get(updateId);
            emp.salary = 90000;
            System.out.println("Salary updated successfully:");
            emp.displayEmployee();
        } else {
            System.out.println("Employee not found");
        }

        // Delete
        Integer deleteId = 1004;

        if (employee.containsKey(deleteId)) {
            employee.remove(deleteId);
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }

        // Check ID
        Integer checkId = 1001;

        if (employee.containsKey(checkId)) {
            System.out.println("Employee ID exists");
        } else {
            System.out.println("Employee ID does not exist");
        }

        // Count
        System.out.println(
            "Total number of employee records: " + employee.size()
        );
    }
}
