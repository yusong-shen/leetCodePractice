/**
 * 
 */
package codility;

import library.TreeNode;

/**
 * @author yusong
 *
 */
public class CountVisibleTreenode {

	public static int solution(TreeNode root){
		return countVisibleNode(root, -1);
		
	}
	
	/**
	 * 
	 * @param root
	 * @param maxSoFar the maximum value of node in the path so far
	 * @return
	 */
	public static int countVisibleNode(TreeNode root, int maxSoFar){
		if (root == null){
			return 0;
		}
		// base case
		if (maxSoFar == -1){
			maxSoFar = root.val;
		}
		
		// recursion
		// visible node
		if(maxSoFar <= root.val){
			return countVisibleNode(root.left, root.val) +
					countVisibleNode(root.right, root.val) +
					1;
		}
		// invisible node
		else{
			return countVisibleNode(root.left, maxSoFar) + 
					countVisibleNode(root.right, maxSoFar);
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 
				        5
				     /		\
				   3        10
				  /  \     /
				20   21   1
				
				visible node : 5, 10, 20, 21
		 * 
		 */
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(21);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		System.out.println(4 == solution(root));
		
	}

}
