package projects;

import java.util.Scanner;

import Phonebook.Phonebook;
import edu.project3.CallLog;
import edu.project3.Contact;
import edu.project3.Favorite;
import edu.project3.FavoriteContactFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;


public class CellPhone {
	// Main funciton, calls all other functions
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Phonebook phonebook = new Phonebook();
		Phonebook favorites = new Phonebook();
		CallLog callLog = new CallLog();
		ArrayList<String> images = new ArrayList<String>(
				Arrays.asList("temp1.png", "temp2.png", "temp3.jpg", "temp4.png", "temp5.png"));
		Favorite profiles = new Favorite();

		while (true) {
			print_main_menu();
			try {
				int choice = get_menu_choice();
				if (choice == 1) {
					String name = getUserName();
					add(phonebook, favorites, profiles, images, name);
					System.out.println();
				}
				else if (choice == 2) {
					edit(phonebook, favorites, profiles, images);
				}
				else if (choice == 3) {
					display(phonebook, favorites, profiles, images);
				}
				else if (choice == 4) {
					delete(phonebook, favorites, profiles);
				}
				else if (choice == 5) {
					displayAll(phonebook, favorites);
				}
				else if (choice == 6) {
					displayFavorites(favorites, profiles);
				}
				else if (choice == 7) {
					changeFavorites(phonebook, favorites, profiles);
				}
				else if (choice == 8) {
					removeFavorite(phonebook, favorites, profiles);
				}
				else if (choice == 9) {
					callNumber(phonebook, favorites, callLog);
				}
				else if (choice == 10) {
					viewCalls(callLog);
				}
				else if (choice == 11) {
					System.out.println("\nQuitting Program ");
					break;
				}
				phonebook.sortContacts();
			}

			catch (InputMismatchException ime) {
				System.out.println("You're dumb, put a fking integer. Try again. \n");
			}
		}
	}

	// Prints menu
	public static void print_main_menu() {
		System.out.println("–Cellphone Main Menu– \n1. Add a new contact \n2. Edit a contact \n3. Display a contact \n4. Delete a contact \n5. Display all contacts"
				+ " \n6. Display Favorites \n7. Add Favorite \n8. Remove Favorite \n9. Call Number \n10. View Call Log \n11. Quit");
	}

	// Gets user's menu choice
	public static int get_menu_choice() {
		Scanner in = new Scanner(System.in);
		System.out.print("Choose Option: ");
		int choice = in.nextInt();
		while (choice < 1 || choice > 11) {
			System.out.println("Invalid choice, try again. ");
			System.out.print("Choose Option: ");
			choice = in.nextInt();
		}
		return choice;
	}

	// Adds contact to contact list
	public static String getUserName() {
		Scanner in = new Scanner(System.in);

		System.out.print("\nEnter name: ");
		String name = in.nextLine();

		return name;
	}

	public static void add(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<String> images, String name) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();

		System.out.print("Enter number: ");
		String number = in.nextLine();
		System.out.print("Enter email: ");
		String email = in.nextLine();
		System.out.print("Enter notes: ");
		String note = in.nextLine();

		Contact contact = new Contact(name, number, email, note);
		phonebook.addContact(contact);
		if (favorites.getSize() < 5) {
			favorites.addContact(contact);

			int fWidth = 900;
			int fHeight = 600;
			// Random int selection is Max value - Min value + 1 lol
			int pic = rand.nextInt((images.size()-1) - 0 + 1);
			FavoriteContactFrame profile = new FavoriteContactFrame("/Users/tristannguyen/Downloads/" + images.get(pic), fWidth, fHeight, name, number, email, note);
			images.remove(pic);
			profiles.addFavorite(profile);
		}		
	}

	// Edits contact based on their name
	public static void edit(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<String> images) {
		Scanner in = new Scanner(System.in);

		System.out.print("\nEnter name to edit: ");
		String name = in.nextLine().trim();
		Contact editContact = phonebook.getContact(name);
		if (editContact != null) {
			System.out.println("\nEnter category to edit: \n1. Name \n2. Number \n3. Email \n4. Notes ");
			System.out.print("Choose Option: ");
			int category = in.nextInt();
			in.nextLine();
			while (category < 1 || category > 4) {
				System.out.println("Invalid choice, try again. ");
				System.out.print("Choose Option: ");
				category = in.nextInt();
			}
			if (category == 1) {
				System.out.print("Enter new name: ");
				String newName = in.nextLine().trim();
				editContact.setName(newName);
			}
			else if (category == 2) {
				System.out.print("Enter new number: ");
				String newNumber = in.nextLine().trim();
				editContact.setNumber(newNumber);
			}
			else if (category == 3) {
				System.out.print("Enter new email: ");
				String newEmail = in.nextLine().trim();
				editContact.setEmail(newEmail);
			}
			else if (category == 4) {
				System.out.print("Enter new notes: ");
				String newNotes = in.nextLine().trim();
				editContact.setNotes(newNotes);
			}
		} else {
			System.out.println("\nName not found. Choose option below: ");
			System.out.println("1. Create contact with given name \n2. Enter a different name \n3. Go back to main menu ");
			System.out.print("Choose Option: ");
			int choice = in.nextInt();

			while (choice < 1 || choice > 3) {
				System.out.println("Invalid choice, try again. ");
				System.out.print("Choose Option: ");
				choice = in.nextInt();
			}

			// Hey look a memory leak, but all fixed lol
			in.nextLine();

			if (choice == 1) {
				add(phonebook, favorites, profiles, images, name);
			}
			else if (choice == 2) {
				edit(phonebook, favorites, profiles, images);
			}
			else if (choice == 3) {
				System.out.println("Back to main menu ");
			}
		}
		System.out.println();
	}

	// Displays a contact based on contact's name
	public static void display(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<String> images) {
		Scanner in = new Scanner(System.in);

		System.out.print("\nEnter name to display: ");
		String name = in.nextLine();
		Contact displayContact = phonebook.getContact(name);
		if (displayContact != null) {
			System.out.print(displayContact);

			FavoriteContactFrame displayFrame = profiles.getFavorite(name);
			if (displayFrame != null) {
				displayFrame.displayContactFrame();
			}

		} else {
			System.out.println("\nName not found. Choose option below: ");
			System.out.println("1. Create contact with given name \n2. Enter a different name \n3. Go back to main menu ");
			System.out.print("Choose Option: ");
			int choice = in.nextInt();

			while (choice < 1 || choice > 3) {
				System.out.println("Invalid choice, try again. ");
				System.out.print("Choose Option: ");
				choice = in.nextInt();
			}

			// Hey look another memory leak lol
			in.nextLine();

			if (choice == 1) {
				add(phonebook, favorites, profiles, images, name);
			}
			else if (choice == 2) {
				display(phonebook, favorites, profiles, images);
			}
			else if (choice == 3) {
				System.out.println("Back to main menu ");
			}
		}	
		System.out.println();
	}

	// Deletes contact from contact list
	public static void delete(Phonebook phonebook, Phonebook favorites, Favorite profiles) {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter name to delete: ");
		String name = in.nextLine().trim();
		Contact deleteContact = phonebook.getContact(name);

		// If contact exists
		if (deleteContact != null) {
			System.out.println("Contact Deleted. ");
			phonebook.deleteContact(deleteContact, name);
			FavoriteContactFrame deleteFavorite = profiles.getFavorite(name);
			if (favorites.deleteContact(deleteContact, name)) {
				if (profiles.removeFav(deleteFavorite, name)) {
					System.out.println("Profile removed. ");
				}
				int index = 0;
				while (index < phonebook.getSize()) {
					// Gets Contact name at certain index
					Contact newFavorite = phonebook.getContactAtIndex(index);
					String favoriteName = newFavorite.getName();

					FavoriteContactFrame newProfile = getFavContactFrame(deleteFavorite, newFavorite);

					// If the contact already exists in favorites, then try adding different contact
					if (favorites.getContact(favoriteName) != null) {
						index++;
					} else {
						System.out.println("Favorite Replaced. ");
						favorites.addContact(newFavorite);
						System.out.println("Profile Replaced. ");
						profiles.addFavorite(newProfile);
						break;
					}	
				}
			}
		} else {
			System.out.println("Name not found. Choose option below: ");
			System.out.println("1. Enter Different Name \n2. Back to Main Menu ");
			System.out.print("Choose Option: ");
			int choice = in.nextInt();
			while (choice < 1 || choice > 2) {
				System.out.println("Invalid choice, try again. ");
				System.out.print("Choose Option: ");
				choice = in.nextInt();
			}

			if (choice == 1) {
				delete(phonebook, favorites, profiles);
			}
			else if (choice == 2) {
				System.out.println("Back to main menu ");
			}
		}
		System.out.println();
	}

	// Prints contacts list
	public static void displayAll(Phonebook phonebook, Phonebook favorites) {
		System.out.println("\n–Favorites–");
		System.out.println(favorites.displayName());
		System.out.println("\n–All Contacts–");
		System.out.println(phonebook);
	}

	// Prints favorites list
	public static void displayFavorites(Phonebook favorites, Favorite profiles) {
		System.out.println("\n–Favorites–");
		System.out.println(favorites.displayName());
		profiles.showFavs();
	}

	// Allows user to add selected contact to any position in favorite
	public static void changeFavorites(Phonebook phonebook, Phonebook favorites, Favorite profiles) {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter name to add to favorites: ");
		String person = in.nextLine().trim();
		Contact replace = phonebook.getContact(person);

		boolean inFavorites = false;
		for (int i=0; i<favorites.getSize(); i++) {
			if (replace == favorites.getContactAtIndex(i) ) {
				inFavorites = true;
				System.out.println("Contact is already in Favorites. Back to menu. \n");
			}
		}

		if (replace != null && !inFavorites) {
			System.out.println("\nSelect Favorite Rank for " + person + ": ");
			System.out.println(favorites.displayName());
			System.out.print("Change: ");
			int index = in.nextInt() - 1;
			while (index < 0 || index > favorites.getSize() - 1) {
				System.out.println("Invalid choice, try again. ");
				System.out.print("Change: ");
				index = in.nextInt() - 1;
			}

			// I just swap the images from favorite to new favorite cause I only have 5 pictures...
			FavoriteContactFrame favReplace = profiles.getFavoriteAt(index);

			FavoriteContactFrame newProfile = getFavContactFrame(favReplace, replace);

			favorites.replaceContact(index, replace);
			System.out.println("Favorite Changed. \n");

			profiles.replaceFav(index, newProfile);
		}

		else if (replace == null) {
			System.out.println("Name not found. Back to nenu. \n");
		}
	}

	// Removes favorite and replaces it with next contact in sorted list
	public static void removeFavorite(Phonebook phonebook, Phonebook favorites, Favorite profiles) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nSelect which Favorite to Remove: ");
		System.out.println(favorites.displayName());
		System.out.print("Remove: ");
		int remove = in.nextInt() - 1;
		while (remove > favorites.getSize() - 1 || remove < 0) {
			System.out.println("Invalid choice, try again. ");
			System.out.print("Remove: ");
			remove = in.nextInt() - 1;
		}
		Contact removeContact = favorites.getContactAtIndex(remove);
		String removeName = removeContact.getName();
		Contact removeFavorite = favorites.getContact(removeName);
		favorites.deleteContact(removeFavorite, removeName);
		System.out.println("Favorite removed. ");

		FavoriteContactFrame deleteFavorite = profiles.getFavorite(removeName);
		if (profiles.removeFav(deleteFavorite, removeName)) {
			// System.out.println("Profile Replaced. ");
		}

		int index = 0;
		while (index < phonebook.getSize()) {
			Contact newFavorite = phonebook.getContactAtIndex(index);
			String favoriteName = newFavorite.getName();

			// I just swap the images from favorite to new favorite cause I only have 5 pictures...
			FavoriteContactFrame newProfile = getFavContactFrame(deleteFavorite, newFavorite);

			// If contact is already in favorites, or contact is the same contact that just got removed
			if ((favorites.getContact(favoriteName) != null) || (removeName.equals(favoriteName))) {
				index++;
			} else {
				System.out.println("Favorite replaced. ");
				favorites.addContact(newFavorite);
				System.out.println("Profile Replaced. ");
				profiles.addFavorite(newProfile);
				break;
			}	
		}
		// Blank line
		System.out.println();
	}

	// Calls contact using their number then logs the call to callLog
	public static void callNumber(Phonebook phonebook, Phonebook favorites, CallLog callLog) {
		Scanner in = new Scanner(System.in);
		System.out.print("\nCall: ");
		String number = in.nextLine().trim();
		int index = favorites.getSize() + 1;

		if (number.equals("1")) {
			index = Integer.parseInt(number);
		}
		else if (number.equals("2")) {
			index = Integer.parseInt(number);
		}
		else if (number.equals("3")) {
			index = Integer.parseInt(number);
		}
		else if (number.equals("4")) {
			index = Integer.parseInt(number);
		}
		else if (number.equals("5")) {
			index = Integer.parseInt(number);
		}

		boolean numberFound = false;
		if (index <= favorites.getSize()) {
			Contact favorite =favorites.getContactAtIndex(index - 1);
			numberFound = true;

			String name = favorite.getName();
			numberFound(phonebook, callLog, name);		
		} else {
			for (int i=0; i<phonebook.getSize(); i++) {
				Contact call = phonebook.getContactAtIndex(i);
				if (call.getNumber().equals(number) || call.getName().equals(number)) {
					numberFound = true;
					String name = call.getName();
					numberFound(phonebook, callLog, name);		
				}
			}
		}
		if (!numberFound) {
			System.out.println("Number not in contacts. ");
			System.out.println("Calling... " + number);

			String date = getCallDate();
			Contact testContact = new Contact("Unknown", number, date);
			callLog.logCall(testContact);
		}
		System.out.println();
	}

	public static FavoriteContactFrame getFavContactFrame(FavoriteContactFrame oldFavorite, Contact newFavorite) {
		String image = oldFavorite.getDirectory();
		int fWidth = 900;
		int fHeight = 600;
		FavoriteContactFrame newProfile = new FavoriteContactFrame(image, fWidth, fHeight, newFavorite.getName(), newFavorite.getNumber(), newFavorite.getEmail(), newFavorite.getNotes());

		return newProfile;
	}

	public static String getCallDate() {
		Date now = new Date();
		String day = new SimpleDateFormat("yyyy/MM/dd").format(now);
		String time = new SimpleDateFormat("HH:mm:ss").format(now);
		String date = "Date: " + day + "   Time: " + time + "   Type: Outgoing";

		return date;
	}

	public static void numberFound(Phonebook phonebook, CallLog callLog, String name) {
		System.out.println("Calling... " + name);

		String date = getCallDate();

		Contact nameCalled = phonebook.getContact(name);
		Contact testContact = new Contact(nameCalled.getName(), nameCalled.getNumber(), date);

		alreadyCalled(callLog, nameCalled, testContact, date);	
	}

	public static void alreadyCalled(CallLog callLog, Contact nameCalled, Contact testContact, String date) {
		boolean alreadyCalled = false;
		for (int j=0; j<callLog.getSize(); j++) {
			Contact test = callLog.getContactAtIndex(j);
			// If user has been called before, then add new call to log without name/number
			if (test.getNumber().equals(nameCalled.getNumber())) {
				alreadyCalled = true;
				String newDate = test.getDate() + "\n" + date;
				testContact.setDate(newDate);
				callLog.editLog(j, testContact);
			}
		}
		// If contact hasn't been called yet add to callLog
		if (!alreadyCalled) {
			callLog.logCall(testContact);
		}		
	}

	// Prints callLog
	public static void viewCalls(CallLog callLog) {
		System.out.println();
		System.out.print(callLog.toString());
	}
}