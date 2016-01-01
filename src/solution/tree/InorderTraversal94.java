package solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import library.TreeNode;

public class InorderTraversal94 {

	private List<Integer> list;
	
    public List<Integer> inorderTraversal(TreeNode root) {
    	list = new ArrayList<Integer>();
    	inorderHelper(root);
		return list;
        
    }
    
    private void inorderHelper(TreeNode root){
    	if (root==null) return ;
    	// first, left subtree
    	inorderHelper(root.left);
    	// then, current node
    	list.add(root.val);
    	// finally, right tree
    	inorderHelper(root.right);

    }
    
    /**
     * Using stack to implement inorder traversal without recursion
     * @param root
     * @return
     */
    public List<Integer> iterativeInoderTraversal(TreeNode node){
    	List<Integer> list = new ArrayList<>();
    	// the stack are used to store the parent node
    	Stack<TreeNode> stack = new Stack<>();
    	while(!stack.isEmpty() || node!=null){
    		// first, visit the left subtree 
    		// if we haven't get to the leaf, continue to go left
    		if (node!=null){
    			stack.push(node);
    			node = node.left;
    		} else {
    			// second, visit the current node
    			node = stack.pop();
    			list.add(node.val);
    			// finally, visit the right node
    			node = node.right;
    		}
    		
    		
    	}
		return list;
    	
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
