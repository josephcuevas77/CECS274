package edu.project3;

import java.util.ArrayList;
import java.util.Collections;

public class Phonebook {
	private ArrayList<Contact> contacts;

	// Constructor
	public Phonebook() {
		contacts = new ArrayList<Contact>();
	}

	/**
	 * Adds contact to phone book
	 * @param c -  contact to be added 
	 */
	public void addContact(Contact c) {
		contacts.add(c);
	}

	/**
	 * Deletes contact from phonebook
	 * @param c - contact thats deleted
	 * @param name - name of contact 
	 * @return boolean whether or not contact is found
	 */
	public boolean deleteContact(Contact c, String name) {
		for (int i=0; i<contacts.size(); i++) {
			Contact contactInfo = contacts.get(i);
			String contactName = contactInfo.getName();
			if (contactName.equals(name)) {
				contacts.remove(c);
				return true;
			}
		}
		return false;
	}

	/**
	 * retrieved contact at certain index
	 * @param index - place of contact in list
	 * @return the contact
	 */
	public Contact getContactAtIndex(int index) {
		Contact c = contacts.get(index);
		return c;
	}

	/**
	 * Retrieves contact
	 * @param name - name of contact
	 * @return contact
	 */
	public Contact getContact(String name) {
		for (Contact c: contacts) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}	

	/**
	 * Gets the contact by phone number
	 * @param number - number of contact 
	 * @return the contact if found
	 */
	public Contact getContactWithNum(String number) {
		for (Contact c: contacts) {
			if (c.getNumber().equals(number)) {
				return c;
			}
		}
		return null;
	}	

	/**
	 * Retrieves size of contacts
	 * @return size of list contacts
	 */
	public int getSize() {
		return contacts.size();
	}

	/**
	 * Replaces contact with another
	 * @param index - placement of contact
	 * @param change - contact to change
	 */
	public void replaceContact(int index, Contact change) {
		contacts.set(index, change);
	}

	/**
	 * Inserts contact in certain place in array list
	 * @param index - placement of the contact 
	 * @param insert - contact to insert
	 */
	public void insertContact(int index, Contact insert) {
		contacts.add(index, insert);
	}

	/**
	 * Displays the name of contact
	 * @return returns the names 
	 */
	public String displayName() {
		int count = 0;
		String names = "";
		for (Contact c: contacts) {
			count++;
			names += (count + ". " + c.getName() + "\n");
		}
		return names;
	}

	/**
	 * sort contact list by name
	 */
	public void sortContacts() {
		Collections.sort(contacts, (a, b) -> a.getName().compareTo(b.getName()));
	}

	/**
	 * Convert phonebook memory to String
	 */
	public String toString() {
		String info = "";
		for (Contact c: contacts) {
			info += c.toString() + "\n";
		}
		return info;
	}
}
