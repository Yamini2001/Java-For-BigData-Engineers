
package AbstractionAssignment;

interface DeliveryService {
    double calculateDeliveryCharge(double distance);

    void displayDeliveryDetails();
}

class StandardDelivery implements DeliveryService {

    int orderId;
    String customerName;
    double distance;

    public StandardDelivery(int orderId, String customerName,
                            double distance) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.distance = distance;
    }

    @Override
    public double calculateDeliveryCharge(double distance) {
        return distance * 10;
    }

    @Override
    public void displayDeliveryDetails() {
        System.out.println("Standard Delivery");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Delivery Charge: ₹"
                + calculateDeliveryCharge(distance));
    }
}

class ExpressDelivery implements DeliveryService {

    int orderId;
    String customerName;
    double distance;

    public ExpressDelivery(int orderId, String customerName,
                           double distance) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.distance = distance;
    }

    @Override
    public double calculateDeliveryCharge(double distance) {
        return (distance * 20) + 50;
    }

    @Override
    public void displayDeliveryDetails() {
        System.out.println("Express Delivery");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Delivery Charge: ₹"
                + calculateDeliveryCharge(distance));
    }
}

public class OnlineDeliverySystem {

    public static void main(String[] args) {

        DeliveryService d1 =
                new StandardDelivery(1001, "Ritesh", 34.9);

        DeliveryService d2 =
                new ExpressDelivery(1002, "Priya", 34.9);

        d1.displayDeliveryDetails();

        System.out.println();

        d2.displayDeliveryDetails();
    }
}
