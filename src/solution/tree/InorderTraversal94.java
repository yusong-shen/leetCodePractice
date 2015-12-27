package solution.tree;

import java.util.ArrayList;
import java.util.List;

import library.TreeNode;

public class InorderTraversal94 {

	private List<Integer> list;
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	list = new ArrayList<Integer>();
    	inorderHelper(root);
		return list;
        
    }
    
    private boolean inorderHelper(TreeNode root){
    	if (root==null) return true;
    	// first, left subtree
    	if (inorderHelper(root.left)){
    		// then, current node
    		list.add(root.val);
    		return inorderHelper(root.right);
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
