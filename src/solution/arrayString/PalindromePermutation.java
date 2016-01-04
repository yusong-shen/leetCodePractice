package solution.arrayString;

import java.util.HashMap;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	for (int i=0; i<s.length(); i++){
    		char c = s.charAt(i);
    		if (map.containsKey(c)){
    			map.put(c, map.get(c)+1);
    		} else{
    			map.put(c, 0);
    		}
    	}
    	int numOdd = 0;
    	for (char c : map.keySet()){
    		if (s.length()%2==0 && map.get(c)%2!=1){
    			return false;
    		}
    		if (s.length()%2==1 && map.get(c)%2!=1){
    			numOdd++;
    			if(numOdd>1) return false;
    		}
    	}
        return true;
    }

	public static void main(String[] args) {
		String s = "aabbcd";
		PalindromePermutation test = new PalindromePermutation();
		System.out.println(test.canPermutePalindrome(s));
	}

}
