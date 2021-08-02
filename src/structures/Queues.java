package structures;

import javax.xml.soap.Node;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queues {

    private NodeList front;
    private NodeList rear;
    private int size;

    private class NodeList{
        private int data;
        private NodeList next;

        public NodeList(int data){
            this.data = data;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Queues(){
        this.front = null;
        this.rear =  null;
    }

    public void enQueue(int data){
        NodeList node = new NodeList(data);
        if(isEmpty())
            front = node;
        else
            rear.next = node;
        rear = node;
        size++;
    }

    public int deQueue(){
        if(isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int result= front.data;
        front = front.next;
        if(front==null)
            rear=null;
        size--;
        return result;
    }

    public int front(){
        if(isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return front.data;
    }

    public int rear(){
        if(isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return rear.data;
    }

    public void queuePrint(){
        if(isEmpty())
            return;
        NodeList current = front;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[]args){
        Queues queue = new Queues();

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.queuePrint();
        System.out.println(queue.front());
        System.out.println(queue.rear());

        queue.deQueue();
        System.out.println(queue.front());
        queue.queuePrint();

    }
}
