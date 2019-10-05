package Notes.Sec09;

/**
 * Models a bank account with functionalities
 * to deposit, withdrawal, check balance
 * @author Joseph
 * @since 2019-1-24
 */
public class BankAccount {
	
	//instance variables
	private String bankAccountNum;
	private double balance;
	
	//static variables
	private static int Last_Acct_Num = 0;
	
	/**
	 * default constructor creates a bank account with
	 * zero balance
	 */
	public BankAccount() {
		balance = 0.0;
		Last_Acct_Num ++; //increment acct number
		bankAccountNum = Integer.toString(Last_Acct_Num);
	}
	
	/**
	 * overloaded constructor, constructs a bank account with same initial deposited balance
	 * @param iniDeposit - initial amount deposited to bank account
	 */
	public BankAccount(double iniDeposit) {
		balance = iniDeposit;
		Last_Acct_Num ++; //increment acct number
		bankAccountNum = Integer.toString(Last_Acct_Num);
	}
	
	/**
	 * Deposits given amount into this account 
	 * @param amount - the amount of money to be deposited
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
	/**
	 * Withdrawals a given amount of money from the bank account
	 * @param amount - the amount of money to be withdrawn
	 * @return true if sufficient balance was in the account, 
	 * false otherwise
	 */
	public boolean withdrawal(double amount) {
		balance -= amount;
		if(balance >= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the current balance of the account
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * yields a string representation of this object with
	 * account number and current balance
	 */
	public String toString() {
		String s = String.format("Acc #: %s%nBalance: $%.2f", bankAccountNum, balance);
		return s;
	}
}
