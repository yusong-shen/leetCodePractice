package solution.arrayString;

public class String2Integer8 {

	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	
    public static int myAtoi(String str) {
    	int i=0;
		int sign = 1;
		int num = 0;
		int n = str.length();
		// check empty string
		if (n==0) return 0;
		// skip white space
    	while(i<n && Character.isWhitespace(str.charAt(i))) i++;
		// if first character is "-", sign is negative
		if (str.charAt(i)=='-') {
			sign=-1; i++;
		}else if (str.charAt(i)=='+') {
			i++;
		}
		// convert digit
		while(i<n && Character.isDigit(str.charAt(i))){
			int digit = Character.getNumericValue(str.charAt(i));
			// check if overflow
			if(num > maxDiv10 || (num == maxDiv10 && digit >=8)){
				return (sign==1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = 10*num + digit;
			i++;
		}
    		
		return sign*num;
        
    }
	
	public static void main(String[] args) {
		String s3 = "2578afag";
		System.out.println(myAtoi(s3));
	}

		
}
