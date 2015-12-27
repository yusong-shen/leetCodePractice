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
    
    private void inorderHelper(TreeNode root){
    	if (root==null) return ;
    	// first, left subtree
    	inorderHelper(root.left);
    	// then, current node
    	list.add(root.val);
    	// finally, right tree
    	inorderHelper(root.right);

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
