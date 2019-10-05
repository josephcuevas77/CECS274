package labsCECS174;

import java.util.Scanner;

public class Lab16 {

	public static void main(String[] args) {
		Scanner nani = new Scanner (System.in);
		//Creates the new array
		int[] numbers = new int[5];
		System.out.println("Please enter 5 integers:");
		//Create for loop to take 5 numbers to assign indexes in the array
		for(int i = 0; i < numbers.length; i++) {
			int x = nani.nextInt();
			numbers[i] = x;
		}
		//End of first for loop
		
		//Create for loop to iterate through array and check if prime
		for(int i = 0; i < numbers.length; i++) {
			boolean x = isPrime(numbers[i]);
			if(x == true) {
				System.out.println(numbers[i] + " is Prime.");
			}
		}
		//End of second for loop
		nani.close();
	}
	//Create method to find if prime
	public static boolean isPrime(int num) {
		if (num % 2 == 0) {
			return false;
		}
		//End of first if statement 
		
			//For loop to find if prime
			for(int a = 3; a <= num; a++) {
				if (num % 2 != 0) {
					for(int z = 3; z <= num; z++) {
						if (z % 2 != 0) {
							if(z * a == num) {
								return false;
							}
						}
					}
				}
			}
			//End of for loop
			return true;
			
		
	}
	

}
