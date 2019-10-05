package Notes.Sec09;

public class BankAccountTester {

	public static void main(String[] args) {
		BankAccount b = new BankAccount();
		BankAccount c = new BankAccount();
		BankAccount r = new BankAccount(20);
		
		b.deposit(500);
		b.deposit(100);
		System.out.printf("Balance: $%.2f%n", b.getBalance());
		System.out.println(b.withdrawal(300));
		System.out.printf("Balance: $%.2f%n", b.getBalance());
		System.out.println(b.withdrawal(400));
		System.out.printf("Balance: $%.2f%n", b.getBalance());
		r.deposit(10);
		System.out.printf("Balance: $%.2f%n", r.getBalance());
		System.out.println(b + "\n");
		System.out.println(c + "\n");
		System.out.println(r);
	}
}
