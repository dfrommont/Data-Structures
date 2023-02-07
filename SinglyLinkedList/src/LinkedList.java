import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(Node node) {
        node.setNext(head);
        head = node;
        ++size;
    }

    public Node removeFirst() {
        Node first = head;
        // report error if list empty
        if (head == null) {
            throw new NoSuchElementException();
        }
        // otherwise remove the item
        else {
            Node temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
        }
        return first;
    }

    public void displayContents() {
        // node current will point to head
        Node current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Printing all nodes of the current singly linked list: ");
        while(current != null) {
            // prints each node by traversing the list link by link
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public void add(Object item) {
        addFirst(new Node(item, null));
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
            current.setNext(null);
        }
    }

    public boolean contains(Node item) {
        Node current = head;

        if(head == null) {
            return false;
        }
        while(current != null) {
            // prints each node by traversing the list link by link
            if (current.getData() == item.getData()) {
                return true;
            }
            current = current.getNext();
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
            current.setNext(new Node(item, current.getNext()));
        }
    }

    public LinkedList reverse() {
        ArrayList<Object> buffer = new ArrayList<>();
        Node current = head;
        while (current != null) {
            buffer.add(current.getData());
            current = current.getNext();
        }
        System.out.println(buffer);
        Collections.reverse(buffer);
        System.out.println(buffer);
        LinkedList l2 = new LinkedList();
        Node tail = new Node(buffer.get(1), null);
        for (Object item : buffer) {
            Node temp = new Node(item, tail);
            l2.addFirst(temp);
        }
        return l2;
    }
}
