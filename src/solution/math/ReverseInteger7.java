package solution.math;

public class ReverseInteger7 {

    public static int reverse(int x) {
    	int reversed = 0;
    	while(x!=0){
    		// handle overflow/underflow
    		int digit = x%10;
    		if (Math.abs(reversed)>214748364){
    			return 0;
    		}
    		reversed = 10*reversed + digit;
    		x = x/10;
    	}
		return reversed;
        
    }

	public static void main(String[] args) {
		int x = 100010;
		System.out.println(reverse(x));
		System.out.println(Integer.MAX_VALUE);
	}

}
