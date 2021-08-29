package structures;

import java.util.NoSuchElementException;

class DoublyLinkedList {

    private NodeList head;
    private NodeList tail;
    private int size;

    //Node of a doublylinkedlist
    private class NodeList {

        private int data;
        private NodeList previous;
        private NodeList next;

        public NodeList(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isHeadEmpty() {
        return (head == null);
    }

    public boolean isTailEmpty() {
        return (tail == null);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int getSize() {
        return size;
    }

    public void displayForward() {
        if (head == null)
            return;
        NodeList current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null)
            return;
        NodeList current = tail;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.previous;
        }
        System.out.println("null");
    }

    public void addToFirst(int data) {
        NodeList node = new NodeList(data);
        if (isHeadEmpty() && isTailEmpty()) {
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;// Since head default value is null
        head = node;
        size++;
    }

    public void addToEnd(int data) {
        NodeList node = new NodeList(data);
        if (isHeadEmpty() && isTailEmpty())
            head = node;
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    public NodeList deleteFromStart() {
        if (isTailEmpty() && isHeadEmpty())
            throw new NoSuchElementException();
        NodeList temp = head;
        if (head == tail) // means  list has only one node
            tail = null;
        else
            head.next.previous = null; // to break the previous link which is coming from next node
        head = head.next;
        temp.next = null;
        size--;
        return temp;
    }

    public NodeList deleteFromEnd() {
        if (isEmpty())
            throw new NoSuchElementException();
        NodeList temp = head;
        if (head == tail)
            head = null;
        else
            tail.previous.next = null;
        temp.previous = null;
        tail = tail.previous;
        size--;
        return temp;
    }

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("Add at the start");
        dll.addToFirst(4);
        dll.addToFirst(5);
        dll.addToFirst(6);
        dll.displayForward();

//        dll.deleteFromStart();
//        dll.deleteFromStart();
//        dll.deleteFromStart();
//        dll.displayForward();
        dll.deleteFromEnd();
        dll.displayForward();
        dll.deleteFromEnd();
        dll.displayForward();
        dll.deleteFromEnd();
        dll.displayForward();
        dll.deleteFromEnd();
        dll.displayForward();


//        System.out.println("Add at the end");
//        dll.addToEnd(2);
//        dll.displayForward();
//        System.out.println(" ");
//        dll.displayBackward();
//        System.out.println(" ");
//        dll.addToEnd(3);
//        dll.displayForward();
//        System.out.println(" ");
//        dll.displayBackward();
    }
}
