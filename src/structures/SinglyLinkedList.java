package structures;

import nodes.NodeList;

class LinkedList {

    private NodeList head;
    private int size;

    public boolean isEmpty(){
        return (head==null);
    }

    public int getSize() {
        return size;
    }

    public void addToFront(int data) {
        NodeList node=new NodeList(data);
        node.setNext(head);
        head=node;
        size ++;
    }

    public void addToEnd(int data) {
        NodeList node=new NodeList(data);
        if(head==null){
            head= node;
            size++;
            return;
        }
        node.setNext(null);
        NodeList last=head;
        while(last.getNext()!=null){
            last=last.getNext();
        }
        last.setNext(node);
        size ++;
    }

    public void addToAnyPosition(int position, int data) {
        NodeList node=new NodeList(data);
        if(position==1){
//            node.setNext(head);
//            head=node;
//            size++;
            addToFront(data);
        }
        else{
            NodeList previous= head;
            int count = 1;
            while(count< position-1){
                previous= previous.getNext();
            }
            NodeList current= previous.getNext();
            node.setNext(current);
            previous.setNext(node);
            size++;
        }
    }

    public void deleteFromAnyPosition(int position){
        if(position==1){
//            head=head.getNext();
//            size--;
            removeFromFront();
        }
        else{
            NodeList previous= head;
            int count = 1;
            while(count < position-1){
                previous= previous.getNext();
                count++;
            }
            NodeList current=previous.getNext();
            previous.setNext(current.getNext());
            size--;
        }
    }

    public NodeList removeFromEnd(){
        if(isEmpty()){
            return null;
        }
        else if(head==null || head.getNext()==null){
            return head;
        }
        NodeList current=head;
        NodeList previous=null;
        while(current.getNext()!=null){
            previous=current;
            current=current.getNext();
        }
        previous.setNext(null);
        size--;
        return current;
    }

    public NodeList removeFromFront(){
        if(isEmpty()){
            return null;
        }
        NodeList removeNode= head;
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public boolean find(int searchKey){
        if(head==null)
          return false;
        NodeList current = head;
        while(current!=null){
            if(current.getData()==searchKey)
                return true;
            current = current.getNext();
        }
       return false;
    }

    public NodeList reverse(){
        if(head==null)
            return head;

        NodeList current = head;
        NodeList previous = null;
        NodeList next;
        while(current != null){
            next = current.getNext();
            current.setNext(previous);
            previous=current;
            current=next;
        }
        return previous;
    }

    public NodeList middleNode(){
        NodeList fastNode = head;
        NodeList slowNode = head;
        while(fastNode != null && fastNode.getNext()!=null){
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
        }
    return slowNode;
    }

    public void printList(){
        NodeList current= head;
        System.out.print("HEAD ->");
        while(current!=null){
            System.out.print(current);
            System.out.print("->");
            current = current.getNext();
        }
        System.out.print("NULL");
        System.out.println("");
    }
}

public class SinglyLinkedList{
    public static void main(String[]args){
        LinkedList list= new LinkedList();

        System.out.println(list.isEmpty());

//        list.addToFront(1);
//        list.addToFront(2);
//        list.addToFront(3);
        list.printList();

//        list.removeFromFront();
//        System.out.println(list.getSize());
//        list.printList();

        list.addToEnd(5);
        list.addToEnd(6);
        list.addToEnd(7);
        list.addToEnd(8);
        list.printList();
        System.out.println(list.getSize());

        list.middleNode();
        System.out.println(list.middleNode().getData());
//        list.reverse();
//        System.out.println(list.reverse());
//        list.printList();

//        list.addToFront(4);
//        list.printList();
//        System.out.println(list.getSize());

//        if(list.find(9))
//            System.out.println("Search Key  found");
//        else
//            System.out.println("Search failed");

//        list.removeFromEnd();
//        list.printList();
//        System.out.println(list.getSize());

//        System.out.println("delete from any position");
//        list.deleteFromAnyPosition(1);
//        list.printList();
//        System.out.println(list.getSize());
//        list.addToAnyPosition(2,8);
//        list.printList();
//        System.out.println(list.getSize());
//        list.addToAnyPosition(1,9);
//        list.printList();
//        System.out.println(list.getSize());
//        System.out.println("delete from any position");
//        list.deleteFromAnyPosition(1);
//        list.printList();
//        System.out.println(list.getSize());
//        System.out.println("delete from any position");
//        list.deleteFromAnyPosition(3);
//        list.printList();
//        System.out.println(list.getSize());
    }

}