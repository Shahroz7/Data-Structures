package nodes;

public class NodeList {

    private int data;
    private NodeList next;

    public NodeList(int data){
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeList getNext() {
        return next;
    }

    public void setNext(NodeList next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeList{" +
                "data=" + data +
                '}';
    }
}
