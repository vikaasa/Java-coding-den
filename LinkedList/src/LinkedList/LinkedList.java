
package LinkedList;
import java.util.*;
/**
 * Created by Vikaasa on 2/24/2016.
 */
public class LinkedList {
    private Node head;
    private Node last;
    private int size=0;

    public LinkedList() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }
    public void insertNode(int data){
        Node node = new Node(data);
        if (head==null){
            head = node;
            last=head;
        }
        else {
            last.setNext(node);
            last=node;
        }
    }
    public void deleteNode(int data){
        Node curr=head;
        while(curr!=null){
            if(curr.getData()==data) {
                System.out.println("deleting "+curr.getData());
                deleteNode(curr);
                System.out.println("deleted!");
            }
            curr=curr.getNext();
        }
    }
    public void deleteNode(Node node) {
        Node tmp;
        if (node == head && last==head){
            head = null;
            last = null;
            size--;
        }
        else if(node == head){
            head=head.getNext();
        }
        else if(node == last){
            last=head;
            while(last.getNext().getData()!=node.getData()){
                last=last.getNext();
            }
            last.setNext(null);
            size--;
        }
        else{
            tmp=node;
            node.setData(node.getNext().getData());
            node.setNext(tmp.getNext().getNext());
         /*   tmp=head;
            while(tmp.getNext()!=node){''
                tmp=tmp.getNext();.,
            }
            System.out.println("parent is"+tmp.getData());
            tmp.setNext(tmp.getNext().getNext());
//            node=node.getNext();
            size--;
        */}
    }
    public void displayList(Node head){
        Node curr=head;
        System.out.println("The list is: ");
        while(curr!=null){
            System.out.println(curr.getData()+" ");
            curr=curr.getNext();
        }
    }
    public void calldisplayList(){
        displayList(head);
    }
    public void removeDuplicates(){
        HashSet<Integer> unique = new HashSet<>();
        Node curr=head;
        Node parent;
        while(curr!=null){
            if(!unique.contains(curr.getData()))
                unique.add(curr.getData());
            else {
                System.out.println("Duplicate is" + curr.getData());
                deleteNode(curr);
            }
            curr=curr.getNext();
        }
    }
    public void reverseList(){
        Node prev, curr, lead;
        prev=null;
        curr=head;
        lead=head.getNext();

        while(curr!=null){
            lead=curr.getNext();
            curr.setNext(prev);
            prev=curr;
            curr=lead;
        }
        head=prev;
     //   this.calldisplayList();
    }
    public Node mergelists(Node head, Node head2){
        Node list1=head;
        Node list2=head2;

        Node mergedHead;
        Node mergedPtr;

        if (list1.getData() < list2.getData()) {
            mergedHead=list1;
            mergedPtr=mergedHead;
            list1=list1.getNext();
        }
        else{
            mergedHead=list2;
            mergedPtr=mergedHead;
            list2=list2.getNext();
        }

        head=mergedHead;
        System.out.println(head.getData());
        while(list1.getNext()!=null&&list2.getNext()!=null) {
            if (list1.getData() < list2.getData()) {
                mergedPtr.setNext(list1);
                mergedPtr=mergedPtr.getNext();
                list1=list1.getNext();
            }
            else {
                mergedPtr.setNext(list2);
                mergedPtr=mergedPtr.getNext();
                list2=list2.getNext();
            }
        }
        if(list1.getNext()==null){
            mergedPtr.setNext(list2);
        }
        if(list2.getNext()==null) {
            mergedPtr.setNext(list1);
        }
        /*while(head.getNext()!=null){
            System.out.println(head.getData());
            head=head.getNext();
            }
        */

    return head;
    }
    public void callmergelists(LinkedList tree2){
        head=mergelists(head,tree2.head);
    }
}

