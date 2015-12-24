package solution.arrayString;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * @author yusong
 *
 */
public class ReverseWords151 {

    public static String reverseWords(String s) {
    	// version 1
//    	String result = "";
//    	// remove multiple space 
//    	String[] words = s.trim().split(" +");
//    	if (words.length==0) return "";
//    	for (int i = 0; i<words.length-1; i++){
//    		result = result.concat(words[words.length-1-i]+" ");
//    	}
//		return result.concat(words[0]);
//        
    	// version 2 - StringBuilder
    	StringBuilder result = new StringBuilder();
    	// remove multiple space 
    	String[] words = s.trim().split(" +");
    	if (words.length==0) return "";
    	for (int i = 0; i<words.length-1; i++){
    		result = result.append(words[words.length-1-i]+" ");
    	}
		return result.append(words[0]).toString();
 
    }

    /**
     * In place reverse
     * @param s
     */
    public static void reverseWords(char[] s) {
    	// first inverse the entire string
    	reverse(s,0, s.length);
    	// then inverse each individual word
    	// use two pointers
    	// j is fast pointer
    	// i is slow pointer to keep track the start of a word
    	for (int i=0, j=0; j<=s.length; j++){
    		// check each word
    		if ( j==s.length || s[j]==' '){
    			reverse(s, i, j);
    			i = j+1;
    		}
    	}
        
    }
    
    /**
     * helper method to reverse given character
     * @param s
     * @param start
     * @param end
     */
	private static void reverse(char[] s, int start, int end) {
		char temp;
		for (int i = 0; i<(end-start)/2; i++){
			temp = s[start+i];
			s[start+i] = s[end-i-1];
			s[end-i-1] = temp;
		}
	}

	public static void main(String[] args) {
//		String s = "the    sky    is    blue";
//		String s = "   1";
		String s = "the sky is blue";
		String expected = "blue is sky the";
		System.out.println(reverseWords(s));
		char[] s1 = {'t', 'h', 'e', ' ', 's', 'k', 'y'};
		reverseWords(s1);
		System.out.println(new String(s1));
	}

}
