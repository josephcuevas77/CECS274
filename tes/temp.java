package tes;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class temp {

	private Node first;
	private Node last;

	class Node { 
		public int data; 
		public Node prev; 
		public Node next; 
	} 

	public void dLinkedList() {
		first = null;
	}

	public void addFirst(int x) {
		Node newNode = new Node();
		newNode.data = x;
		newNode.next = first;
		first = newNode;
		if(first.next == null) {
			last = first;
		}

	}

	public void addLast(int x) 
	{ 
		Node newNode = new Node();
		newNode.data = x;
		newNode.next = null;
		if(first == null) {
			addFirst(x);
			last = first;
		}
		else {
			last.next = newNode;
			last = newNode;
		}

	} 

	public Object getFirst() {
		if(first == null) { throw new NoSuchElementException();}
		return first.data;
	}

	public Object getLast() {
		if(last == null) { throw new NoSuchElementException();}
		return last.data;
	}

	public Object removeFirst() {
		if(first == null) { throw new NoSuchElementException();}
		int temp = first.data;
		first = first.next;
		return temp;
	}

	public Object removeLast() {
		if(first == null) {throw new NoSuchElementException();}
		Object element = last.data;
		last = last.previous;
		last.next = null;
		return element;
	}

	public ListIterator listIterator() {
		return new LinkedListIterator();
	}

	class LinkedListIterator implements ListIterator{

		private Node position;
		private Node next;
		private Node previous;
		private boolean isAfterNext;
		private boolean isAfterPrevious;

		public LinkedListIterator() {
			position = null;
			next = null;
			previous = null;
			isAfterNext = false;
			isAfterPrevious = false;
		}

		public boolean contains(Object data){ 
			ListIterator iterate = new LinkedListIterator();
			while(iterate.hasNext()) {
				if(iterate.next() == data) {
					return true;
				}
			}
			return false;
		}
	}
	public Object next() {
		if(!hasNext()) {throw new NoSuchElementException();}

		previous = position;

		if(position == null) {position = first;}

		else {position = position.next;}

		isAfterNext = true;
		return position.data;
	}

	public boolean hasNext() {
		if(position == null) {return first != null;}
		else {return position.next != null;}
	}
	position.data = element;
}

public Object previous() {
	if(!hasPrevious()) {throw new NoSuchElementException();}

	next = position;

	if(position == null) {position = last;}
	else {position = position.previous;}

	isAfterPrevious = true;
	return position.data;
}

public boolean hasPrevious() {
	if(position == null) {return false;}
	else{return position.previous != null;}
}

}

}
