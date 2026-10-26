package AbstractionAssignment;
abstract class Employee{
	int employeeId;
	String employeeName;
	double basicSalary;
	public Employee(int employeeId,String employeeName,double basicSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.basicSalary = basicSalary;
	}
	abstract public double calculateSalary();
	public void displayDetails() {
		System.out.println("Employee Id: "+employeeId);
		System.out.println("Employee Name: "+employeeName);
		System.out.println("Basic Salary: "+basicSalary);
	}
}
class PermanentEmployee extends Employee{
	double HRA;
	double DA;
	public PermanentEmployee(int employeeId,String employeeName,double basicSalary,double HRA,double DA) {
		super(employeeId,employeeName,basicSalary);
		this.HRA = basicSalary*0.20;
		this.DA= basicSalary*0.10;
	}
	@Override
	public double calculateSalary() {
		return basicSalary + HRA + DA; 
	}
	public void displayPermanentEmployee() {
		System.out.println("Display HRA: "+HRA);
		System.out.println("Display DA: "+DA);
		System.out.println("Calculate salary: "+calculateSalary());
	}
}
class ContractEmployee extends Employee{
	double fixed_allowance;
	public ContractEmployee(int employeeId,String employeeName,double basicSalary,double fixed_allowance) {
		super(employeeId,employeeName,basicSalary);
		this.fixed_allowance = 3000;
	}
	@Override
	public double calculateSalary() {
		return basicSalary + fixed_allowance;
	}
	public void displayContractEmployee() {
		System.out.println("Fixed allowance: "+fixed_allowance);
		System.out.println("Display Salary: "+calculateSalary());
	}
}
public class EmployeeSalaryCalculation {
	public static void main(String[] args) {
	PermanentEmployee p = new PermanentEmployee(1001,"Suresh",45000.0,0.80,0.10);
	System.out.println("---------------Permanent Employee------------");
	p.displayPermanentEmployee();
	ContractEmployee c = new ContractEmployee(2000,"Mangesh",65000.0,5000);
	System.out.println("---------------Contract Employee-------------");
	c.displayContractEmployee();
	
	
	}
}
