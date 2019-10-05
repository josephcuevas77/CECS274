package Phonebook;



/**
 * 
 * @author Joseph
 *
 */
public class ContactEntry {
	private String name;
	private String number;
	private String email;
	private String notes;
	
	/**
	 * 
	 */
	public ContactEntry() {
		name = "N/A";
		number = "N/A";
		email = "N/A";
		notes = "N/A";
	}
	
	/**
	 * 
	 * @param name
	 * @param number
	 * @param email
	 * @param notes
	 */
	public ContactEntry(String name, String number, String email, String notes) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.notes = notes;
	}
	
	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * 
	 * @param newNumber
	 */
	public void setNumber(String newNumber) {
		this.number = newNumber;
	}
	/**
	 * 
	 * @param newEmail
	 */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	/**
	 * 
	 * @param newNotes
	 */
	public void setNotes(String newNotes) {
		this.notes = newNotes;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return "Name: " + this.name + "\nNumber: " + this.number + "\nE-mail: " + this.email + "\nNotes: " + this.notes; 
	}
	
}
