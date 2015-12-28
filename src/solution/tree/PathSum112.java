package solution.tree;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    
    /*#113  */
    private List<List<Integer>> result;
    private List<Integer> path;
    private int pathSum=0;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	result = new ArrayList<>();
    	path = new ArrayList<Integer>();
    	pathSumHelper(root, sum);
		return result;
        
    }
    
    public void pathSumHelper(TreeNode root, int sum){
    	if (root==null) return ;
    	path.add(root.val);
    	pathSum += root.val;
    	// when we reach the end of path
    	// check if its sum satisfy requirement
    	if (root.left==null && root.right==null && pathSum==sum){
    		List<Integer> list = new ArrayList<>();
    		for (Integer i : path){
    			list.add(i);
    		}
    		result.add(list);

    	}
    	// if we haven't reach the end of path, 
    	// Continually recursive call helper function
    	if (root.left!=null){
    		pathSumHelper(root.left, sum);
    	}
    	if (root.right!=null){
    		pathSumHelper(root.right, sum);
    	}
    	// After reach the end of path, 
    	// since we need to find all possible path, we need to
    	// delete the current node from path
//    	System.out.println(pathSum);
//    	System.out.println(Arrays.toString(path.toArray()));
    	pathSum -= root.val;
    	path.remove(path.size()-1);
    }

	public static void main(String[] args) {
//		int[] tree = {5,4,8,11,null,13,4,7,2,null,null,5,1};
//		[
//		   [5,4,11,2],
//		   [5,8,4,5]
//		]		
//		[5,4,8,11,null,13,4]
//				26
	}

}
