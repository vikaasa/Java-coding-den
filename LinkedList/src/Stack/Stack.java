package Stack;

/**
 * Created by Vikaasa on 2/27/2016.
 */
public class Stack {
    private Node top;
    private int size = 0;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public Node getTop() {
        return top;
    }

    public void push(int data) {
        Node node = new Node();
        node.setData(data);
        if (top == null) {
            node.setMin(data);
            top = node;
            size=1;
        }
        else {
            if (data < top.getMin()) {
                node.setMin(data);
            } else
                node.setMin(top.getMin());
            node.setNext(top);
            top = node;
            size++;
        }

    }

    public int pop() {
        Node node = top;
        top = top.getNext();
        size--;
        return node.getData();
    }

    public int peek() {
        return top.getData();
    }

    public void display() {
        Node ptr = top;
        while (ptr != null) {
            System.out.print(ptr.getData() + " -> ");
            ptr = ptr.getNext();
        }
        System.out.println("Size: "+size);
    }

    public int returnMin() {
        return top.getMin();
    }

    public Stack mergeSortStack(Stack tmp) {
        Stack result;
        Stack left=new Stack();
        Stack right=new Stack();
        //System.out.print(size);
        if (tmp.size<=1){
            return tmp;
        }
        int midpoint = tmp.size/2;
        for(int i=0;i<midpoint;i++){
            left.push(tmp.pop());
        }
        //System.out.println("Left print");
        //left.display();
        while(tmp.getTop()!=null){
            right.push(tmp.pop());
            //System.out.println("right top"+right.getTop());
        }
        //System.out.println("Right print");
        //right.display();
        left=mergeSortStack(left);
        right=mergeSortStack(right);
        result=Merge(left,right);

        return result;
    }
    public Stack Merge(Stack left, Stack right){
        Stack result = new Stack();
        Stack tempHold=new Stack();
        //System.out.println("print left top" + left.getTop().getData());
        //System.out.println("print right top"+right.getTop().getData());

        while(left.size>0&&right.size>0){
            if (left.peek()<right.peek()){
                tempHold.push(left.pop());
            }
            else
                tempHold.push(right.pop());
        }
        while(left.size>0){
            tempHold.push(left.pop());
        }
        while(right.size>0){
            tempHold.push(right.pop());
        }
        while(tempHold.size>0)
            result.push(tempHold.pop());
        result.display();
        return result;
    }

    public void initsortStack(Stack stack) {
        Stack tmp = new Stack();

        tmp=mergeSortStack(stack);
        tmp.display();
    }


    /*public void sortStack(Stack tmp, Node min) {
        int x;
        Node hold=new Node();
        int max=Integer.MAX_VALUE;
        if(top==null)
            return;
        while (top!=null) {
            x = peek();
            if (x <= max) {
                hold = top;
                max = top.getData();
            }
            tmp.push(pop());
        }
        //Node tmpTop = tmp.getTop();
        while (tmp.getTop() != min){
            if (tmp.peek() == hold.getData())
                tmp.pop();
            else
                push(tmp.pop());
        }
        tmp.push(hold.getData());
        sortStack(tmp, hold);
    }
    public void initsortStack(){
        Stack tmp=new Stack();
        sortStack(tmp,null);
    }*/
}
