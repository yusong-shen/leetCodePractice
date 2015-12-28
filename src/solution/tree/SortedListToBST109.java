package solution.tree;

import library.ListNode;
import library.TreeNode;

public class SortedListToBST109 {

	private ListNode curr;
	
    public TreeNode sortedListToBST(ListNode head) {
    	int n = 0;
    	ListNode p = head;
    	// count the length of linked list - O(n)
    	while (p!=null){
    		n++;
    		p = p.next;
    	}
    	curr = head;		
		return toBSTHelper(0, n-1);
        
    }

    /**
     * Bottom up approach - construct BST from leaves to root
     * Insert node in BST in the same order as Linked lList
     * @param start
     * @param end
     * @return
     */
    public TreeNode toBSTHelper(int start, int end){
    	// Base case
    	if (start>end) return null;
    	int mid = (start+end)/2;
    	System.out.println("mid"+mid);
    	
    	// Recursively construct the left subtree
    	TreeNode leftChild = toBSTHelper(start, mid-1);
    	
    	// Allocate memory for parent, parent is follow the same order
    	// of linked list
    	// then linked the left child to its parent
    	TreeNode parent = new TreeNode(curr.val);
    	System.out.println(curr.val);
    	parent.left = leftChild;
//    	System.out.println("left:"+((leftChild==null) ?"null":Integer.toString(leftChild.val)));

    	
    	// move current node to next
    	// note that we use a global variable to store it
    	// so every recursive call update it
    	curr = curr.next;

    	// Recursively construct the right subtree
    	// then linked the right child to its parent
    	parent.right = toBSTHelper(mid+1, end );
//    	System.out.println("right:"+((parent.right==null) ?"null":Integer.toString(parent.right.val)));
		return parent;
    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
