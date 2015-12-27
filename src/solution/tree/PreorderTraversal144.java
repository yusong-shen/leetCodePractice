package solution.tree;

import java.util.ArrayList;
import java.util.List;

import library.TreeNode;

public class PreorderTraversal144 {

	private List<Integer> list;
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	list = new ArrayList<Integer>();
    	preorderHelper(root);
		return list;
        
    }
    
    private void preorderHelper(TreeNode root){
    	if (root==null) return ;
    	// first, current node
    	list.add(root.val);
    	// then, left tree
    	preorderHelper(root.left);
		// finally, right tree
		preorderHelper(root.right);

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
