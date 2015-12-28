package solution.tree;

import library.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 * @author yusong
 *
 */
public class PathSum112 {


	/**
	 * DFS 
	 * @param root
	 * @param sum
	 * @return
	 */
    public boolean hasPathSum(TreeNode root, int sum) {
    	// Base case
    	if (root==null) return false;
    	// leaf node
    	if (root.left==null && root.right==null) return sum==root.val;
    	// depth first recursion
    	// or is short circuit operation, if it got one condition true
    	// it will immediately return.
		return hasPathSum(root.left, sum-root.val) ||
				hasPathSum(root.right, sum-root.val);
        
    }
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
