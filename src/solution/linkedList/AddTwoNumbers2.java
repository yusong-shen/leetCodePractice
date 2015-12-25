package solution.linkedList;

import library.ListNode;

public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode dummyhead = new ListNode(0);
    	dummyhead.next = null;
    	ListNode p = dummyhead;
    	int carry = 0;
    	int sum = 0;
    	while(l1!=null && l2!=null){
    		sum = (l1.val + l2.val + carry)%10;
    		carry = (l1.val + l2.val + carry)/10;
    		p.next = new ListNode(sum);
    		l1 = l1.next;
    		l2 = l2.next;
    		p = p.next;
    	}
    	while (l1!=null) {
    		sum = (l1.val+carry)%10;
    		carry = (l1.val+ carry)/10;
    		p.next = new ListNode(sum);
    		l1 = l1.next;
    		p = p.next;
    	}
    	while (l2!=null) {
    		sum = (l2.val+carry)%10;
    		carry = (l2.val+ carry)/10;
    		p.next = new ListNode(sum);
    		l2 = l2.next;
    		p = p.next;
    	}
    	if (carry==1) p.next = new ListNode(carry);
    	
		return dummyhead.next;
        
    }

	public static void main(String[] args) {
//		int[] l1 = {2, 4, 3};
//		int[] l2 = {5, 6};
		int[] l1 = {};
		int[] l2 = {};
		int[] expected = {7, 0, 4};
		ListNode nodeList1 = ListNode.buildList(l1);		
		ListNode nodeList2 = ListNode.buildList(l2);
		System.out.println(addTwoNumbers(nodeList1, nodeList2));
	}

}
