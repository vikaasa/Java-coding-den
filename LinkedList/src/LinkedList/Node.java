package LinkedList;

/**
 * Created by Vikaasa on 2/24/2016.
 */
public class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data=data;
    }
    public void setData(int data){
        this.data=data;
    }

    public Node() {
        this.data = 0;
        this.next = null;
    }

    public int getData(){
        return data;
    }
    public void setNext(Node next) {
        this.next=next;
    }
    public Node getNext(){
        return next;
    }
}