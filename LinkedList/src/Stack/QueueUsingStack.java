package Stack;

/**
 * Created by Vikaasa on 2/27/2016.
 */
public class QueueUsingStack {
    Stack QPop=new Stack();
    Stack QPush=new Stack();
    public void push(int data){
        QPush.push(data);
    }
    public void shift(){
        if (QPop.getTop()==null){
            while(QPush.getTop()!=null){
                QPop.push(QPush.pop());
            }
        }
    }
    public int pop(){
        shift();
        return QPop.pop();
    }
    public int peek(){
        shift();
        return QPop.peek();
    }
    public void display(){
        Node Ptr1,Ptr2;
        Ptr1=QPush.getTop();
        Ptr2=QPop.getTop();
        while(Ptr2!=null){
            System.out.print(Ptr2.getData()+" -> ");
            Ptr2=Ptr2.getNext();
        }
        while(Ptr1!=null){
            System.out.print(Ptr1.getData()+" -> ");
            Ptr1=Ptr1.getNext();
        }
    }
}
