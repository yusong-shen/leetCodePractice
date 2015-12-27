package library;

import java.util.ArrayList;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	
	
	public TreeNode(int x) {
		val = x;
	}

	public ArrayList<TreeNode> Serializable(TreeNode root){
    	if (root==null) return new ArrayList<TreeNode>();
    	// level order traversal 
    	ArrayList<TreeNode> q = new ArrayList<TreeNode>();
    	q.add(root);
    	for (int i=0; i<q.size(); i++){
			TreeNode curr = q.get(i);
			if (curr==null) continue;
			q.add(curr.left);
			q.add(curr.right);
    	}
    	
    	// remove all the tail null
    	while(q.get(q.size()-1)==null){
    		q.remove(q.size()-1);
    	}		
    	return q;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
