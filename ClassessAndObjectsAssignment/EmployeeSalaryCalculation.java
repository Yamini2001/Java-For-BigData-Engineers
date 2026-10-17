package ClassessAndObjectsAssignment;
import java.util.Scanner;
class Employee{
	int EmployeeID;
	String EmployeeName;
	float basicSalary;
	public void read() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employeeId: ");
		EmployeeID = sc.nextInt();
		System.out.println("Enter the employeeName: ");
		EmployeeName = sc.next();
		System.out.println("Enter the basic Salary: ");
		basicSalary = sc.nextFloat();
		
	}
	public void display() {
		System.out.println("Enter the EmployeeId: "+EmployeeID);
		System.out.println("Enter the EmployeeName: "+EmployeeName);
		System.out.println("Enter the basic salary: "+basicSalary);
		
	}
	public void calculateSalary() {
		float basic_salary = 0;
		float HRA = (float) ((float)basic_salary* 0.20);
		float DA = (float) (basic_salary*0.10); ;
		float total_salary = basic_salary + HRA+ DA;
		System.out.println("Salary of employee: "+total_salary);
	}
	public String Employee() {
		// TODO Auto-generated method stub
		return null;
	}
}
public class EmployeeSalaryCalculation {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		
		e1.read();
		e1.display();
		System.out.println("Employee Salary Calculation: "+e1.Employee());
		
		e2.read();
		e2.display();
		System.out.println("Employee Salary Calculation: "+e2.Employee());
		
		e3.read();
		e3.display();
		System.out.println("Employee Salary Calculation: "+e3.Employee());
		
		
		
		
		
	}

}
