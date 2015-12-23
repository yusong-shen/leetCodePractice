package solution.arrayString;

import java.util.HashMap;

public class ValidAnagram242 {

	/**
	 * 72 ms : way too slow...
	 * @param s
	 * @param t
	 * @return
	 */
    public static boolean isAnagram(String s, String t) {
    	HashMap<Character, Integer> counterS = new HashMap<Character, Integer>();
    	HashMap<Character, Integer> counterT = new HashMap<Character, Integer>();
    	if (s.length()!=t.length()) return false;
    	for (int i=0; i<s.length(); i++){
    		// count s
    		char x = s.charAt(i);
    		if (!counterS.containsKey(x))
    			counterS.put(x, 1);
    		else
    			counterS.put(x, counterS.get(x)+1);
    		// count t
    		char y = t.charAt(i);
    		if (!counterT.containsKey(y))
    			counterT.put(y, 1);
    		else
    			counterT.put(y, counterT.get(y)+1);
    	}
    	// compare two hash map
    	return counterS.equals(counterT);
        
    }
    

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}

}
