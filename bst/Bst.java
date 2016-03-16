import java.util.*;

public class Bst {
	
	private Node root;
	
	public void insert(int data){
		Node node =  new Node(data);
		if(root == null) {
			root = node;
			return;
		}
		Node cur = root;
		Node pre=root;
		while(cur!=null){
			pre = cur;
			if(node.getData()<cur.getData()){
				cur=cur.getLeft();
			}
			else{
				cur=cur.getRight();
			}
		}
		if(node.getData()<pre.getData()){
			pre.setLeft(node);
		}
		else{
			pre.setRight(node);
		}

	}
	
	public Node insertRec(Node root,int data){
		if(root==null){
			root = new Node(data);
			return root;
		}
		else if(data<root.getData()){
			root.setLeft(insertRec(root.getLeft(),data));
		}
		else{
			root.setRight(insertRec(root.getRight(),data));
		}
		
		return root;
		
	}
	
	public void recInsert(int data){
		this.root=insertRec(root,data);
	}
	
	public void inOrder(Node root){
		if(root==null){return;}
		inOrder(root.getLeft());
		System.out.print(root.getData()+"->");
		inOrder(root.getRight());
	}
	
	public void preOrder(Node root){
		if(root==null){return;}
		System.out.print(root.getData()+"->");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	public void postOrder(Node root){
		if(root==null){return;}
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+"->");
	}
	
	public void traversal(String path){
		if(root!=null){
			if(path.equals(new String("postOrder"))){
				postOrder(root);
			}
			else if(path.equals(new String("preOrder"))){
				preOrder(root);
			}
			else{
				inOrder(root);
			}
		}
	}
	
	public void paths(Node root,ArrayList<StringBuilder> pathlist, StringBuilder str){
		if(root==null){
			return;
		}
		
		StringBuilder st = new StringBuilder();
		st.append(str);
		st.append(root.getData());
		
		//System.out.print(st);
		
		if(root.getLeft()==null && root.getRight()==null){
			pathlist.add(st);
			//System.out.println(curr.toString()+" leaf node: return");
			return;
		}
		st.append(' ');
		paths(root.getLeft(),pathlist,st);
		paths(root.getRight(),pathlist,st);	
	}

	public void allpaths(){
		StringBuilder st = new StringBuilder();
		//st.append(" ");
		ArrayList<StringBuilder> pathlist = new ArrayList<StringBuilder>();
		paths(root,pathlist,st);
		System.out.println(pathlist);
	}
}
