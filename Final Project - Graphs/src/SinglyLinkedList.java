/**
 * Created by Ethan on 10/10/2016.
 * This is a Singly Linked-List implementation for a Queue base
 */

public class SinglyLinkedList<E> {
	
	//nested Node class
	private static class Node<E> {
		
		//declares members
		private E element;
		private Node<E> next;
		
		//creates overloaded constructor
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		//creates getter and setter methods
		public E getElement() {
			return element;
		}
		
		public Node<E> getNext() {
			return next;
		}
		
		public void setNext(Node<E> n) {
			next = n; 
		}
	}
	
	//declares members
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	//access methods
	public int size() {
		return size; 
	}
	
	public boolean isEmpty() { 
		if (size == 0 || head == null)
			return true;
		return false;
	}
	
	public E first() {
		if (isEmpty())
			return null;
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty())
			return null;
		return head.getElement();
	}
	
	//update methods
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size ++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size ++;
	}
	
	public E removeFirst() {
		if (isEmpty())
			return null;
		E answer = head.getElement();
		head = head.getNext();
		size --;
		if (size == 0)
			tail = null;
		return answer;
	}
	
}

