package labsCECS174;

import java.util.Scanner;

public class Lab15 {

	public static void main(String[] args) {
		
		//Create the new Scanner in order to read inputs
		Scanner nani = new Scanner (System.in);
		
		//Create constant variable for gravity
		final double GRAVITY = 9.8;
		
		//Asks user for target input once and uses Scanner to read it
		System.out.println("How far is the target? ");
		int target = nani.nextInt();
		int a = 1;
		while(a == 1) {
			
			//Asks user for Gunpowder input and uses Scanner to read it
			System.out.println("How many kg of gun powder? ");
			double gunPowder = nani.nextDouble();
			
			//Asks user for angle input and uses Scanner to read it
			System.out.println("What angle? ");
			double angle = nani.nextDouble();
			
			//Use Math functions and variables to calculate the distance
			double radian = (Math.PI / 180) * angle;
			double intitialVel = gunPowder * 10;
			double vY = intitialVel * Math.sin(radian);
			double vX = intitialVel * Math.cos(radian);
			double tA = vY / GRAVITY;
			double tG = 2 * tA;
			double distance = vX * tG;
			
			//Tests to see if the target is hit and prints if it did, and creates sentinel to end while loop
			if(distance >= (target - 1) && distance <= (target + 1)) {
				System.out.println("Target hit!");
				a = 0;
			}
			//End of first if statement 
			
			//Tests for it passing the target and printing how far it passed, also re-initiates while loop
			if(distance > (target + 1)) {
				System.out.printf("Your shot went %.2f m past the target.\r\n\n", (distance - target));
				a = 1;
			}
			//End of second if statement 
			
			//Testing for if fell short of the target and how short the difference is, also re-initiates while loop
			if(distance < target - 1) {
				System.out.printf("Your shot stopped %.2f m short of the target.\r\n\n",(target - distance));
				a = 1;
			}
			//End of third if statement
		}
		//End of while loop
		nani.close();
	}
	//End of main
}
//End of Class
