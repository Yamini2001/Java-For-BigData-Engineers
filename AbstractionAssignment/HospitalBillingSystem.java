package AbstractionAssignment;
abstract class Patient{
	int patientId;
	String patientName;
	int numberOfDays;
	public Patient(int patientId,String patientName,int numberOfDays) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.numberOfDays = numberOfDays;
	}
	abstract public double calculateBill();
	public void displayPatientDetails() {
		System.out.println("Patient Id: "+patientId);
		System.out.println("Patient Name: "+patientName);
		System.out.println("Number of days: "+numberOfDays);
	}
}
class InPatient extends Patient{
	double room_charges;
	double fixed_fee;
	public InPatient(int patientId,String patientName,int numberOfDays,double room_Charges,double fixed_fee) {
		super(patientId,patientName,numberOfDays);
		this.room_charges = 2000;
		this.fixed_fee = 1500;

	}
	@Override
	public double calculateBill() {
		// TODO Auto-generated method stub
		return room_charges*numberOfDays+fixed_fee;
		
		
	}
	public void displayInPatient() {
		System.out.println("Room charges: "+room_charges);
		System.out.println("Fixed doctor consultation: "+fixed_fee);
		System.out.println("Calculate Bill: "+calculateBill());
		
	}
}
class OutPatient extends Patient{
	double consultation_fee;
	double medicine_charges;
	public OutPatient(int patientId,String patientName,int numberOfDays,double consultation_fee,double medicine_charges) {
		super(patientId,patientName,numberOfDays);
		this.consultation_fee = 800;
		this.medicine_charges = medicine_charges;
	}

	@Override
	public double calculateBill() {
		// TODO Auto-generated method stub
		return consultation_fee + medicine_charges;
	}
	public void displayOutPatient() {
		System.out.println("Fixed consultation: "+consultation_fee);
		System.out.println("Medicine charges: "+medicine_charges);
		System.out.println("Calculate bill: "+calculateBill());
	}
}
public class HospitalBillingSystem {
	public static void main(String[] args) {
		InPatient p = new InPatient(1001,"Yatin",5,2500,1500);
		System.out.println("------InPatient Record-------");
		p.displayInPatient();
		
		OutPatient o = new OutPatient(1003,"Suresh",5,1500,800);
		System.out.println("--------OutPatient Records-------");
		o.displayOutPatient();
	}

}