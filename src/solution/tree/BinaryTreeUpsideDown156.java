package solution.tree;

import library.TreeNode;


/** for example, turn these:
 *
 *        1                 1
 *       / \                 / \
 *      2   3            2   3
 *     / \
 *    4   5
 *   / \
 *  6   7
 *
 * into these:
 *
 *        1               1
 *       /               /
 *      2---3         2---3
 *     /
 *    4---5
 *   /
 *  6---7
 *
 * where 6 is the new root node for the left tree, and 2 for the right tree.
 * oriented correctly:
 *
 *     6                   2
 *    / \                   / \
 *   7   4              3   1
 *        / \
 *       5   2
 *            / \
 *          3   1
 */
public class BinaryTreeUpsideDown156 {


    public TreeNode iterativeUpsideDownBinaryTree(TreeNode root) {
    	// see above figure
    	// e.g. 1
    	TreeNode curr = root;
    	// e.g. 2
    	TreeNode parent = null;
    	// e.g. 3 
    	// current node become parent node in next iteration
    	TreeNode parentRight = null;
    	while(curr!=null){
    		TreeNode tempLeft = curr.left;
    		curr.left = parentRight;
    		parentRight = curr.right;
    		curr.right = parent;
    		parent = curr;
    		curr = tempLeft;
    	}
		return parent;
        
    }

    /**
     * Bottom up recursive version
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
    	return dfsHelper(root, null);
    }

    public TreeNode dfsHelper(TreeNode curr, TreeNode parent){
    	// if we get down to the leftmost leaf, we get the root
    	if (curr == null) return parent;
    	TreeNode root = dfsHelper(curr.left, curr);
    	System.out.println(root.val);
    	// since we convert BT from the bottom, we won't worry
    	// too much about all the copy things.
    	// if we get to the original root(parent=null), its left child
    	// should be null.
    	curr.left = (parent==null)? parent : parent.right;
    	curr.right = parent;
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
