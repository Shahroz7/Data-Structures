package structures;

import java.util.EmptyStackException;

public class Stacks {

    private class NodeList{
        private int data;
        private NodeList next;

        public NodeList(int data){
            this.data=data;
        }
    }

    private NodeList top;
    private int size;

    public Stacks(){
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return  size;
    }
    public void push(int data){
        NodeList node = new NodeList(data);
        node.next=top;
        top=node;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        size--;
        return result;
    }

    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public void displayStacks(){
        NodeList temp = top;
        while(temp!=null){
            System.out.print(temp+ "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[]args){
        Stacks stacks = new Stacks();
        stacks.push(1);
        stacks.push(2);
       // stacks.displayStacks();

        System.out.println(stacks.peek());
        stacks.pop();
        System.out.println(stacks.peek());

    }

}
