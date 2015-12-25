package solution.linkedList;

import library.ListNode;

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

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode tail = new ListNode(3);
		head.next = node1;
		node1.next = node2;
		node2.next = tail;
		tail.next = null;
		ListNode curr = head;
		while (curr != null){
			System.out.println(curr.val);
			curr = curr.next;
		}
		
		ListNode reversed = reverseList(head);
		ListNode curr1 = reversed;
		while (curr1 != null){
			System.out.println(curr1.val);
			curr1 = curr1.next;
		}
	}

}
