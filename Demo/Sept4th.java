package Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sept4th {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> contacts = new ArrayList<String>();


		Scanner nani = new Scanner(System.in);


		do{
			System.out.println("Enter the name and number of the contact you wish to store"
					+ "\"DONE\" to finish.");
			
			String response = nani.nextLine();
			if(response.equals("DONE")){
				contacts.add(response));
			}
		}While(!response.equals("DONE")) {
			contacts.add(response);
		}

		String menu = "1. Add more contacts. \n2. Edit a contact. \n3. Delete a contact. \n4. View all contacts. \n5. Exit.");
		int option = nani.nextInt();
		
		if(option == 1)//Add more Contacts
		{
			System.out.println("Enter the new contacts seperated by \"Enter\" or \"DONE\"" + "when finished");
			while(nani.hasNextLine()) {
				String newName = in.NextLine();
				if(newName.equals("DONE")) {
					break;
				}
				else {
					contacts.add(newName);
				}
			}
		}
		else if(option == 2)//Edit existing contact
		{
			printPhoneBook(contacts);
			System.out.println("Select the contact to edit: ");
			int i = Integer.parseInt(in.nextLine().trim());
			System.out.println("Enter the new name and/or number: ");
			String newInfo = in.NextLine();
			contacts.set(i-1, newInfo);
			
		}
		else if(option == 3)// Delete existing contact
		{
			printPhoneBook(contacts);
			System.out.println("Select the contact to delete: ");
			int d = Integer.parseInt(in.NextLine().trim());
			contacts.remove(d-1);
			
		}
		else if(option == 4)
		{
			printPhoneBook(contacts);
		}
		else if(option == 5)
		{

		}
		else if(option > 5 || option < 1)
		{
			System.out.println("Invalid Choice.");
		}

		while(nani.hasNextLine()) {
			System.out.println("Enter the name and number of the contact you wish to store"
					+ "\"DONE\" to finish.");
			String response = nani.nextLine();
			if(response.equals("DONE")) {
				break;
			}
			contacts.add(response);
		}
		nani.close;	
	}



	public static void printPhoneBook(ArrayList<String> p) {
		Collections.sort;
		int i = 1;
		for(String name : 0) {
			System.out.println("%d. %s\n", i, name);
		}
		ArrayList<String> contacts = new ArrayList<String>();
		contacts.add("Kathy (555) 555 - 5555");
		contacts.add("Abe (555) 555 - 5555");
		contacts.add("Maria (555) 555 - 5555");
		contacts.add("Tim (555) 555 - 5555");
	}

}
