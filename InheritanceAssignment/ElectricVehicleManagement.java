package InheritanceAssignment;
class Vehicle{
	int id;
	String brand;
	int year;
	public Vehicle(int id,String brand,int year) {
		this.id = id;
		this.brand = brand;
		this.year = year;
	}
	public void displayVehicle() {
		System.out.println("Vehicle ID:"+id);
		System.out.println("Vehicle brand: "+brand);
		System.out.println("Vehicle year: "+year);
	}
}
class MotorVehicle extends Vehicle{
	int capacity;
	String type;
	public MotorVehicle(int id,String brand,int year,int capacity,String type) {
		super(id,brand,year);
		this.capacity = capacity;
		this.type = type;
	}
	public void displayMotorVehicle() {
		displayVehicle();
		System.out.println("Add Engine Capacity (CC): "+capacity);
		System.out.println("Fuel type: "+type);
	}
}
class ElectricVehicle extends MotorVehicle{
	float battery_capacity;
	float range;
	int time;
	public ElectricVehicle(int id,String brand,int year,int capacity,String type,float battery_capacity,float range,int time) {
		super(id,brand,year,capacity,type);
		this.battery_capacity = battery_capacity;
		this.range = range;
		this.time = time;
	}
	
	

	public int vehicleAge() {
		return 2026-year;
	}
	public double EnergyConsumption() {
		return battery_capacity / range;
		
	}
	public void displayElectricVehicle(){
		displayMotorVehicle();
		System.out.println("The age of vehicle: "+vehicleAge());
		System.out.println("Battery capacity: "+battery_capacity+"(kWh)");
		System.out.println("Drive range: "+range+"km");
		System.out.println("Charging time: "+time+"(hours)");
		System.out.println("Energy Consumption: %.3f kWh/km%n: "+EnergyConsumption());
		
		
	}
	
	
}
public class ElectricVehicleManagement {
	public static void main(String[] args) {
		ElectricVehicle e = new ElectricVehicle( 1001, "Suzuki", 2024, 500, "Petrol",
			    50.0f, 400.0f, 7);
		e.displayElectricVehicle();
	}

}
