
public class BSTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bst tree = new Bst();
		
		tree.insert(10);
		tree.insert(8);
		tree.insert(12);
		tree.insert(7);
		tree.insert(9);
		tree.insert(11);
		tree.insert(13);
		
		tree.recInsert(10);
		tree.recInsert(8);
		tree.recInsert(9);
		
		tree.traversal("inOrder");
		System.out.println();
		tree.traversal("postOrder");
//		System.out.println();
		
		//tree.allpaths();	
		
	}

}
