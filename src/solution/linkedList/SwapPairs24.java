package solution.linkedList;

import library.ListNode;

public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
    	// let p,q,r are the current, next and next's next' node
    	ListNode dummyhead = new ListNode(0);
    	dummyhead.next = head;
    	ListNode p = head;
    	ListNode prev = dummyhead;
    	// if there are only 0 or 1 node, return head
    	while(p!=null && p.next!=null){
    		// p -> q -> r -> s e.g 1 -> 2 -> 3 -> 4
    		// after one step, should become
    		// q -> p -> r -> s e.g 2 -> 1 -> 3 -> 4
    		ListNode q = p.next, r = p.next.next;
    		// store q 
    		prev.next = q;
    		// let 2 -> 1
    		q.next = p;
    		// let 1 -> 3
    		p.next = r;
    		// store current node p 
    		prev = p;
    		// move forward to r
    		p = r;
    		
    		
    	}
		return dummyhead.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
