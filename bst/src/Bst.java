/**
 * Created by Vikaasa on 2/22/2016.
 */
import java.lang.reflect.Array;
import java.util.*;

public class Bst {

    private Node root;

    public void insert(int data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
            return;
        }
        Node cur = root;
        Node pre = root;
        while (cur != null) {
            pre = cur;
            if (node.getData() < cur.getData()) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }
        if (node.getData() < pre.getData()) {
            pre.setLeft(node);
        } else {
            pre.setRight(node);
        }

    }

    public Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), data));
        } else {
            root.setRight(insertRec(root.getRight(), data));
        }

        return root;

    }

    public void recInsert(int data) {
        this.root = insertRec(root, data);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getData() + "->");
        inOrder(root.getRight());
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + "->");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getData() + "->");
    }

    public void traversal(String path) {
        if (root != null) {
            if (path.equals(new String("postOrder"))) {
                postOrder(root);
            } else if (path.equals(new String("preOrder"))) {
                preOrder(root);
            } else {
                inOrder(root);
            }
        }
    }

    public void paths(Node root, ArrayList<StringBuilder> pathlist, StringBuilder str) {
        if (root == null) {
            return;
        }

        StringBuilder st = new StringBuilder();
        st.append(str);
        st.append(root.getData());

        System.out.print(root.getData() + " ");

        if (root.getLeft() == null && root.getRight() == null) {
            pathlist.add(st);
            //System.out.println(curr.toString()+" leaf node: return");
            return;
        }
        st.append(' ');
        paths(root.getLeft(), pathlist, st);
        paths(root.getRight(), pathlist, st);
    }

    public void allpaths() {
        StringBuilder st = new StringBuilder();
        //st.append(" ");
        ArrayList<StringBuilder> pathlist = new ArrayList<StringBuilder>();
        paths(root, pathlist, st);
        System.out.println(pathlist);
    }

    public void callcheckbst() {
        if (checkbst(root) == true)
            System.out.println(0);
        else
            System.out.println(1);
    }

    public boolean checkbst(Node root) {
        return checkbst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkbst(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.getData() < min || root.getData() > max) {
            return false;
        }
        if (!checkbst(root.getLeft(), min, root.getData()) || !checkbst(root.getRight(), root.getData(), max)) {
            return false;
        }
        return true;
    }

    public void callcheckbstinorder() {
        //int prevtmp=Integer.MIN_VALUE;
        if (checkbstinorder(root) == true)
            System.out.println("it is a BST");
        else
            System.out.println("it is not a BST");
    }

    public boolean checkbstinorder(Node root) {
        if (root == null) {
            return true;
        }
        checkbstinorder(root.getLeft());
        if ((root.getLeft() != null) && (root.getData() <= root.getLeft().getData()))
            return false;
        checkbstinorder(root.getRight());
        return true;
    }

    public int checkheight(Node root, int level) {
        if (root == null) return level;

        int hleft = checkheight(root.getLeft(), level + 1);

        int hright = checkheight(root.getRight(), level + 1);

        int diff = Math.abs(hleft - hright);

        if (diff > 1)
            return -1;
        else return Math.max(hleft, hright);

    }

    public void checkHeight() {
        int level = -1;
        int h = checkheight(root, level);
        if (h == -1)
            System.out.println("Not BST: Height:" + h);
        else System.out.println("BST: Height:" + h);
    }
    public int returnHeight(){
        int level=-1;
        return checkheight(root,level);
    }
    public boolean search(Node root, int x) {
        if (root == null) {
            System.out.println("not found");
            return false;
        }
        if (root.getData() == x) {
            //System.out.println("\n"+x+"is found!\n");
            System.out.println(root.getData());
            return true;
        } else if (x < root.getData()) {
            System.out.println(root.getData());
            search(root.getLeft(), x);
        } else if (x > root.getData()) {
            System.out.println(root.getData());
            search(root.getRight(), x);
        }
        return false;
    }

    public void callsearch(int ele) {
        search(root, ele);
    }

    public void levellinkedlist(Node root, ArrayList<LinkedList<Integer>> arrlist, int level) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> list = null;
        if (level == arrlist.size()) {
            list = new LinkedList<Integer>();
            arrlist.add(list);
        } else {
            list = arrlist.get(level);
        }
        list.add(root.getData());
        levellinkedlist(root.getLeft(), arrlist, level + 1);
        levellinkedlist(root.getRight(), arrlist, level + 1);
    }

    public void calllevellinkedlist() {
        ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
        int lvl = 0;
        levellinkedlist(root, lists, lvl);
        System.out.println(lists);
    }

    public boolean compare(Node root1, Node root2) {
        if ((root1 == null) && (root2 == null)) {
            return true;
        } else if ((root1 != null && root2 != null) && (root1.getData() == root2.getData())) {
            return (compare(root1.getLeft(), root2.getLeft()) && (compare(root1.getRight(), root2.getRight())));
        } else {
            return false;
        }
    }
    public void callcompare(Bst tree2) {
        boolean x= compare(root, tree2.root);
        System.out.println(x);
    }
    public boolean pathsum(Node root, int sum, int psum){
        if(root==null)
            return false;

        sum = sum+root.getData();

        if(root.getLeft()==null&&root.getRight()==null) {
            if (sum == psum)
                return true;
        }
        else
            return pathsum(root.getLeft(),sum,psum)||pathsum(root.getRight(),sum,psum);

        return false;
    }
    public void callpathsum(int psum) {
        int sum = 0;
        boolean x = pathsum(root, sum, psum);
        System.out.println(x);
    }
    public ArrayList<Integer> lvlzigzag(Node root, ArrayList<Integer> list, int level, boolean flip) {
        if (root == null) {
            return null;
        }
        //ArrayList<Integer> list = new ArrayList<>();
        if (level==1){
            System.out.println(root.getData());
            list.add(root.getData());
        }
        else {
            if (flip == true) {
                lvlzigzag(root.getLeft(), list, level - 1, flip);
                lvlzigzag(root.getRight(), list, level - 1, flip);
            } else {
                lvlzigzag(root.getRight(), list, level - 1, flip);
                lvlzigzag(root.getLeft(), list, level - 1, flip);
            }
        }
        return list;
    }
    public void callvlzigzag() {
        ArrayList<ArrayList<Integer>> arrlist = new ArrayList<ArrayList<Integer>>();
        int lvl = 0;
        int d;
        int c=0;
        boolean flip=true;
        int h=returnHeight()+1;
        System.out.println(h);
        for(lvl=1;lvl<=h;lvl++){
            ArrayList<Integer> list=new ArrayList<Integer>();
            list = lvlzigzag(root, list, lvl,flip);
            //arrlist.get(lvl-1)=lvlzigzag(root, list, lvl,flip,d=lvl,c);
            arrlist.add(lvl-1, list);

            flip=!flip;
        }
        System.out.println(arrlist);
    }
    public void predecessor(Node root){
        if (root==null)
            return;
        root=root.getLeft();
        while(root.getRight()!=null)
            root=root.getRight();
        System.out.print(root.getData());
    }
    public void callpredecessor(){
        predecessor(root);
    }

}
