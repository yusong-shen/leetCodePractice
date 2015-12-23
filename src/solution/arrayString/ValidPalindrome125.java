package solution.arrayString;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * @author yusong
 *
 */
public class ValidPalindrome125 {

    public static boolean isPalindrome(String s) {
    	int i = 0;
    	int j = s.length()-1;
    	while(i<=j){
    		if (!Character.isLetterOrDigit(s.charAt(i))) {
    			i++;
    			continue;
    		}
    		if (!Character.isLetterOrDigit(s.charAt(j))) {
    			j--;
    			continue;
    		}
    		char x = Character.toLowerCase(s.charAt(i));
    		char y = Character.toLowerCase(s.charAt(j));
    		if ( x != y) return false;	
    		i++;
    		j--;
    		
    	}
		return true;
        
    }

	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s1));
	}

}
