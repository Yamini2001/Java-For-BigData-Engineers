package PolymorphismAssignment;
class Doctor{
	int id;
	String name;
	String specialization;
	public Doctor(int id,String name,String specialization) {
		this.id = id;
		this.name = name;
		this.specialization = specialization;
	}
	public void displayDetails() {
		System.out.println("Doctor ID: "+id);
		System.out.println("Doctor name: "+name);
		System.out.println("Doctor specialization: "+specialization);
	}
}
class Patient{
	int patientId;
	String patientName;
	Doctor doctor;
	public Patient(int patientId,String patientName,Doctor doctor) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.doctor = doctor;
	}
	public void displayPatient(){
		System.out.println("Patient Id:"+patientId);
		System.out.println("Patient Name: "+patientName);
		System.out.println("--- Assigned Doctor ---");
		doctor.displayDetails();
	}
	
}
public class HospitalManagementSystem {
	public static void main(String[] args) {
		 Doctor d1 = new Doctor(1001, "Bakshi", "Cardiologist");
	        Doctor d2 = new Doctor(1002, "Mehta", "Neurologist");

	        Patient p1 = new Patient(5001, "Suresh", d1);
	        Patient p2 = new Patient(5002, "Ramesh", d2);
	        Patient p3 = new Patient(5003, "Amit", d1);

	        p1.displayPatient();

	        System.out.println();

	        p2.displayPatient();

	        System.out.println();

	        p3.displayPatient();
		
	}

}
