public class Node {

    private Object data;
    private Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public Object getData() {
        return data;
    }
}
