package edu.project3;

/**
 * 
 * @author Tristan
 *
 */
public class Contact {
	private String name;
	private String number;
	private String email;
	private String notes;
	private String date;

	/**
	 * Default Constructor
	 * Sets each param to a default
	 */
	public Contact() {
		name = "N/A";
		number = "N/A";
		email = "N/A";
		notes = "N/A";	
	}

	/**
	 * Overloaded Contstructor
	 * @param name - name of the contact
	 * @param number - number of the contact
	 * @param email - email of the contact
	 * @param notes - notes for the email
	 */
	public Contact(String name, String number, String email, String notes) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.notes = notes;	
	}

	/**
	 * Sets up the contact info
	 * @param name - name of the contact
	 * @param number - number of contact
	 * @param date - date called
	 */
	public Contact(String name, String number, String date) {
		this.name = name;
		this.number = number;
		this.date = date;
	}	
	/**
	 * Sets name to a contact
	 * @param name - name of contact
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Fetches the name and returns it 
	 * @return name - name of the contact
	 */
	public String getName() {return name;}

	/**
	 * Sets the number of the contact 
	 * @param number - number of contact
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Fetches the number of a certain contact
	 * @return number - gets number from certain contact 
	 */
	public String getNumber() {return number;}

	/**
	 * Sets email for the contact
	 * @param email - email for the contact
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Fetches email for the contact
	 * @return email - email for contact
	 */
	public String getEmail() {return email;}

	/**
	 * Sets notes to the contact 
	 * @param notes - notes of contact
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Fetches the notes from contact
	 * @return notes - notes of the contact
	 */
	public String getNotes() {return notes;}

	/**
	 * Sets the date for the contact/call
	 * @param date - date of call
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * Fetches the date from a contact/call
	 * @return the date fetched
	 */
	public String getDate() {return date;}

	/**
	 * Convert contact memory to string
	 */
	public String toString() {
		String info = String.format("Contact Info: %nName: %s %nNumber: %s %nEmail: %s %nNotes: %s%n", name, number, email, notes);
		return info;
	}
	/**
	 * Creates function for call log info
	 * @return the info retrieved
	 */
	public String calledInfo() {
		String info = String.format("–Call Log– %nName: %s %nNumber: %s %n%s%n", name, number, date);
		return info;
	}

}
