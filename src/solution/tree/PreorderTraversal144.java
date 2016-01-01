package solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    
    /**
     * Using stack to implement preorder traversal without recursion
     * @param root
     * @return
     */
    public List<Integer> IterativePreorderTraversal(TreeNode node) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<>();
    	while(!stack.isEmpty() || node!=null){
    		// first, visit the current node
    		if (node!=null){
    			list.add(node.val);
    			// push its right child into stack
    			if (node.right!=null){
    				stack.push(node.right);
    			}
    			// second, go to the left subtree
    			node = node.left;
    		} else{
    			// if node is null
    			node = stack.pop();
    		}
    	}
    	
		return list;
        
    }    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
