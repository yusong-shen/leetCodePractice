package solution.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne66 {
	
    public static int[] plusOne(int[] digits) {
    	int n = digits.length;
    	if (n==0) return new int[]{1};
    	if (digits[n-1]<9) {
    		digits[n-1]++;
    		return digits;
    	}
    	List<Integer> l = new ArrayList<Integer>();
    	// plus 1 for edge case
    	int sum = (digits[n-1] + 1)%10;
    	int carry = (digits[n-1] + 1)/10;
    	l.add(sum);
    	for (int i=1; i<n; i++){
    		sum = (digits[n-i-1] + carry)%10;
    		carry = (digits[n-i-1] + carry)/10;
    		l.add(sum);
    	}
    	if(carry==1) l.add(carry);
    	int[] result = new int[l.size()];
    	int m = l.size();
    	for (int i=0; i<m; i++){
    		result[i] = l.get(m-1-i).intValue();
    	}
		return result;
    	
        
    }

	public static void main(String[] args) {
		int[] digits = {1, 4, 8};
//		int[] digits = {9, 9, 9};
		int[] expected = {1, 0, 0, 0};
		System.out.println(Arrays.toString(plusOne(digits)));
	}

}
