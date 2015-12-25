package solution.linkedList;

import library.ListNode;


public class MergeTwoLists21 {

	/**
	 * merge two sorted list
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	// use dummyhead to avoid initialization problem
    	// finally we would return dummyhead.next
    	ListNode dummyhead = new ListNode(0);
    	// scan pointer p
    	ListNode p = dummyhead;
    	while(l1!=null && l2!=null){
    		if (l1.val < l2.val){
    			p.next = l1;
    			l1 = l1.next;
    		} else{
    			p.next = l2;
    			l2 = l2.next;
    		}
    		// move forward
    		p = p.next;
    	}
    	// when we reach the tail of one of the original list
    	// simply append the rest of other list's nodes 
    	if (l1!=null) p.next = l1;
    	if (l2!=null) p.next = l2;
		return dummyhead.next;
        
    }

	public static void main(String[] args) {
		int[] l1 = {1,3,6,9};
		int[] l2 = {2,4,5,8,10};
		int[] expected = {1,2,3,4,5,6,8,9,10};
		ListNode nodeList1 = ListNode.buildList(l1);		
		ListNode nodeList2 = ListNode.buildList(l2);
		System.out.println(nodeList1);
		System.out.println(nodeList2);
		System.out.println(mergeTwoLists(nodeList1, nodeList2));
			
	}

}
