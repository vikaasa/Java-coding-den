package Stack;

/**
 * Created by Vikaasa on 2/27/2016.
 */
public class Node {
    Node next;
    int data;
    int min;

    public Node() {
        this.next = null;
        this.data = 0;
        this.min=Integer.MAX_VALUE;
    }
    public Node(int data){
        this.data=data;
        this.next=null;
        this.min=Integer.MAX_VALUE;
    }
    public int getData(){
        return this.data;
    }
    public void setData(int data){
        this.data=data;
    }
    public Node getNext(){ return this.next;  }
    public void setNext(Node next) {
        this.next=next;
    }
    public int getMin(){
        return this.min;
    }
    public void setMin(int min){
        this.min=min;
    }
}
