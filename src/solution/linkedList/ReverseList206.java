package solution.linkedList;

import library.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * @author yusong
 *
 */
public class ReverseList206 {

//	public class ListNode{
//		int val;
//		ListNode next;
//		ListNode(int x) { val = x;}
//	}
	
    public static ListNode  reverseList(ListNode head) {
    	// since current node can't access to the previous node directly
    	// we need to hold a reference of previous node
    	ListNode prev = null;
    	ListNode curr = head;
    	// go through the linked list until reach its end
    	while (curr != null){
    		// keep the reference of next node so that we can move forward
    		ListNode nextTemp = curr.next;
    		// make the current node point to the previous node
    		curr.next = prev;
    		// move forward
    		prev = curr;
    		curr = nextTemp;
    		
    	}
		return prev;
        
    }

    /**
     * 
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode  reverseList(ListNode head, int m, int n) {
    	if (m==n) return head;
    	if (head == null || head.next==null) return head;
    	
    	ListNode dummyhead = new ListNode(0);
    	dummyhead.next = head;
    	ListNode reversedPrev = dummyhead;
    	// find the node previous to the reverse list
    	for (int i=0; i<m-1; i++){
    		reversedPrev = reversedPrev.next;
    	}
    	// record the tail of the reversed linked list
    	ListNode reversedTail = reversedPrev.next;
    	
    	// reverse required part
    	ListNode curr = reversedTail;
    	ListNode prev = null;

    	for (int i=0; i<n-m+1; i++){
    		// store the tail of reversed part
    		if (i==n-m){
    			reversedTail.next = curr.next;
    		}
    		ListNode nextTemp = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = nextTemp;
    	}

    	// concatenate the first and second part
    	reversedPrev.next = prev;

    	return dummyhead.next;
        
    }
    
	public static void main(String[] args) {
//		ListNode head = new ListNode(0);
//		ListNode node1 = new ListNode(1);
//		ListNode node2 = new ListNode(2);
//		ListNode tail = new ListNode(3);
//		head.next = node1;
//		node1.next = node2;
//		node2.next = tail;
//		tail.next = null;
//		ListNode curr = head;
//		while (curr != null){
//			System.out.println(curr.val);
//			curr = curr.next;
//		}
//		
//		ListNode reversed = reverseList(head);
//		ListNode curr1 = reversed;
//		while (curr1 != null){
//			System.out.println(curr1.val);
//			curr1 = curr1.next;
//		}
		int[] l = {1,2,3,4,5};
//		int[] l = {3,5};
		ListNode nodeList = ListNode.buildList(l);
		System.out.println(reverseList(nodeList, 2, 2));
	}

}
