package solution.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN150 {

	private static final Set<String> OPERATORS = 
			new HashSet<>(Arrays.asList("+", "-", "*", "/"));
	
    public static int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<>();
    	for (String t : tokens){
    		if(OPERATORS.contains(t)){
    			int y = stack.pop();
    			int x = stack.pop();
    			int result = evaluate(x, y, t);
    			stack.push(result);
    		} else{
    			stack.push(Integer.parseInt(t));
    		}
    	}
		return stack.pop();
        
    }
    
    private static int evaluate(int x, int y, String operator){
    	switch(operator){
    	case "+": return x+y;
    	case "-": return x-y;
    	case "*": return x*y;
    	default: return x/y;
    		
    	}
    }

	public static void main(String[] args) {
		String[] t1 = {"2", "1", "+", "3", "*"};
//		int expected1 = 9;
		System.out.println(evalRPN(t1));
		String[] t2 = {"4", "13", "5", "/", "+"};
//		int expected2 = 6;
		System.out.println(evalRPN(t2));
	}

}
