package solution.tree;

import java.util.List;

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
    
    
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
		return null;
        
    }

	public static void main(String[] args) {
//		int[] tree = {5,4,8,11,null,13,4,7,2,null,null,5,1};
//		[
//		   [5,4,11,2],
//		   [5,8,4,5]
//		]		

	}

}
