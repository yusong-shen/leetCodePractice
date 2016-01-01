package solution.arrayString;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * @author yusong
 *
 */
public class LongestSubstringTwoDistinct159 {

	/**
	 * use two pointer to keep track the substring
	 * use hashtable to record the number of distinct characters
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	// slow pointer i keep track of the start of substring
    	int i = 0, numDistinct =0, maxLen = 0;
    	int[] count = new int[256];
    	for (int j=0; j<s.length(); j++){
    		if (count[s.charAt(j)]==0){
	    		numDistinct++;
    		}
    		count[s.charAt(j)]++;
    		// sliding window
    		while (numDistinct>2){
    			// move the slow pointer i
    			count[s.charAt(i)]--;
    			if (count[s.charAt(i)]==0) numDistinct--;
    			i++;
    		}
    		maxLen = Math.max(j-i+1, maxLen);
    	}
		return maxLen;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
