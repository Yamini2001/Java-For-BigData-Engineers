
package PolymorphismAssignment;

class Payment {
    int paymentId;
    double amount;

    public Payment(int paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Payment Amount: " + amount);
    }
}

class CreditCardPayment extends Payment {
    String transactionReference;
    double processingFee;

    public CreditCardPayment(int paymentId, double amount,
                             String transactionReference,
                             double processingFee) {
        super(paymentId, amount);
        this.transactionReference = transactionReference;
        this.processingFee = processingFee;
    }

    @Override
    public void processPayment() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Payment Amount: " + amount);
        System.out.println("Card Transaction Reference: " + transactionReference);
        System.out.println("Processing Fee: " + processingFee);
        System.out.println("Total Amount: " + (amount + processingFee));
    }
}

class UPIPayment extends Payment {
    String UPItransaction;
    String transactionDetails;

    public UPIPayment(int paymentId, double amount,
                      String UPItransaction, String transactionDetails) {
        super(paymentId, amount);
        this.UPItransaction = UPItransaction;
        this.transactionDetails = transactionDetails;
    }

    @Override
    public void processPayment() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Payment Amount: " + amount);
        System.out.println("UPI Transaction Reference: " + UPItransaction);
        System.out.println("Transaction Details: " + transactionDetails);
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {

        Payment p1 = new CreditCardPayment(
            101, 5000, "CARD-TXN-123", 100
        );

        Payment p2 = new UPIPayment(
            102, 2500, "UPI-TXN-456", "Paid using Google Pay"
        );

        System.out.println("=== Credit Card Payment ===");
        p1.processPayment();

        System.out.println();

        System.out.println("=== UPI Payment ===");
        p2.processPayment();
    }
}
