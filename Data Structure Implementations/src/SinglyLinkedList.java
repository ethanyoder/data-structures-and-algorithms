/**
 * Created by Ethan on 9/24/2016.
 */
public class SinglyLinkedList<E> {

    //declares members
    private Node<E> head;
    private Node<E> tail;
    private int size;

    //default constructor
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //checks is list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //adds element to beginning of list
    public void addFirst(Node<E> e) {
        if (head == null) {
            head = e;
            tail = e;
        }
        else {
            Node<E> temp = head;
            head = e;
            e.setNext(temp);
        }
    }

    //generates getters for head, tail, and size
    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    private class Node<E> {

        //declares members
        private E next;

        //default constructor
        public Node() {
            next = null;
        }

        //getter and setter for next
        public E getNext() {
            return next;
        }

        public void setNext(E next) {
            this.next = next;
        }
    }
}
