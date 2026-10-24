
package InheritanceAssignment;

class BankAccount {
    long accountNumber;
    String accountHolderName;
    double accountBalance;

    public BankAccount(long accountNumber, String accountHolderName,
                       double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + accountBalance);
    }
}

class SavingsAccount extends BankAccount {
    double annualInterestRate;

    public SavingsAccount(long accountNumber, String accountHolderName,
                          double accountBalance, double annualInterestRate) {
        super(accountNumber, accountHolderName, accountBalance);
        this.annualInterestRate = annualInterestRate;
    }

    public void calculateInterest(int years) {
        double interest = (accountBalance * annualInterestRate * years) / 100;

        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.println("Number of Years: " + years);
        System.out.println("Interest Earned: " + interest);

        accountBalance = accountBalance + interest;

        System.out.println("Balance After Adding Interest: " + accountBalance);
    }
}

class CurrentAccount extends BankAccount {
    double overdraftLimit;

    public CurrentAccount(long accountNumber, String accountHolderName,
                          double accountBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, accountBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawal Amount: " + amount);
        System.out.println("Overdraft Limit: " + overdraftLimit);

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (accountBalance - amount >= -overdraftLimit) {
            accountBalance = accountBalance - amount;
            System.out.println("Withdrawal Successful.");
            displayBalance();
        } else {
            System.out.println("Withdrawal Denied: Overdraft limit exceeded.");
            displayBalance();
        }
    }
}

public class BankingServiceManagement {
    public static void main(String[] args) {

        SavingsAccount savings = new SavingsAccount(
                1001001L, "Amit Sharma", 50000.0, 5.0
        );

        CurrentAccount current = new CurrentAccount(
                2002002L, "Priya Verma", 10000.0, 5000.0
        );

        System.out.println("===== SAVINGS ACCOUNT DETAILS =====");
        savings.displayAccountDetails();
        savings.calculateInterest(2);

        System.out.println();

        System.out.println("===== CURRENT ACCOUNT DETAILS =====");
        current.displayAccountDetails();
        current.withdraw(12000.0);

        System.out.println();
        System.out.println("===== FINAL ACCOUNT BALANCES =====");
        System.out.println("Savings Account:");
        savings.displayBalance();

        System.out.println("Current Account:");
        current.displayBalance();
    }
}
