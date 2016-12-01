/**
 * Created by Ethan on 10/10/2016.
 * This is a Linked-List based implementation a Queue
 */
import java.util.*;

public class LinkedQueue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedQueue() {}
    public int size() {
        return list.size();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public void enqueue(E element) {
        list.addLast(element);
    }
    public E dequeue() {
        return list.removeFirst();
    }
    public E first() {
        return list.first();
    }
}
