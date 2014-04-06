import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner.ListEditor;

class Node{
	 
	public Node(int val){
		this.val = val;
	}
	
	@Override
	public boolean equals(Object arg) {
		return this.val == ((Node)arg).val;
	}
	
	int val;
	Node left, right;
	
}

public class LargestIndependentSet {

	static List<Node> lisElems = new ArrayList<Node>();
	public static void main(String[] args) {
		/*Node root = new Node(20);
		root.left                = new Node(8);
		root.left.left          = new Node(4);
		root.left.right         = new Node(12);
		root.left.right.left   = new Node(10);
		root.left.right.right  = new Node(14);
		root.right               = new Node(22);
		root.right.right        = new Node(25);*/
		
		
		Node root = new Node(10);
		root.left                = new Node(20);
		root.left.left          = new Node(40);
		root.left.right         = new Node(50);
		root.left.right.left         = new Node(70);
		root.left.right.right         = new Node(80);
		root.right                = new Node(30);
		root.right.right   = new Node(60);
		System.out.println(LISS(root));
		List<Node> temp = new ArrayList<Node>();
				
		for(Node e : lisElems){
			if(!temp.contains(e)){
				System.out.print(e.val+"->");
				temp.add(e);
			}
			
		}
	}
	
	/**
	 * Overlapping function to calculate largest independent set.
	 * 
	 * @param root
	 * @return
	 */
	static int LISS(Node root){
		
		if(root == null)
			return 0;
		
		int sumExcl = LISS(root.left) + LISS(root.right);
		int sumIncl = 1;
		if(root.left != null)
			sumIncl += LISS(root.left.left) + LISS(root.left.right);
		if(root.right != null)
			sumIncl += LISS(root.right.left) + LISS(root.right.right);
		if(sumIncl > sumExcl){
			if(!lisElems.contains(root.left) && !lisElems.contains(root.right))
				lisElems.add(root);
			if(root.left != null){
				if(root.left.left != null && !lisElems.contains(root.left.left.left) && !lisElems.contains(root.left.left.right))
					lisElems.add(root.left.left);
				if(root.left.right != null && !lisElems.contains(root.left.right.left) && !lisElems.contains(root.left.right.right))
					lisElems.add(root.left.right);
			}
			if(root.right != null){
				if(root.right.left != null && !lisElems.contains(root.right.left.left) && !lisElems.contains(root.right.left.right))
					lisElems.add(root.right.left);
				if(root.right.right != null && !lisElems.contains(root.right.right.left) && !lisElems.contains(root.right.right.right))
					lisElems.add(root.right.right);
			
			}
			return sumIncl;
		}else{
			  if(root.left != null && !lisElems.contains(root.left.left) && !lisElems.contains(root.left.right))
				lisElems.add(root.left);
			  if(root.right != null && !lisElems.contains(root.right.left) && !lisElems.contains(root.right.right))
				lisElems.add(root.right);
						
			return sumExcl;
		}
			
	}
}
