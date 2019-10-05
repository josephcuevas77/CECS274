package labs;

import java.util.Scanner;
import java.util.ArrayList; 
import java.util.Collections;

public class Lab1 {

	public static void main(String[] args) {
		ArrayList<String> guestList = new ArrayList<String>();

		Scanner nani = new Scanner(System.in);

		//Ask for the date of the party
		System.out.println("Let's get this party started! Enter the date of your event.");
		String date = nani.nextLine();
		
		//Ask user for name of event
		System.out.println("Good. Now what would you like to call your event?");
		String name = nani.nextLine();

		
		//Ask user for maximum amount of guests
		System.out.println("What is the maximum amount of guests allowed?");
		int max = Integer.parseInt(nani.nextLine().trim());

		
		System.out.println("Thank you. Please enter the name of each guest followed by \"ENTER\". When you are done, enter \"DONE\".");
		String guest;
		//Initiates a counter for the number of guests
		int numberOfGuests = 0;

		do{
			System.out.println("Guest Name: ");
			guest = nani.nextLine();
			//Adds the name to the array as long the user does not input "DONE"
			if(!guest.equals("DONE")) {
				guestList.add(guest);
				//Adds one to counter to keep track of guests
				numberOfGuests += 1;
				
			}
			//Checks to ensure user does not exceed inputed number for maximum guests
			if(numberOfGuests >= max) {
				System.out.println("Reached maximum amount of guests.");
				break;
			}
		//Continues to do loop while the user does not input "DONE"
		}while(!guest.equals("DONE"));

		//Prints out all the info inputed into program
		System.out.println("This is the information for your " + name + " event: ");
		System.out.println("Date: " + date);
		System.out.println("Max Num. Of Guests: " + max);
		System.out.println("Current Num. Of Guests: " + numberOfGuests);
		System.out.println("Current Guests: ");
		printGuestList(guestList);
		System.out.println("Have a fun party!");

	}
	//Creates a function to alphabetically sort the names in the list
	public static void printGuestList(ArrayList<String> g) {
		Collections.sort(g);
		
		for(String name : g) {
			System.out.printf("%s\n", name);
			
		}
		
	}

}
