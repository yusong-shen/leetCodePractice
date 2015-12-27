package solution.tree;

import java.util.ArrayList;
import java.util.List;

import library.TreeNode;

public class PostorderTraversal145 {

	private List<Integer> list;

	
    public List<Integer> postorderTraversal(TreeNode root) {
    	list = new ArrayList<Integer>();
    	postorderHelper(root);
		return list;
        
    }

    private void postorderHelper(TreeNode root){
    	if (root==null) return ;
    	// first, left tree
    	postorderHelper(root.left);
    	// then, right tree
    	postorderHelper(root.right);
    	// finally, root node
    	list.add(root.val);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
