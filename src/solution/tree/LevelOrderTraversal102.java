package solution.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import library.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author yusong
 *
 */
public class LevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	if (root==null) return Collections.emptyList();
    	List<List<Integer>> levelLists = new ArrayList<List<Integer>>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.offer(root);
    	while(!q.isEmpty()){
    		// get to a new level
    		List<Integer> level = new ArrayList<Integer>();
    		// iterate inside level
    		int n = q.size();
    		for (int i=0; i<n; i++){
    			TreeNode curr = q.poll();
    			level.add(curr.val);
    			if(curr.left!=null) {
    				q.offer(curr.left);
    			}
    			if(curr.right!=null){
    				q.offer(curr.right);
    			}
    		}
    		levelLists.add(level);
    	}
		return levelLists;
        
    }

	public static void main(String[] args) {

	}

}
