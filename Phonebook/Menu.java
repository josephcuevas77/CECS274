package Phonebook;

import java.util.Scanner;
import java.util.ArrayList;


public class Menu {

	public static void main(String[] args) {

		Scanner nani = new Scanner(System.in);
		int response = 0;
		
		System.out.println("MENU\n1.Add a new Contact\n2.Edit a Contact\n3.Display a Contact\n4.Delete a Contact"
				+ "\n5.Display all Contacts\n6.Quit");
		System.out.println("Please Select One of the Options.");
		response = nani.nextInt();
		while(response < 1 || response > 6) {
			System.out.println("Please Select One of the Options.");
			response = nani.nextInt();	
		}
		while(response >= 1 && response <= 6) {
			if(response == 1) {
				System.out.println("Contact Name: ");
				String name = nani.nextLine();
				System.out.println("Contact Number: ");
				String number = nani.nextLine();
				System.out.println("Contact E-mail: ");
				String email = nani.nextLine();
				System.out.println("Contact Notes: ");
				String notes = nani.nextLine();
				
				ArrayList <ContactEntry> Contacts = new ArrayList <ContactEntry> ();
				
			}
			if(response == 2) {
				
			}
			if(response == 3){
				
			}
			if(response == 4){
				
			}
			if(response == 5){
				
			}
			if(response == 6){
				System.out.println("Thank you for using this menu. Goodbye");
				break;
			}
		}

	}

}
