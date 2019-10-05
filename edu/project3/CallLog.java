package edu.project3;

import java.util.ArrayList;
 
/**
 * 
 * @author Joseph
 *
 */
public class CallLog {

	/**
	 * Creates new Array list to store calls
	 */
	private ArrayList<Contact> calls = new ArrayList<Contact>(); 
	
	/**
	 * Creates public function to create new array list for contacts when called
	 */
	public CallLog() {
		calls = new ArrayList<Contact>();
	}
	/**
	 * Creates public class to "log" a call in call log
	 * @param c - Will store call in the calls array list and they are added
	 */
	public void logCall(Contact c) {
		calls.add(c);
	}
	/**
	 * Sets up function to edit the call log at a certain index with new info
	 * @param index - number of index of call
	 * @param c - new contact to replace it (Date)
	 */
	public void editLog(int index, Contact c) {
		calls.set(index, c);
	}

	/**
	 * Fetches contact from a certain index
	 * @param index - number of index in which fetching
	 * @return - returns contact in which was fetched
	 */
	public Contact getContactAtIndex(int index) {
		Contact c = calls.get(index);
		return c;
	}

	/**
	 * Tracks the number of calls
	 * @return - the number of calls
	 */
	public int getSize() {
		return calls.size();
	}

	/**
	 * When printed, the string id edited in this format
	 */
	public String toString() {
		String info = "";
		for (Contact i: calls) {
			info += i.calledInfo() + "\n";
		}
		return info;
	}

}
