
package PolymorphismAssignment;

class Employee {
    int employeeId;
    String employeeName;
    double salary;

    public Employee(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public double calculateSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Basic Salary: " + salary);
    }
}

class PermanentEmployee extends Employee {
    double HRA;
    double DA;

    public PermanentEmployee(int employeeId, String employeeName,
                             double salary, double HRA, double DA) {
        super(employeeId, employeeName, salary);
        this.HRA = HRA;
        this.DA = DA;
    }

    @Override
    public double calculateSalary() {
        return salary + HRA + DA;
    }
}

class ContractEmployee extends Employee {
    double allowance;

    public ContractEmployee(int employeeId, String employeeName,
                            double salary, double allowance) {
        super(employeeId, employeeName, salary);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return salary + allowance;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {

        Employee e1 = new PermanentEmployee(
            101, "Rahul", 30000, 5000, 3000
        );

        Employee e2 = new ContractEmployee(
            102, "Priya", 30000, 4000
        );

        System.out.println("=== Permanent Employee ===");
        e1.displayDetails();
        System.out.println("Calculated Salary: " + e1.calculateSalary());

        System.out.println();

        System.out.println("=== Contract Employee ===");
        e2.displayDetails();
        System.out.println("Calculated Salary: " + e2.calculateSalary());
    }
}
