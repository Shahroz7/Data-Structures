package structures;

import javax.xml.soap.Node;
import java.util.NoSuchElementException;

public class CircularLinkedList {

    private NodeList last;
    int size;

    public CircularLinkedList() {
        this.last = null;
        this.size = 0;
    }

    private class NodeList {
        private int data;
        private NodeList next;

        public NodeList(int data) {
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void createCircularLinkedList() {
        NodeList first = new NodeList(1);
        NodeList second = new NodeList(2);
        NodeList third = new NodeList(3);
        NodeList fourth = new NodeList(4);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        last = fourth;
    }

    public void addToFront(int data) {
        NodeList node = new NodeList(data);
        if (last == null)
            last = node;
        else
            node.next = last.next;
        last.next = node;
        size++;
    }

    public void displayLinkedList() {
        if (last == null)
            return;
        NodeList first = last.next;
        while (first != last) {
            System.out.print(first.data + "-->");
            first = first.next;
        }
        System.out.print(first.data);
    }

    public void addToBack(int data) {
        NodeList node = new NodeList(data);
        if (last == null) {
            last = node;
            last.next = last;
        } else {
            node.next = last.next;
            last.next = node;
            last = node;
        }
        size++;
    }

    public NodeList removeFromFront() {
        if (isEmpty())
            throw new NoSuchElementException();
        NodeList temp = last.next;
        if (last.next == last)
            last = null;
        else
            last.next = temp.next;
        temp.next = null;
        size--;
        return temp;
    }

    public NodeList removeFromEnd() {
        if (isEmpty())
            throw new NoSuchElementException();
        NodeList temp = last.next;
        NodeList temp2 = last.next;
        if (last == last.next)
            last = null;
        else {
            while (temp.next != last) {
                temp = temp.next;
            }
            last = temp;
            temp.next = temp2;
        }

        size--;
        return temp;
    }

    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();
        //cll.createCircularLinkedList();

//        cll.addToFront(3);
//        cll.addToFront(4);
        cll.addToBack(5);
        cll.addToBack(6);
        cll.addToBack(7);
        cll.displayLinkedList();
        System.out.println(" ");
        cll.removeFromEnd();
        cll.displayLinkedList();
        System.out.println(" ");
        cll.removeFromEnd();
        cll.displayLinkedList();
        System.out.println(" ");
        cll.removeFromEnd();
        cll.displayLinkedList();
        System.out.println(" ");
//        cll.removeFromEnd();
//        cll.displayLinkedList();
//        System.out.println(" ");

//        cll.removeFromFront();
//        cll.displayLinkedList();
//        cll.removeFromFront();
//        cll.displayLinkedList();
//        System.out.println(" ");
//        cll.removeFromFront();
//        cll.displayLinkedList();


    }
}
