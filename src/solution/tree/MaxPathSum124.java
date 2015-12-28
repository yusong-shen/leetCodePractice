package solution.tree;

import library.TreeNode;

/**
 * 
 * @author yusong
 *
 */
public class MaxPathSum124 {

	private int maxSum ;
	
	/**
	 * Bottom up approach - check each node
	 * @param root
	 * @return
	 */
    public int maxPathSum(TreeNode root) {
    	maxSum = Integer.MIN_VALUE;
    	findMax(root);
		return maxSum;
        
    }
    
    public int findMax(TreeNode root){
    	if (root==null) return 0;
    	int maxLeft = findMax(root.left);
    	int maxRight = findMax(root.right);
    	maxSum = Math.max(maxLeft+root.val+maxRight, maxSum);
    	int result = root.val + Math.max(maxLeft, maxRight);
    	// if maximum less than 0, we simply let it be 0.
    	// which means we don't include this subtree
    	// as part of maximum path of parent
		return result>0?result:0;    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
