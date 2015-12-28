package solution.tree;

import library.TreeNode;

public class SortedArrayToBST108 {

    public TreeNode sortedArrayToBST(int[] nums) {
		return toBSTHelper(nums, 0, nums.length-1);
        
    }
    
    public TreeNode toBSTHelper(int[] nums, int start, int end){
    	if (start>end) return null;
    	// divide and conquer
    	int rootInd = (start + end)/2;
    	TreeNode root = new TreeNode(nums[rootInd]);
    	// left side
    	root.left = toBSTHelper(nums, start, rootInd-1);
    	// right side
    	root.right = toBSTHelper(nums, rootInd+1, end);
    	
    	return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
