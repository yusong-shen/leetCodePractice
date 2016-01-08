package solution.dynamicProgramming;

public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
    	// check edge case
    	if (nums.length==0){
    		return Integer.MIN_VALUE;
    	}
    	// keep track of the max sum of subarray the end at index i
    	int maxEndHere = 0;
    	// keep track the global max sum
    	int max = Integer.MIN_VALUE;
    	for (int i=0; i<nums.length; i++){
    		maxEndHere = Math.max(maxEndHere + nums[i], nums[i]);
    		max = Math.max(max, maxEndHere);
    	}
		return max;
        
    }

	public static void main(String[] args) {
		MaximumSubarray53 test = new MaximumSubarray53();
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(test.maxSubArray(nums));
		
	}

}
