package LinkedList;

/**
 * Created by Vikaasa on 2/24/2016.
 */
public class LinkedListMain {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(7);
        list.insertNode(9);
        list.insertNode(9);
        list2.insertNode(2);
        list2.insertNode(4);
        list2.insertNode(5);
        list2.insertNode(6);
        list2.insertNode(8);
        //list.insertNode(5);
        //list.calldisplayList();
        //list.deleteNode(3);
      //  list.calldisplayList();
      //  list.removeDuplicates();
      // list.calldisplayList();
        //list.reverseList();
        //list.calldisplayList();
        list.callmergelists(list2);
        list.calldisplayList();
    }

}
