package solution.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {

	// use map to maintain correspondence
	private Map<Character,Character> map = new HashMap<Character,Character>() {{
		put(']', '[');
		put(')', '(');
		put('}', '{');
	}};

	
    public boolean isValid(String s) {
    	if (s.length()%2!=0) return false;
    	
    	// use stack to check parentheses
    	Stack<Character> stack = new Stack<>();
    	for (char c : s.toCharArray()){
    		if (map.containsValue(c)){
    			stack.push(c);
    		} else if (stack.isEmpty() || map.get(c)!=stack.pop()){
    			return false;			
    		}
    	}
    	return stack.isEmpty();
        
    }

	public static void main(String[] args) {
		ValidParentheses20 test = new ValidParentheses20();
		String s1 = "[{{){]";
		System.out.println(test.isValid(s1));
		String s2 = "(){}[]";
		System.out.println(test.isValid(s2));

	}

}
