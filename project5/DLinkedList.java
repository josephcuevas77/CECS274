package project5;

import java.util.NoSuchElementException;

public class DLinkedList {

	private Node first;
	private Node last;

	/**
	 * Creates empty linked list
	 */
	public DLinkedList(){ first = null;}
	
	/**
	 * Adds a value/data to the first spot in the linked list
	 * @param element the number or value to be stored in the first spot in the linked list
	 */
	public void addFirst(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		if(first == null) {
			first = last = newNode;
		}
		else {
			newNode.next = first;
			first.previous = newNode;
			first = newNode;
		}
	}
	
	/**
	 * adds a value to the last spot of the list 
	 * @param element - the value that is going to be inputted into the last position
	 */
	public void addLast(Object element) {
		Node newNode = new Node();
		newNode.previous = last;
		last.next = newNode;
		newNode.data = element;
		newNode.next = null;
		if(first == null) {
			addFirst(element);
			last = first;
		}
		else {
			last.next = newNode;
			last = newNode;
		}
	}

	/**
	 * throws exception if first element/Node does not exist and returns the first element if there are elements
	 * @return the data being the stored in the first 
	 */
	public Object getFirst() {
		if(first == null) {throw new NoSuchElementException();}
		return first.data;
	}
	
	/**
	 * Retrieves the last element in the list and returns its value unless there is not one then it throws an exception
	 * @return the data of the last element
	 */
	public Object getLast() {

		if(first == null) {throw new NoSuchElementException();}
		return last.data;
	}

	/**
	 * removes the first element in the linked list and throws an exception if no element is found to be there
	 * @return the data that was stored in the removed node to keep it as a temp
	 */
	public Object removeFirst() {
		if(first == null) {throw new NoSuchElementException();}
		Object element = first.data;
		first = first.next;
		return element;
	}

	/**
	 * Removes the last element in the list and stores its value as a temp value unless there is not one then it throws an exception
	 * @return the data stored within that element temporarily
	 */
	public Object removeLast() {
		if(first == null) {throw new NoSuchElementException();}
		Object element = last.data;
		last = last.previous;
		last.next = null;
		return element;
	}
	
	/**
	 * Creates a new Iterator that will iterate through the list
	 * @return the newly created iterator
	 */
	public ListIterator listIterator() {
		return new LinkedListIterator();
		}

	/**
	 * Checks to see if the linked list contains the value inputted in the parameters
	 * @param data - The value that is going to be searched for in the linked list
	 * @return the boolean true or false whether or not the value is contained in the list
	 */
	public boolean contains(Object data) {
		ListIterator iter = new LinkedListIterator();

		while(iter.hasNext()) {
			if(iter.next() == data) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Default constructor for Nodes
	 */
	class Node{
		public Object data;
		public Node next;
		public Node previous;
	}

	/**
	 * Implements our Interface into the class
	 * Creates a default constructor for the iterator and creates private Nodes and boolean statements
	 */
	class LinkedListIterator implements ListIterator{

		private Node position;
		boolean isTheEnd;
		boolean removeCalledTwice;
		int numberofCalls;

		/**
		 *  Default constructor for the iterator 
		 */
		public LinkedListIterator() {
			position = null;
			isTheEnd = false;
			removeCalledTwice = false;
			numberofCalls = 0;
		}

		/**
		 * Moves the iterator to the next position in the list
		 */
		public Object next() {
			if(!hasNext()) {throw new NoSuchElementException();}

			numberofCalls = 0;
			
			if(position == null) {position = first;}
			
			else {position = position.next;}
			
			if (position == last) {
				isTheEnd = true;
			}
			return position.data;
		}

		/**
		 * Checks to see if the iterator has a value in the next incoming spot
		 */
		public boolean hasNext() {
			if(position == null) {return first != null;}
			else {return position.next != null;}
		}
		
		/**
		 * Moves the iterator back one spot in the list that it is iterating through
		 * @return the data stored in that position
		 */
		public Object previous() {
			if(!hasPrevious()) {throw new NoSuchElementException();}

			numberofCalls = 0;

			if(isTheEnd) {
				isTheEnd = false;
				return position.data;
			}
			position = position.previous;
			return position.data;
		}

		/**
		 * Checks to see if the iterator has a value previous to it and returns a boolean value
		 * @return true or false depending whether or not it has a previous or it is empty in the list
		 */
		public boolean hasPrevious() {
			if(position == null) {return false;}
			else{return position.previous != null;}
		}

		/**
		 * Adds a value to the list wherever the iterator is present in the list
		 * @param element - the value or data to be added to that spot
		 */
		public void add(Object element) {
			if(position == null) {
				addFirst(element);
				position = first;
			}
			else {
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				newNode.previous = position;
				position.next.previous = newNode;
				position.next = newNode;
				position = newNode;
			}
		
		}

		/**
		 * Removes an element where the iterator is placed in the linked list
		 * @return the data stored in that position if it does not meet the first two possible condition
		 */
		public Object remove() {
			numberofCalls++;
			if(numberofCalls > 1)
				throw new IllegalStateException();
			if(position == null) {throw new IllegalStateException();} 
			if(position == first) {removeFirst();}
			else {position.previous.next = position.next; position.next.previous = position.previous;} 
			return position.data;
		}


		/**
		 * Replaces the value in a list where the iterator is and is set to the new value in the parameter
		 * @param element - the new value that is going to replace the old one
		 */
		public void set(Object element) {
			if(position == null) {throw new IllegalStateException();}
			position.data = element;
		}

	}

}
