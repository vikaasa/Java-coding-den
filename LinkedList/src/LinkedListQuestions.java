/**
 * Created by Vikaasa on 26/02/2017.
 */
public class LinkedListQuestions extends LinkedList{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //Insert Check
        list.insertList( 11 , 1 );
        list.printList();
        list.insertList( 22 , 2 );
        list.printList();
        list.insertList( 44 , 3 );
        list.printList();
        list.insertList( 33 , 3 );
        list.insertList( 55 , 5 );
        list.insertList( 66 );
        list.insertList( 77 );
        list.printList();

        //Delete Check
        list.deleteList( 77 );
        list.deleteList( 33 );
        list.deleteList( 11 );
        list.printList();

        //Search Check
        Node searchNode;
        searchNode = list.searchList( 44 );

        //Reverse Check
        head = list.reverseList();
        list.printList();

        // Cycle Check
        // Initializing List with Cycle
        head = new Node( 11 );
        head.next = new Node( 22 );
        head.next.next = new Node( 33 );
        Node temp = head.next.next.next = new Node( 44 );
        head.next.next.next.next = new Node( 55 );
        head.next.next.next.next.next = temp;
        boolean check;
        check = list.checkIfCycleExists(head);
        System.out.println( check );

        // Find Intersecting Point
        // Initializing 'Y' List

    }
}
