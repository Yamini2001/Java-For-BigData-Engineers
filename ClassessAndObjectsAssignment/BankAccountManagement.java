
package ClassessAndObjectsAssignment;

import java.util.Scanner;

class BankAccount {
    String accountNumber;
    String accountHolderName;
    double accountBalance;

    public void read() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the account number:");
        accountNumber = sc.next();

        System.out.println("Enter the account holder name:");
        accountHolderName = sc.next();

        System.out.println("Enter the account balance:");
        accountBalance = sc.nextDouble();
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }

    public String checkCategory() {
        if (accountBalance <= 100000) {
            return "Basic";
        } else if (accountBalance <= 500000) {
            return "Standard";
        } else {
            return "Premium";
        }
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        BankAccount b3 = new BankAccount();

        b1.read();
        b1.display();
        System.out.println("Account Category: " + b1.checkCategory());

        b2.read();
        b2.display();
        System.out.println("Account Category: " + b2.checkCategory());

        b3.read();
        b3.display();
        System.out.println("Account Category: " + b3.checkCategory());
    }
}
