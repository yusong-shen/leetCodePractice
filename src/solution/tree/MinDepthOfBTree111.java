package solution.tree;

import java.util.LinkedList;
import java.util.Queue;

import library.TreeNode;

public class MinDepthOfBTree111 {

	/**
	 * BFS - level order traversal
	 * 
	 * @param root
	 * @return
	 */
    public int minDepth(TreeNode root) {
    	if (root==null) return 0;
    	int depth = 1;
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	// keep track the rightmost node, 
    	TreeNode rightmost = root;
    	while(!q.isEmpty()){
    		TreeNode curr = q.poll();
    		// if we reach the leaf node, immediately  return
    		if(curr.left==null && curr.right==null) break;
    		// enqueue the left and right node
    		if(curr.left!=null) q.add(curr.left);
    		if(curr.right!=null) q.add(curr.right); 
    		// if we get to the rightmost
        	// we know we reach the end of this level
    		if (curr==rightmost){
    			depth++;
    			rightmost = (curr.right==null)? curr.left : curr.right;
    		}   		
    	}
		return depth;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
