public class List2 {

    public static void main(String[] args) {
        // create a new "blank" list
        DoublyLinkedList l1 = new DoublyLinkedList();
        // now create some items (Integer objects)
        Integer i1 = 74;
        Integer i2 = -5;
        Integer i3 = 28;
        //  add them to the list
        l1.addFirst(new Node(i1, null, null));
        l1.addFirst(new Node(i2, null, null));
        l1.addFirst(new Node(i3, null, null));
        l1.add(52);
        // and check they are displayed as expected
        l1.displayContents();
        System.out.println(l1.contains(new Node(52, null, null)));
        l1.displayContents();
        l1.remove(2);
        l1.displayContents();
        l1.reverse();
        l1.addAt(2, 20);
    }
}
