package solution.math;

public class PalindromeNumber9 {

    public static boolean isPalindrome(int x) {
		if (x<0) return false;
		// used to chop off the first digit
		int div = 1;
		while(x/div>=10){
			div*=10;
		}
		while(x!=0){
			int first = x/div;
			int last = x%10;
//			System.out.println(div);
			System.out.println(first);
			System.out.println(last);
			if (first!=last) return false;
			// chop off the first and last digit
			x = (x%div)/10;
			div/=100;
			System.out.println(x);
//			System.out.println(div);
		}
		return true;
        
    }

	public static void main(String[] args) {
		int x = 100021;
		System.out.println(isPalindrome(x));
	}

}
