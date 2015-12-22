package solution.arrayString;

import java.util.Arrays;

/**
 * Two pointer technique
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * @author yusong
 *
 */
public class RemoveDuplicates26 {

	public RemoveDuplicates26() {
		// TODO Auto-generated constructor stub
	}

    public static int removeDuplicates(int[] nums) {
    	if (nums.length==0) return 0;
    	int i = 0;
    	for (int j=0; j<nums.length; j++){
    		if (nums[i]!=nums[j]){
    			i++;
    			nums[i] = nums[j];
    		}
    	}
		return i+1;
        
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
