package solution.linkedList;

import java.util.HashMap;
import java.util.Map;

import library.RandomListNode;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * @author yusong
 *
 */
public class CopyRandomList139 {

    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode dummy = new RandomListNode(0);
    	RandomListNode p = head;
    	RandomListNode q = dummy;
    	Map<RandomListNode,RandomListNode> map = new HashMap<>();
    	// first pass - 
    	// build the map and clone linked list structure without random part
    	// we map the original node to clone node  
    	while(p!=null){
    		q.next = new RandomListNode(p.label);
    		map.put(p, q.next);
    		p = p.next;
    		q = q.next;
    	}
    	// second pass - clone random part
    	p = head;
    	q = dummy;
    	// since we now have full map of original linked list,
    	// we can gain O(1) access when connect the random node
    	while(p!=null){
    		q.next.random = map.get(p.random);
    		q = q.next;
    		p = p.next;
    	}
		return dummy.next;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
