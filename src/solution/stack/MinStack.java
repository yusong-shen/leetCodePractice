package solution.stack;

import java.util.Stack;

/**
 * #155 getMin() -- Retrieve the minimum element in the stack
 * @author yusong
 *
 */
public class MinStack {

	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	/**
	 * push element x onto stack
	 * @param x
	 */
    public void push(int x) {
    	stack.push(x);
    	// if stack is empty or the element is less than current minimal,
    	// push it to minStack
    	if (minStack.isEmpty()) {
    		minStack.push(x);
    	} else {
	    	int min = minStack.peek();
	    	if (x <= min) minStack.push(x);
    	}
    }

    /**
     * Removes the element on top of the stack
     */
    public void pop() {
        // if the element happen to be minimal, pop it from minStack
        if (stack.peek().equals(minStack.peek())){
        	minStack.pop();
        }
        stack.pop();

    }

    /**
     * get the top element
     * @return
     */
    public int top() {
		return stack.peek();
        
    }

    /**
     * 
     * @return
     */
    public int getMin() {
		return minStack.peek();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
