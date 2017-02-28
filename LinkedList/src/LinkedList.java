/**
 * Created by Vikaasa on 26/02/2017.
 */


public class LinkedList {
    /**
     * @param args
     */

	/*Linked List
	1. Insert
	2. Delete
	3. Search
	4. Reverse
	5. Print
	*/

    static Node head;

    public Node insertList( int data ){
        Node newNode = new Node( data ), temp = head;
        if (head == null){
            head = new Node(data);
            return head;
        }
        while(temp.next!=null) {
            temp = temp.next;
        }
        newNode.next = null;
        temp.next = newNode;
        return head;
    }
    public boolean insertList( int data, int pos )
    {
        if( pos == 1 )
        {
            Node newNode = new Node( data );
            newNode.next = head;
            head = newNode;
        }
        else
        {
            Node newNode, temp = head;
            for( int i = 1; i < pos - 1; i++ )
            {
                if( temp.next == null )
                    return false;
                temp = temp.next;
            }
            newNode = new Node( data );
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return true;
    }

    public void deleteList( int data )
    {
        if( head == null )
        {
            System.out.println("Linked List Empty!! Can't Delete!!");
            return;
        }
        if( head.data == data )
        {
            head = head.next;
            return;
        }
        Node temp;
        for( temp = head; temp.next != null; temp = temp.next )
        {
            if( temp.next.data == data )
            {
                temp.next = temp.next.next;
                return;
            }
        }
        System.out.println("Element Not Found!!");
    }

    public Node searchList( int data )
    {
        if( head == null )
        {
            System.out.println("List Empty!!");
            return null;
        }
        Node temp;
        int i;
        for( temp = head, i = 1; temp != null; temp = temp.next, i++ )
        {
            if( temp.data == data )
            {
                System.out.println("Element " + data + " Found at Position: " + i );
                return temp;
            }
        }
        System.out.println("Element Not Found!!");
        return null;
    }

    public Node reverseList( )
    {
        Node prev = null, next = null;
        Node curr = head;
        while( curr != null )
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public boolean checkIfCycleExists( Node head )
    {
        try {
            Node slow = head;
            Node fast = head.next;
            while(slow != fast)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }
    }

    public void printList()
    {
        Node temp;
        for( temp = head; temp.next != null; temp = temp.next )
            System.out.print( temp.data + " " );
        System.out.println( temp.data );
    }
}