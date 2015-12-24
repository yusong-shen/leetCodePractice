package solution.arrayString;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author yusong
 *
 */
public class LongestSubstring3 {

	/**
	 * single iteration
	 * @param s
	 * @return
	 */
    public static int lengthOfLongestSubstring(String s) {
    	int[] map = new int[256];
    	// initial the hash table, it map every char to its newest index
    	Arrays.fill(map, -1);
    	// i is the slow pointer, used to indicate the
    	// start point of a substring
    	int i = 0, n = s.length(), maxLen = 1;
    	if (n==0) return 0;
    	// j is the fast pointer, used to scan every char
    	for (int j = 0;j<s.length();j++){
    		// if we encounter repeat character, we move the slow pointer
    		if (map[s.charAt(j)]>=i){
    			i = map[s.charAt(j)] + 1;
    		}
    		// else we update our hash table with new char
    		map[s.charAt(j)] = j;
    		// it may be the potential longest substring
    		maxLen = Math.max(maxLen, j - i + 1);
    		
    		
    	}
		return maxLen;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
