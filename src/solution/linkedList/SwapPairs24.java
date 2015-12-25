package solution.linkedList;

import library.ListNode;

public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
    	// let p,n,nn are the current, next and next's next' node
    	ListNode dummyhead = new ListNode(0);
    	dummyhead.next = head;
    	ListNode p = head;
    	// we need to keep track the previous node to connect two pairs
    	ListNode prev = dummyhead;
    	// if there are only 0 or 1 node, return head
    	while(p!=null && p.next!=null){
    		// p -> n -> nn -> s e.g 1 -> 2 -> 3 -> 4
    		// after one step, should become
    		// n -> p -> nn -> s e.g 2 -> 1 -> 3 -> 4
    		ListNode n = p.next, nn = p.next.next;
    		// store n 
    		prev.next = n;
    		// let 2 -> 1
    		n.next = p;
    		// let 1 -> 3
    		p.next = nn;
    		// store current node p 
    		prev = p;
    		// jump forward to nn (next's next)
    		p = nn;
    		
    		
    	}
		return dummyhead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
