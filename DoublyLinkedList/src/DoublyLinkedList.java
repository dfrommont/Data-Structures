import java.util.ArrayList;
import java.util.Collections;

public class DoublyLinkedList {

    private Node head;
    private Node prev;
    private int size;

    public DoublyLinkedList() {
        head = null;
        prev = null;
        size = 0;
    }

    public void addFirst(Node node) {
        head = node;
        head.setPrev(null);
        node.setNext(head);
        ++size;
    }

    public Node removeFirst() {
        Node first = head;
        // report error if list empty
        if (head != null) {
            Node temp = head;
            head.setPrev(null);
            head = head.getNext();
            temp.setNext(null);
            size--;
        }
        return first;
    }

    public void displayContents() {
        System.out.println("Displaying contents of Doubly Linked List");
        Node current = head;
        int count = size;
        while (count > 0) {
            System.out.println(current.getData());
            current = current.getNext();
            count--;
        }
    }

    public void add(Object item) {
        addFirst(new Node(item, null, null));
    }

    public void remove(int i) {
        if (i >= size || i < 1) {
            System.out.println("Index out of bounds.");
        } else if (i == 1) {
            removeFirst();
        } else {
            i -= 2;
            Node previous = head;
            Node current = head.getNext();
            while (i > 2) {
                current = current.getNext();
                previous = current;
                i--;
            }
            previous.setNext(current.getNext());
            previous.setPrev(current.getPrev());
            current.setNext(null);
            current.setPrev(null);
        }
    }

    public boolean contains(Node item) {
        Node current = head;
        if (head != null) {
            while (current.getNext() != null) {
                if (current.getData() == item.getData()) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    public void addAt(int i, Object item) {
        if (i < 1 || i >= size) {
            System.out.println("Index out of bounds.");
        } else {
            i--;
            Node current = head;
            while (i > 1) {
                current = head.getNext();
                i--;
            }
            current.setNext(new Node(item, current.getNext(), current));
            current.getNext().setPrev(current.getNext());
        }
    }

    public DoublyLinkedList reverse() {
        ArrayList<Object> buffer = new ArrayList<>();
        Node current = head;
        while (current != null) {
            buffer.add(current.getData());
            current = current.getNext();
        }
        System.out.println(buffer);
        Collections.reverse(buffer);
        System.out.println(buffer);
        DoublyLinkedList l2 = new DoublyLinkedList();
        Node tail = new Node(buffer.get(1), null, null);
        for (Object item : buffer) {
            Node temp = new Node(item, tail, null);
            l2.addFirst(temp);
        }
        return l2;
    }
}