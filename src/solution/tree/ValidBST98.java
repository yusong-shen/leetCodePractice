package solution.tree;

import library.TreeNode;

public class ValidBST98 {

	private TreeNode prev;
	
	/**
	 * In order traversal
	 * Left subtree -> current node -> right subtree
	 * @param root
	 * @return
	 */
    public boolean isValidBST(TreeNode root) {
    	TreeNode prev = null;
		return isBSTInOrder(root);
        
    }

    /**
     * helper function
     * @param root
     * @param prev
     * @return
     */
    public boolean isBSTInOrder(TreeNode root){
    	// empty tree - base case
    	if (root==null) return true;
    	// first check the left subtree
    	if (isBSTInOrder(root.left)){
    		// then check if current node's value is greater than previous node
    		// if not, return false
    		if (prev!=null && root.val<=prev.val) return false;
    		prev = root;
    		// finally check the right subtree
    		return isBSTInOrder(root.right);
    	}
    	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
