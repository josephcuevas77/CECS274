package CustomerTest;

import java.util.Scanner;

public class CustomerTester {

	public static void main(String[] args) {
		
		Scanner nani = new Scanner(System.in);
		
		System.out.println("Please enter customer ID.");
		int customerID = nani.nextInt();
		
		Customer cauchy = new Customer();
		Customer newton = new Customer(customerID,6000);
		
		cauchy.addPoints(30);
		cauchy.addPoints(2000);
		System.out.println(cauchy);
		System.out.println();
		System.out.println(newton);
		
		nani.close();
	}
	
}
