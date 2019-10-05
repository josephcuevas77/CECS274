package tes;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class dLinkedList {
	private Node first;
	private Node last;
	
	public DLinkedList(){ first = null;}
	
	public Object getFirst() {
		if(first == null) {throw new NoSuchElementException();}
		return first.data;
	}
	
	public Object removeFirst() {
		if(first == null) {throw new NoSuchElementException();}
		Object element = first.data;
		first = first.next;
		return element;
	}
	
	public void addFirst(Object element) {
		Node newNode = new Node();
		newNode.data = element;
		newNode.next = first;
		first = newNode;
		if(first.next == null) {
			last = first;
		}
	}
	
	public Object getLast() {
		
		if(first == null) {throw new NoSuchElementException();}
		return last.data;
	}
		
	public Object removeLast() {
		if(first == null) {throw new NoSuchElementException();}
		Object element = last.data;
		last = last.previous;
		last.next = null;
		return element;
	}
	
	public void addLast(Object element) {
		Node newNode = new Node();
		newNode.previous = last;
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
	
	public boolean contains(Object data) {
		ListIterator iter = new LinkedListIterator();
		
		while(iter.hasNext()) {
			if(iter.next() == data) {
				return true;
			}
		}
		return false;
	}
	
	public ListIterator listIterator() {return new LinkedListIterator();}
	
	class Node{
		public Object data;
		public Node next;
		public Node previous;
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
		
		public void add(Object element) {
			if(position == null) {
				addFirst(element);
				position = first;
			}
			else {
				Node newNode = new Node();
				newNode.data = element;
				newNode.next = position.next;
				position.next = newNode;
				position = newNode;
			}
			isAfterNext = false;
		}
		
		public Object remove() {
			if(!isAfterNext) {throw new IllegalStateException();}
			if(position == first) {removeFirst();}
			else {previous.next = position.next;}
			position = previous;
			isAfterNext = false;
			isAfterPrevious = false;
			return position.data;
		}
		
		
		public void set(Object element) {
			if(!isAfterNext) {throw new IllegalStateException();}
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
