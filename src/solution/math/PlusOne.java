package solution.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
	
    public static int[] plusOne(int[] digits) {
    	int n = digits.length;
    	if (n==0) return new int[]{1};
    	List<Integer> l = new ArrayList<Integer>();
    	// plus 1
    	int sum = (digits[n-1] + 1)%10;
    	int carry = (digits[n-1] + 1)/10;
    	l.add(0,sum);
    	for (int i=1; i<n; i++){
    		sum = (digits[n-i-1] + carry)%10;
    		carry = (digits[n-i-1] + carry)/10;
    		l.add(0, sum);
    	}
    	if(carry==1) l.add(0,carry);
    	int[] result = new int[l.size()];
    	for (int i=0; i<l.size(); i++){
    		result[i] = l.get(i).intValue();
    	}
		return result;
    	
        
    }

	public static void main(String[] args) {
		int[] digits = {9, 9, 8};
		int[] expected = {1, 0, 0, 0};
		System.out.println(Arrays.toString(plusOne(digits)));
	}

}
