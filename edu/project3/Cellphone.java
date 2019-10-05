package edu.project3;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;

public class Cellphone {

	// Main funciton, calls all other functions
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Phonebook phonebook = new Phonebook();
		Phonebook favorites = new Phonebook();
		// List of image locations
		ArrayList<String> images = new ArrayList<String>(Arrays.asList("temp1.png", "temp2.png", "temp3.jpg", "temp4.png", "temp5.png"));
		// Checks for duplicates
		ArrayList<Contact> duplicateCheck = new ArrayList<Contact>();
		CallLog callLog = new CallLog();
		Favorite profiles = new Favorite();

		// Preset names
		String[] presetNames = {"Tristan", "Joey", "Joseph", "Bryan", "Josh"};

		// Preset favorites
		for (int i=0; i<5; i++) {
			String presetName = presetNames[i];
			String num = Integer.toString(i+1);
			Contact preset = new Contact(presetName, num, "Email " + num, "Notes " + num);
			add(phonebook, favorites, preset, images, profiles);
		}

		while (true) {
			print_main_menu();
			try {
				int choice = get_menu_choice();
				if (choice == 1) {
					String name = getUserName();
					Contact contact = getContactInfo(phonebook, name);
					add(phonebook, favorites, contact, images, profiles);
					System.out.println();
				}
				else if (choice == 2) {
					edit(phonebook, favorites, profiles, images, duplicateCheck);
				}
				else if (choice == 3) {
					display(phonebook, favorites, profiles, images, duplicateCheck);
				}
				else if (choice == 4) {
					delete(phonebook, favorites, profiles, duplicateCheck, images);
				}
				else if (choice == 5) {
					if (phonebook.getSize() > 0) {
						displayAll(phonebook, favorites);
					}
					else {
						System.out.println("\nNo contacts exist.\n ");
					}
				}
				else if (choice == 6) {
					if (favorites.getSize() > 0) {
						int option = favoriteOption(favorites);
						if (option == 1) {
							moveFavorites(favorites, profiles);
						}
						else if (option == 2) {
							changeFavorites(phonebook, favorites, profiles, duplicateCheck);
						}
						else if (option == 3) {
							removeFavorite(phonebook, favorites, profiles, images);
						}
						else if (option == 4) {
							displayFavorite(favorites, profiles);
						}
					} else {
						System.out.println("\nFavorites is empty.\n ");
					}
				}
				else if (choice == 7) {
					if (favorites.getSize() > 0) {
						displayAllFavorites(favorites, profiles);
						profiles.showFavs();
					} else {
						System.out.println("\nFavorites is empty.\n ");
					}
				}
				else if (choice == 8) {
					callNumber(phonebook, favorites, callLog, duplicateCheck, "Outgoing");
				}
				else if (choice == 9) {
					callNumber(phonebook, favorites, callLog, duplicateCheck, "Incoming");
				}
				else if (choice == 10) {
					if (callLog.getSize() > 0) {
						viewCalls(callLog);
					} else {
						System.out.println("\nCall Log is empty.\n ");
					}
				}
				else if (choice == 11) {
					System.out.println("\nExitting Program ");
					in.close();
					break;
				}
				// Needs to be empty every run through
				duplicateCheck.clear();

				// Sorts by name
				phonebook.sortContacts();
			}
			catch (InputMismatchException ime) {
				System.out.println("\nEnter an integer next time. \n");
			}
		}
	}

	// Prints menu
	public static void print_main_menu() {
		System.out.println("–Cellphone Main Menu– \n1. Add a New Contact \n2. Edit a Contact \n3. Display a Contact \n4. Delete a Contact \n5. Display All Contacts"
				+ " \n6. Interact with Favorites \n7. Display All Favorites \n8. Make a Call \n9. Receive Call \n10. Display Call Log \n11. Quit");
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

	// Gets only the contact name
	public static String getUserName() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter name: ");
		String name = in.nextLine();
		return name;
	}

	// Adds contact to contact list with given name
	public static Contact getContactInfo(Phonebook phonebook, String name) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter number: ");
		String number = in.nextLine();

		for (int i=0; i<phonebook.getSize(); i++) {
			Contact c = phonebook.getContactAtIndex(i);
			while (c.getNumber().equals(number)) {
				System.out.println("Number is taken. Try again. ");
				System.out.print("Enter number: ");
				number = in.nextLine();
			}
		}

		System.out.print("Enter email: ");
		String email = in.nextLine();
		System.out.print("Enter notes: ");
		String note = in.nextLine();

		Contact contact = new Contact(name, number, email, note);
		return contact;
	}

	// Adds contacts
	public static void add(Phonebook phonebook, Phonebook favorites, Contact contact, ArrayList<String> images, Favorite profiles) {
		Random rand = new Random();
		phonebook.addContact(contact);
		if (favorites.getSize() < 5) {
			favorites.addContact(contact);

			int fWidth = 900;
			int fHeight = 600;
			// Random int selection is Max value - Min value + 1 lol
			int picture = rand.nextInt((images.size()-1) - 0 + 1);
			FavoriteContactFrame profile = new FavoriteContactFrame("/Users/tristannguyen/Downloads/" + images.get(picture), fWidth, fHeight, contact.getName(), contact.getNumber(), contact.getEmail(), contact.getNotes());
			images.remove(picture);
			profiles.addFavorite(profile);
		}		
	}

	// Edits contact based on their name
	public static void edit(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<String> images, ArrayList<Contact> duplicates) {
		Scanner in = new Scanner(System.in);

		System.out.print("\nEnter name to edit: ");
		String name = in.nextLine().trim();
		Contact editContact = checkDupe(phonebook, duplicates, name);

		// If contact with given name exists
		if (editContact != null) {
			System.out.println("\nCategory: \n1. Name \n2. Number \n3. Email \n4. Notes ");
			System.out.print("Choose Option: ");
			int category = in.nextInt();
			// Memory leak again xD
			in.nextLine();
			boolean inFavorites = false;
			int j = 0;
			for (int i=0; i<favorites.getSize(); i++) {
				if (editContact.equals(favorites.getContactAtIndex(i))) {
					j = i;
					inFavorites = true;
					break;
				}
			}
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
			if (inFavorites) {
				favorites.replaceContact(j, editContact);
				FavoriteContactFrame favReplace = profiles.getFavoriteAt(j);
				FavoriteContactFrame newProfile = getFavContactFrame(favReplace, editContact);
				profiles.replaceFav(j, newProfile);
			}

		} else {
			int choice = editDisplayChoice();
			if (choice == 1) {
				System.out.println();
				Contact contact = getContactInfo(phonebook, name);
				add(phonebook, favorites, contact, images, profiles);
			}
			else if (choice == 2) {
				edit(phonebook, favorites, profiles, images, duplicates);
			}
			else if (choice == 3) {
				System.out.println("Back to main menu ");
			}
		}
		System.out.println();
	}

	// Displays a contact based on contact's name
	public static void display(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<String> images, ArrayList<Contact> duplicates) {
		Scanner in = new Scanner(System.in);

		System.out.print("\nEnter name to display: ");
		String name = in.nextLine();
		Contact displayContact = checkDupe(phonebook, duplicates, name);
		System.out.println();

		if (displayContact != null) {
			System.out.print(displayContact);

			FavoriteContactFrame displayFrame = profiles.getFavorite(name);
			// If the frame exists
			if (displayFrame != null) {
				displayFrame.displayContactFrame();
			}

		} else {
			int choice = editDisplayChoice();
			if (choice == 1) {
				System.out.println();
				Contact contact = getContactInfo(phonebook, name);
				add(phonebook, favorites, contact, images, profiles);
			}
			else if (choice == 2) {
				display(phonebook, favorites, profiles, images, duplicates);
			}
			else if (choice == 3) {
				System.out.println("Back to main menu ");
			}
		}	
		System.out.println();
	}

	// Adds contact from edit and display
	public static int editDisplayChoice() {
		Scanner in = new Scanner(System.in);
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

		return choice;
	}

	// Deletes contact from contact list
	public static void delete(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<Contact> duplicates, ArrayList<String> images) {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter name to delete: ");
		String name = in.nextLine().trim();
		Contact deleteContact = checkDupe(phonebook, duplicates, name);

		// If contact exists
		if (deleteContact != null) {
			System.out.println("Contact Deleted. ");
			phonebook.deleteContact(deleteContact, name);
			FavoriteContactFrame deleteFavorite = profiles.getFavorite(name);
			if (favorites.deleteContact(deleteContact, name)) {
				if (profiles.removeFav(deleteFavorite, name)) {
					// System.out.println("Profile removed. ");
				}
				String directory = deleteFavorite.getDirectory();
				String location = directory.substring(31, directory.length()).trim(); 
				images.add(location);
				int index = 0;
				while (index < phonebook.getSize()) {
					// Gets Contact name at certain index
					Contact newFavorite = phonebook.getContactAtIndex(index);
					String favoriteName = newFavorite.getName();

					// If the contact already exists in favorites, then try adding different contact
					if (favorites.getContact(favoriteName) != null) {
						index++;
					} else {
						System.out.println("Favorite Replaced. ");
						favorites.addContact(newFavorite);
						FavoriteContactFrame newProfile = replaceFavContactFrame(deleteFavorite, newFavorite, images);
						// System.out.println("Profile Replaced. ");
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
				delete(phonebook, favorites, profiles, duplicates, images);
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
	public static void displayAllFavorites(Phonebook favorites, Favorite profiles) {
		System.out.println("\n–Favorites–");
		System.out.println(favorites.displayName());
	}

	// Picks which favorite function to call
	public static int favoriteOption(Phonebook favorites) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nOptions: \n1. Move Favorites \n2. Add New Favorite \n3. Remove Favorite \n4. Display One Favorite ");
		System.out.print("Pick Option: ");
		int option = in.nextInt();
		while (option < 1 || option > 4) {
			System.out.println("Invalid Choice. ");
			System.out.print("Pick Option: ");
			option = in.nextInt();
		}
		return option;
	}

	// Moves favorites around
	public static void moveFavorites(Phonebook favorites, Favorite profiles) {
		Scanner in = new Scanner(System.in);
		System.out.println("\nFavorite Rank: ");
		System.out.println(favorites.displayName());
		System.out.print("Move rank: ");
		int index = in.nextInt() - 1;
		while (index < 0 || index > favorites.getSize() - 1) {
			System.out.println("Invalid choice, try again. ");
			System.out.print("Move rank: ");
			index = in.nextInt() - 1;
		}
		Contact moveFav = favorites.getContactAtIndex(index);		
		FavoriteContactFrame moveFrame = profiles.getFavoriteAt(index);

		System.out.print("Move " +  moveFav.getName() + " to rank: ");
		int newIndex = in.nextInt() - 1;
		while (newIndex < 0 || newIndex > favorites.getSize() - 1) {
			System.out.println("Invalid choice, try again. ");
			System.out.print("Move " +  moveFav.getName() + " to rank: ");
			newIndex = in.nextInt() - 1;
		}
		System.out.println(moveFav.getName() + " moved to rank " + (newIndex+1));
		favorites.deleteContact(moveFav, moveFav.getName());
		profiles.removeFav(moveFrame, moveFav.getName());

		favorites.insertContact(newIndex, moveFav);
		profiles.insertFav(newIndex, moveFrame);

		// Blank line
		System.out.println();
	}

	// Allows user to add selected contact to any position in favorite
	public static void changeFavorites(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<Contact> duplicates) {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter name to add to favorites: ");
		String newFav = in.nextLine().trim();
		Contact replace = checkDupe(phonebook, duplicates, newFav);

		boolean inFavorites = false;
		for (int i=0; i<favorites.getSize(); i++) {
			if (replace == favorites.getContactAtIndex(i) ) {
				inFavorites = true;
				System.out.println("Contact is already in Favorites. Back to menu. \n");
			}
		}

		if (replace != null && !inFavorites) {
			System.out.println("\nSelect Favorite Rank for " + newFav + ": ");
			System.out.println(favorites.displayName());
			System.out.print("Change: ");
			int index = in.nextInt() - 1;
			while (index < 0 || index > favorites.getSize() - 1) {
				System.out.println("Invalid choice, try again. ");
				System.out.print("Change: ");
				index = in.nextInt() - 1;
			}

			// I just swap the images from old favorite to new favorite cause I only have 5 pictures...
			FavoriteContactFrame favReplace = profiles.getFavoriteAt(index);
			FavoriteContactFrame newProfile = getFavContactFrame(favReplace, replace);

			favorites.replaceContact(index, replace);
			System.out.println("Favorite Changed. \n");
			profiles.replaceFav(index, newProfile);
		}

		else if (replace == null) {
			System.out.println("Name not found. Back to main menu. \n");
		}
	}

	// Removes favorite and replaces it with next contact in sorted list
	public static void removeFavorite(Phonebook phonebook, Phonebook favorites, Favorite profiles, ArrayList<String> images) {
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
		String directory = deleteFavorite.getDirectory();
		String location = directory.substring(31, directory.length()).trim(); 
		images.add(location);
		if (profiles.removeFav(deleteFavorite, removeName)) {
			// System.out.println("Profile Replaced. ");
		}

		int index = 0;
		while (index < phonebook.getSize()) {
			Contact newFavorite = phonebook.getContactAtIndex(index);
			String favoriteName = newFavorite.getName();

			// If contact is already in favorites, or contact is the same contact that just got removed
			if ((favorites.getContact(favoriteName) != null) || (removeName.equalsIgnoreCase(favoriteName))) {
				index++;
			} else {
				System.out.println("Favorite replaced. ");
				favorites.addContact(newFavorite);
				// I just swap the images from favorite to new favorite cause I only have 5 pictures...
				FavoriteContactFrame newProfile = replaceFavContactFrame(deleteFavorite, newFavorite, images);
				profiles.addFavorite(newProfile);
				break;
			}	
		}
		// Blank line
		System.out.println();
	}

	// Displays one specific favorite
	public static void displayFavorite(Phonebook favorites, Favorite profiles) {
		Scanner in = new Scanner(System.in);
		displayAllFavorites(favorites, profiles);
		System.out.print("Favorite rank to display: ");
		int choice = in.nextInt() - 1;
		while (choice > favorites.getSize() - 1 || choice < 0) {
			System.out.println("Invalid choice, try again. ");
			System.out.print("Favorite rank to display: ");
			choice = in.nextInt() - 1;
		}

		Contact displayContact = favorites.getContactAtIndex(choice);
		System.out.println();
		System.out.println(displayContact);
		FavoriteContactFrame displayFav = profiles.getFavoriteAt(choice);
		displayFav.displayContactFrame();
	}

	// Calls contact using their number then logs the call to callLog
	public static void callNumber(Phonebook phonebook, Phonebook favorites, CallLog callLog, ArrayList<Contact> duplicates, String type) {
		Scanner in = new Scanner(System.in);
		System.out.print("\n–Enter name or number below–\nCall: ");
		String number = in.nextLine().trim();
		String num = "";
		String name = "";
		int option = 0;

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
			name = favorite.getName();
			num = favorite.getNumber();
			System.out.println("Speed Dial: " + (index));
			numberFound(phonebook, callLog, name, num, type);		
		} else {
			for (int i=0; i<phonebook.getSize(); i++) {
				Contact call = phonebook.getContactAtIndex(i);
				if (call.getNumber().equalsIgnoreCase(number) || call.getName().equalsIgnoreCase(number)) {
					duplicates.add(call);
					numberFound = true;
					name = call.getName();
					num = call.getNumber();
				}
			}
			if (duplicates.size() == 1) {
				numberFound(phonebook, callLog, name, num, type);
			} else if (duplicates.size() > 1){
				System.out.println("\n" + duplicates.size() + " contacts share that name: ");
				for (int j=0; j<duplicates.size(); j++) {
					Contact c = duplicates.get(j);
					if (c != null) {
						System.out.println("–Contact " + (j+1) + "– \nName: " + c.getName() + "\n" + "Number: " + c.getNumber() + "\n");
					}
				}
				System.out.print("Pick contact: ");
				int choice = in.nextInt();
				while (choice <= 0 || choice > duplicates.size()) {
					System.out.print("Invalid choice. \nPick contact: ");
					choice = in.nextInt();
				}

				Contact newCall = duplicates.get(choice - 1);
				numberFound(phonebook, callLog, newCall.getName(), newCall.getNumber(), type);
			}
		}

		// Determines if the entered info is a number or name
		boolean isName = false;
		for (int k=0; k<number.length(); k++) {
			if (Character.isLetter(number.charAt(k)) && !numberFound) {
				isName = true;
				break;
			}
		}

		if (!numberFound && !isName) {
			// System.out.println("Number not in contacts. ");			
			numberFound(phonebook, callLog, null, number, type);
		}
		if (isName) {
			System.out.println("Name not in contacts. ");
			System.out.println("\nWould you like to: \n1. Try again \n2. Return to main menu");
			System.out.print("Option: ");
			option = in.nextInt();
			while (option < 1 || option > 2) {
				System.out.println("Invalid choice. ");
				System.out.print("Option: ");
				option = in.nextInt();
			}
			if (option == 1) {
				callNumber(phonebook, favorites, callLog, duplicates, type);
			}
			else if (option == 2) {
				System.out.println("Back to main menu. ");
			}
		}
		if (option != 1) {
			System.out.println();
		}
	}

	// Checks for duplicate names
	public static Contact checkDupe(Phonebook phonebook, ArrayList<Contact> duplicates, String name) {
		Scanner in = new Scanner(System.in);

		Contact finalContact = null;

		for (int i=0; i<phonebook.getSize(); i++) {
			Contact tester = phonebook.getContactAtIndex(i);
			if (tester.getName().equals(name)) {
				duplicates.add(tester);
			}
		}
		if (duplicates.size() == 1) {
			finalContact = duplicates.get(0);
		}
		else if (duplicates.size() > 0) {
			System.out.println("\n" + duplicates.size() + " contacts share that name: ");
			for (int j=0; j<duplicates.size(); j++) {
				Contact c = duplicates.get(j);
				if (c != null) {
					System.out.println("–Contact " + (j+1) + "– \nName: " + c.getName() + "\n" + "Number: " + c.getNumber() + "\n");
				}
			}
			System.out.print("Pick contact: ");
			int choice = in.nextInt();
			while (choice <= 0 || choice > duplicates.size()) {
				System.out.print("Invalid choice. \nPick contact: ");
				choice = in.nextInt();
			}

			finalContact = duplicates.get(choice - 1);
		}
		duplicates.clear();
		return finalContact;
	}

	// Gets new images for favorite contact frames to replace old ones
	public static FavoriteContactFrame replaceFavContactFrame(FavoriteContactFrame oldFavorite, Contact contact, ArrayList<String> images) {
		Random rand = new Random();
		int fWidth = 900;
		int fHeight = 600;
		// Random int selection is Max value - Min value + 1 lol
		int picture = rand.nextInt((images.size()-1) - 0 + 1);
		FavoriteContactFrame profile = new FavoriteContactFrame("/Users/tristannguyen/Downloads/" + images.get(picture), fWidth, fHeight, contact.getName(), contact.getNumber(), contact.getEmail(), contact.getNotes());
		images.remove(picture);

		return profile;
	}

	public static FavoriteContactFrame getFavContactFrame(FavoriteContactFrame oldFavorite, Contact newFavorite) {
		int fWidth = 900;
		int fHeight = 600;
		// Gives new favorite the old favorites photo cause I only have 5 photos...
		FavoriteContactFrame newProfile = new FavoriteContactFrame(oldFavorite.getDirectory(), fWidth, fHeight, newFavorite.getName(), newFavorite.getNumber(), newFavorite.getEmail(), newFavorite.getNotes());
		return newProfile;
	}

	// Gets only the day of the call
	public static String getDay() {
		Date now = new Date();
		String day = new SimpleDateFormat("yyyy/MM/dd").format(now);
		return day;
	}

	// Gets full date/time of calls with type of call as parameter
	public static String getCallDate(String type) {
		Date now = new Date();
		String day = getDay();
		String time = new SimpleDateFormat("HH:mm:ss").format(now);
		String date = "Date: " + day + "   Time: " + time + "   Type: " + type;
		return date;
	}

	// When number is in contacts add call to call log
	public static void numberFound(Phonebook phonebook, CallLog callLog, String name, String number, String type) {
		if (name != null) {
			System.out.println("Calling... " + name);
		}
		else {
			System.out.println("Calling... " + number);
		}

		String date = "";
		date = getCallDate(type);

		Contact nameCalled = new Contact("Unknown", number, date);

		// If contact exists
		if (phonebook.getContactWithNum(number) != null) {
			nameCalled = phonebook.getContactWithNum(number);
		}
		Contact testContact = new Contact(nameCalled.getName(), nameCalled.getNumber(), date);

		// Check if contact has been called before (in the same day)
		alreadyCalled(callLog, nameCalled, testContact, date);	
	}

	// If number has been called before only add new date
	public static void alreadyCalled(CallLog callLog, Contact nameCalled, Contact testContact, String date) {
		boolean alreadyCalled = false;

		for (int j=0; j<callLog.getSize(); j++) {
			Contact test = callLog.getContactAtIndex(j);
			// If user has been called before, then add new call to log without name/number
			if (test.getNumber().equals(nameCalled.getNumber())) {
				String day1 = getDay();
				// Index fpr getting only the day from date
				String day2 = date.substring(6, 16); 

				// Checks if contact has been called that day already
				if (day1.equals(day2)) {
					alreadyCalled = true;
					String newDate = test.getDate() + "\n" + date;
					testContact.setDate(newDate);
					callLog.editLog(j, testContact);
				}
			}
		}
		// If contact hasn't been called yet add to callLog
		if (!alreadyCalled) {
			callLog.logCall(testContact);
		}		
	}

	// Prints CallLog
	public static void viewCalls(CallLog callLog) {
		System.out.println();
		System.out.print(callLog.toString());
	}
}
