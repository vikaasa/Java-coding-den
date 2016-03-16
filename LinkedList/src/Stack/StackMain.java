package Stack;

/**
 * Created by Vikaasa on 2/27/2016.
 */
public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(1);

        //stack.push(2);
        //stack.pop();
        //stack.peek();
        stack.display();
        stack.initsortStack(stack);
        //int min=stack.returnMin();
        //System.out.println(min);
/*        QueueUsingStack qus = new QueueUsingStack();
        qus.push(3);
        qus.push(6);
        qus.push(8);
        qus.push(7);
        qus.peek();
        //qus.display();
        qus.pop();
        //qus.display();
        qus.pop();
        qus.display();*/
//        stack.initsortStack();
    }
}