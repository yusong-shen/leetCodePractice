package library;

import java.util.ArrayList;
import java.util.Arrays;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x;}

	public static ListNode buildList(int[] intList){
//		if (intList.length==0)  ;
		int n = intList.length;
		ListNode[] nodeList = new ListNode[n];
		// initialize all node
		for (int i = 0; i<n; i++){
			nodeList[i] = new ListNode(intList[i]);
		}
		// set next node
		for (int j = 0; j<n-1; j++){
			nodeList[j].next = nodeList[j+1];
//			System.out.println(nodeList[j]);
		}
		// set tail
		nodeList[n-1].next = null;
		// return head
		return nodeList[0];
		
	}
	
	public ArrayList<Integer> toArray(){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ListNode curr = this;
		while(curr!=null){
			intList.add(curr.val);
			curr = curr.next;
		}
		return intList;
	}
	
	@Override
	public String toString(){
		String s = "";
		ListNode curr = this;
		while (curr != null){
			s = s + curr.val + ", ";
			curr = curr.next;
		}
		return s;
	}
	
	public static void main(String[] args) {
		int[] l1 = {1,3,6,9};
		System.out.println(buildList(l1));
	}

}
