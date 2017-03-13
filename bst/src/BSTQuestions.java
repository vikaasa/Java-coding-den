/**
 * Created by Vikaasa on 2/22/2016.
 */

public class BSTQuestions {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        BST tree = new BST();
        tree.insert(10);
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(7);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);

        //Level Order Traversal
        tree.callLevelOrderTraversal();

        //Path Sum
        tree.callPathSum(22);

        //Lowest Common Ancestor
        Node lcs = tree.callLowestCommonAncestor(7,9);
        System.out.println(lcs.getData());

        //In Order Traversal
        tree.traversal("inOrder");

        //Tree Height
        tree.checkHeight();

        //Tree Vertical Level Order Traversal
        tree.callVerticalLevelOrderTraversal();

        //tree.allPaths();
        //tree.callCheckBST();
        //tree.callCheckBstInOrder();
        //tree.callSearch(7);
        //tree.callCompare(tree2);
        tree.allPaths();
        //tree.callLvlZigZag();
        //tree.callpredecessor();
    }



}
