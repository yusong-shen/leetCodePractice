package solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import library.TreeNode;

public class PostorderTraversal145 {

	private List<Integer> list;

	
    public List<Integer> postorderTraversal(TreeNode root) {
    	list = new ArrayList<Integer>();
    	postorderHelper(root);
		return list;
        
    }

    private void postorderHelper(TreeNode root){
    	if (root==null) return ;
    	// first, left tree
    	postorderHelper(root.left);
    	// then, right tree
    	postorderHelper(root.right);
    	// finally, root node
    	list.add(root.val);
    }

    /**
     * Using stack to implement post-order traversal without recursion
     * @param root
     * @return
     */	
    public List<Integer> IterativePostorderTraversal(TreeNode node) {
    	List<Integer> list = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode lastVisited = null;
    	while(!stack.isEmpty() || node!=null){
    		if (node!=null){
    			stack.push(node);
    			node = node.left;
    		} else{
    			TreeNode peek = stack.peek();
    			// if right exist AND traversing node from left child,
    			// move right
    			if (peek.right!=null && lastVisited!=peek.right){
    				node = peek.right;
    			}
    			else{
    				list.add(peek.val);
    				lastVisited = stack.pop();
    			}
    		}
    	}
		return list;
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
