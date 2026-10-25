
package PolymorphismAssignment;

import java.util.Scanner;

class BankAccount {
    double accountNumber;
    String holderName;
    double balance;

    public BankAccount(double accountNumber, String holderName,
                       double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposit Amount: " + amount);
        System.out.println("Updated Balance: " + balance);
    }

    public void deposit(double amount, String transactionReference) {
        balance = balance + amount;
        System.out.println("Deposit Amount: " + amount);
        System.out.println("Transaction Reference: "
                           + transactionReference);
        System.out.println("Updated Balance: " + balance);
    }

    public void deposit(double amount, String transactionReference,
                        String depositMode) {
        balance = balance + amount;
        System.out.println("Deposit Amount: " + amount);
        System.out.println("Transaction Reference: "
                           + transactionReference);
        System.out.println("Deposit Mode: " + depositMode);
        System.out.println("Updated Balance: " + balance);
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + holderName);
        System.out.println("Account Balance: " + balance);
    }
}

public class BankingTransactionSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account number:");
        double accountNumber = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter account holder name:");
        String holderName = sc.nextLine();

        System.out.println("Enter initial balance:");
        double balance = sc.nextDouble();

        BankAccount b1 = new BankAccount(
            accountNumber, holderName, balance
        );

        System.out.println("Enter deposit amount:");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter transaction reference:");
        String transactionReference = sc.nextLine();

        System.out.println("Enter deposit mode:");
        String depositMode = sc.nextLine();

        System.out.println("\n--- Method 1 ---");
        b1.deposit(amount);

        System.out.println("\n--- Method 2 ---");
        b1.deposit(amount, transactionReference);

        System.out.println("\n--- Method 3 ---");
        b1.deposit(amount, transactionReference, depositMode);

        System.out.println("\n--- Final Account Details ---");
        b1.displayDetails();

    }
}
