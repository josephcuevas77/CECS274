package Exam2;

import java.util.NoSuchElementException;

public class GenericQueue <T> {

	private Node head; private Node tail;

	public GenericQueue() { 
		this.head = null; this.tail = null; 
	}

	public void add(T data) {
		Node newNode = new Node();
		newNode.data = data;
		if(tail == null) { head = newNode;}
		else { tail.next = newNode; }
		tail = newNode;
	}

	public T remove() {
		if(head == null) { throw new NoSuchElementException(); }
		T temp = head.data;
		head = head.next;
		return temp;
	}

	public T peek() {
		if(head == null) { throw new NoSuchElementException();}
		return head.data;
	}


	public boolean isEmpty() { return head == null;  }
	
	class Node{
		T data;
		Node next;
	}
}
