
package InheritanceAssignment;

class Patient {
    int id;
    String name;
    double charges;

    public Patient(int id, String name, double charges) {
        this.id = id;
        this.name = name;
        this.charges = charges;
    }

    public void displayPatient() {
        System.out.println("Patient ID: " + id);
        System.out.println("Patient Name: " + name);
        System.out.println("Consultation Charges: " + charges);
    }
}

class InPatient extends Patient {
    int noOfDays;
    double room_charges;
    double medicine_charges;

    public InPatient(int id, String name, double charges,
                     int noOfDays, double room_charges,
                     double medicine_charges) {

        super(id, name, charges);

        this.noOfDays = noOfDays;
        this.room_charges = room_charges;
        this.medicine_charges = medicine_charges;
    }

    public double totalBill() {
        return charges + (noOfDays * room_charges)
                + medicine_charges;
    }

    public void displayInPatient() {
        displayPatient();

        System.out.println("Admission Days: " + noOfDays);
        System.out.println("Daily Room Charges: " + room_charges);
        System.out.println("Medicine Charges: " + medicine_charges);
        System.out.println("Total Hospital Bill: " + totalBill());
    }
}

class OutPatient extends Patient {
    double laboratory_charges;
    double prescribed_medicine_charges;

    public OutPatient(int id, String name, double charges,
                      double laboratory_charges,
                      double prescribed_medicine_charges) {

        super(id, name, charges);

        this.laboratory_charges = laboratory_charges;
        this.prescribed_medicine_charges =
                prescribed_medicine_charges;
    }

    public double totalBill() {
        return charges + laboratory_charges
                + prescribed_medicine_charges;
    }

    public void displayOutPatient() {
        displayPatient();

        System.out.println("Laboratory Charges: "
                + laboratory_charges);

        System.out.println("Prescribed Medicine Charges: "
                + prescribed_medicine_charges);

        System.out.println("Total Hospital Bill: " + totalBill());
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {

        InPatient p1 = new InPatient(
                101, "Rahul", 500.0,
                3, 2000.0, 1500.0
        );

        OutPatient p2 = new OutPatient(
                102, "Priya", 500.0,
                800.0, 400.0
        );

        System.out.println("===== IN-PATIENT BILL =====");
        p1.displayInPatient();

        System.out.println();

        System.out.println("===== OUT-PATIENT BILL =====");
        p2.displayOutPatient();
    }
}
