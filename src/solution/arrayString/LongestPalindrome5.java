package solution.arrayString;

public class LongestPalindrome5 {

    public String longestPalindrome(String s) {
    	// keep track of the longest valid substring
    	int start = 0,end =0;
    	for(int i=0;i<s.length();i++){
    		int len1 = expandCenter(s, i, i);
    		int len2 = expandCenter(s, i, i+1);
    		int len = Math.max(len1, len2);
    		if (len > end - start){
    			// abba vs. aba
    			// i=1, len = 4 vs. 3;
    			start = i - (len-1)/2 ;
    			end = i + len/2;
    		}
    	}
    	// endIndex is exclusive, so need to add one to it
    	return s.substring(start, end+1);
        
    }
    
    /**
     * return the length of valid palindrome substring
     * @param s
     * @param l
     * @param r
     * @return
     */
    private int expandCenter(String s, int l, int r){
    	while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
    		l--;
    		r++;
    	}
    	return r-l-1;
    }
    
    /**
     * Dynamic Programming
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindrome(String s, int start, int end){
    	// Base case
    	if(start==end) return true;
    	if(start==end-1) {
    		return s.charAt(start)==s.charAt(end);
    	}
    	// Recursion
    	return isPalindrome(s, start+1, end-1);
    }

	public static void main(String[] args) {
		String s = "aaacabac";
//		String s = "cadac";
		LongestPalindrome5 test = new LongestPalindrome5();
		System.out.println(test.longestPalindrome(s));
//		System.out.println(test.isPalindrome(s, 0, s.length()-1));
	}

}
