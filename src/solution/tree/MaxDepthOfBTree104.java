package solution.tree;

import library.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaxDepthOfBTree104 {

    public int maxDepth(TreeNode root) {
    	if (root == null) return 0;
    	
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
