package solution.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import library.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * @author yusong
 *
 */
public class SerializeTree297 {

	
	
	/**
	 * Encodes a tree to a single string.
	 * Format is the same as Leetcode OJ
	 * [5,4,7,3,#,2,#,-1,#,9]
	 * @param root
	 * @return
	 */
    public static String serialize(TreeNode root) {
    	if (root==null) return "[]";
    	StringBuilder result = new StringBuilder();
    	// level order traversal 
    	ArrayList<TreeNode> q = new ArrayList<TreeNode>();
    	q.add(root);
    	for (int i=0; i<q.size(); i++){
			TreeNode curr = q.get(i);
			if (curr==null) continue;
			q.add(curr.left);
			q.add(curr.right);
    	}
    	
    	// remove all the tail null
    	while(q.get(q.size()-1)==null){
    		q.remove(q.size()-1);
    	}
    	
    	// now that we get the list representation,
    	// we can change it to string format
    	result.append("[");
    	for (int i=0; i<q.size()-1; i++){
    		String node = (q.get(i)==null) ? "#":Integer.toString(q.get(i).val);
    		result.append(node+",");
    	}
    	String node = (q.get(q.size()-1)==null) ? "#":Integer.toString(q.get(q.size()-1).val);
    	result.append(node+"]");	
    	System.out.println(result.toString());
		return result.toString();
        
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if (data=="[]") return null;
    	String d = data.substring(1, data.length()-1);
    	String[] nodes = d.split(",");
    	ArrayList<TreeNode> q = new ArrayList<TreeNode>();
    	TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
    	q.add(root);
    	int parent = 0;
    	for (int i = 1; i<nodes.length; i++){
    		if (!nodes[i].equals("#")){
    			TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
    			System.out.println(node.val);
    			// left child's index is odd
    			if (i%2==1){
    				q.get(parent).left = node;
    			} else{
    				q.get(parent).right = node;
    			}
    			q.add(node);
    		}
    		if (i%2==0){
    			parent++;
    		}
    	}
		return root;
        
    }

	public static void main(String[] args) {
		// Your Codec object will be instantiated and called as such:
		// SerializeTree codec = new SerializeTree();
		// codec.deserialize(SerializeTree.serialize(root));
		String data = "[1,2,3,#,#,4,5]";
		TreeNode root = deserialize(data);
	}

}
