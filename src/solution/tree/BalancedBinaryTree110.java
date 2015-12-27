package solution.tree;

import library.TreeNode;

public class BalancedBinaryTree110 {
	
    public boolean isBalanced(TreeNode root) {
		return maxDepth(root)!=-1;
        
    }

    public int maxDepth(TreeNode root) {
    	if (root == null) return 0;
    	// if left subtree is unbalanced, we return -1 immediately
    	// indicate it is unbalanced
    	int L = maxDepth(root.left);
    	if (L==-1) return -1;
    	// check the right subtree similar to left
    	int R = maxDepth(root.right);
    	if (R==-1) return -1;
    	// if both of left and right subtree are balanced,
    	// we check their depths
		return (Math.abs(L-R)<=1)?(Math.max(L, R)+1):-1;
        
    }

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
