package solution.arrayString;

import java.util.Arrays;

public class RotateArray189 {

    public static void rotate(int[] nums, int k) {
    	if (nums == null || nums.length < 2){
    		return;
    	}
    	k = k % nums.length;
    	// first reverse entire array
    	reverse(nums, 0, nums.length);
    	// then reverse two sub arrays
    	reverse(nums, 0, k);
    	reverse(nums, k, nums.length);
	
    }

    
    /**
     * helper method to reverse given character
     * @param s
     * @param start
     * @param end
     */
	private static void reverse(int[] nums, int start, int end) {
		int temp;
		for (int i = 0; i<(end-start)/2; i++){
			temp = nums[start+i];
			nums[start+i] = nums[end-i-1];
			nums[end-i-1] = temp;
		}
	}
    
	public static void main(String[] args) {
		int k = 3;
		int[] nums = {1,2,3,4,5,6,7};
		int[] expected = {5,6,7,1,2,3,4};
		rotate(nums,k);
		System.out.println(Arrays.toString(nums));

	}

}
