package ExceptionHandling;
class BankAccount{
	double accountNumber;
	double balance;
	public BankAccount(double accountNumber,double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public void withdraw(double amount) {
		try {
			if(amount<=0) {
				throw new IllegalArgumentException("Withdrawal amount is zero or negative");
			}
			if(amount>balance) {
				throw new ArithmeticException("Insufficient balance");
			}
			balance = amount - balance;
			System.out.println("Amount only withdrawal is valid: "+balance);
		}
		catch(ArithmeticException e) {
			System.out.println("Withdraw amount exceeds the available balance: "+e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println("Withdrawal Amount is zero or negatove");
		}
		
	}
	
}
public class BankWithDrawal {
	public static void main(String[] args) {
		BankAccount b = new BankAccount(3643232,34000);
		b.withdraw(543209);
		
	}

}
