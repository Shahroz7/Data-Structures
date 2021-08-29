package structures;

class LinkedList {

     NodeList head;
    int size;

    //node of singlylinkedlist
     class NodeList {

        private int data;
        private NodeList next;

        public NodeList(int data) {
            this.data = data;
        }
    }

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public LinkedList(NodeList head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addToFront(int data) {
        NodeList node = new NodeList(data);
        node.next = head;
        head = node;
        size++;
    }

    public void addToEnd(int data) {
        NodeList node = new NodeList(data);
        if (isEmpty()) {
            head = node;
            size++;
            return;
        }
        node.next = null;
        NodeList last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        size++;
    }

    public void middleNode() {
        NodeList fastNode = head;
        NodeList slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        System.out.println(slowNode.data);
    }

    public NodeList removeFromFront() {
        if (isEmpty())
            return null;
        NodeList removeNode = head;
        head = head.next;
        size--;
        removeNode.next = null;
        return removeNode;
    }

    public NodeList removeFromEnd() {
        if (isEmpty())
            return null;
        else if (head == null || head.next == null)
            return head;
        NodeList current = head;
        NodeList previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        size--;
        return current;
    }

    public void addToAnyPosition(int position, int data) {
        NodeList node = new NodeList(data);
        if (position == 1) {
//            node.next = head;
//            head=node;
//            size++;
            addToFront(data);
        } else {
            NodeList previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
            }
            NodeList current = previous.next;
            node.next = current;
            previous.next = node;
            size++;
        }
    }

    public void deleteFromAnyPosition(int position) {
        if (position == 1) {
//            head=head.next;
//            size--;
            removeFromFront();
        } else {
            NodeList previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            NodeList current = previous.next;
            previous.next = current.next;
            size--;
        }
    }

    public void display() {
        NodeList current = head;
        System.out.print("HEAD ->");
        while (current != null) {
            System.out.print(current.data);
            System.out.print("->");
            current = current.next;
        }
        System.out.print("NULL");
        System.out.println("");
    }

    public void reverse() {
        if (head == null)
            return;

        NodeList current = head;
        NodeList previous = null;
        NodeList next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public boolean find(int searchKey) {
        if (head == null)
            return false;
        NodeList current = head;
        while (current != null) {
            if (current.data == searchKey)
                return true;
            current = current.next;
        }
        return false;
    }

}


public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();


//        LinkedList.NodeList head = new LinkedList.NodeList(1);
//        LinkedList linkedlist = new LinkedList(head);

        System.out.println(list.isEmpty());
        list.addToEnd(5);
        list.addToEnd(9);
        list.addToFront(6);
//        list.addToFront(8);
        list.display();
       // list.middleNode();
        System.out.println("reverse is");

        list.reverse();
        list.display();

    }

}
