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

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(ArrayList<TreeNode> q) {
    	if (q.size()==0) return null;
    	TreeNode root = q.get(0);
    	int parent = 0;
    	for (int i = 1; i<q.size(); i++){
    		if (!q.get(i).equals(null)){
    			TreeNode node = q.get(i);
//    			System.out.println(node.val);
    			// left child's index is odd
    			if (i%2==1){
    				q.get(parent).left = node;
    			} else{
    				q.get(parent).right = node;
    			}
    			q.add(node);
    		}
    		if (i%2==0){
    			parent++;
    		}
    	}
		return root;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
