package AbstractionAssignment;
interface Payment {
    void makePayment(double amount);
}

class CreditCardPayment implements Payment {
    String cardHolderName;
    String cardNumber;
    String bankName;

    public CreditCardPayment(String cardHolderName,
                             String cardNumber,
                             String bankName) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.bankName = bankName;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Credit Card Payment:");
        System.out.println("Card Holder Name: " + cardHolderName);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Payment Amount: " + amount);
    }
}

class UPIPayment implements Payment {
    String upiId;
    String mobileNumber;

    public UPIPayment(String upiId, String mobileNumber) {
        this.upiId = upiId;
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("UPI Payment:");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Payment Amount: " + amount);
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment(
            "Suresh", "1234567890123456", "SBI"
        );

        Payment p2 = new UPIPayment(
            "rahul@okaxis", "9876543210"
        );

        p1.makePayment(5000.0);

        System.out.println();

        p2.makePayment(1500.0);
    }
}
