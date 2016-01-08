package solution.dynamicProgramming;

public class MaximumProductSubarray153 {

    public int maxProduct(int[] nums) {
    	// keep track of the max and min product of subarray the end at index i
    	// since min negative product is also potential a max product
    	// if it times a negative number.
    	int maxEndHere = nums[0];
    	int minEndHere = nums[0];
    	// keep track the global max sum
    	int max = nums[0];
    	for (int i=1; i<nums.length; i++){
    		// store the previous maxEndHere and minEndHere
    		int maxEndHerePrev = maxEndHere;
    		int minEndHerePrev = minEndHere;
    		maxEndHere = Math.max(Math.max(maxEndHerePrev * nums[i], 
    				nums[i]),
    				minEndHerePrev * nums[i]);
    		minEndHere = Math.min(Math.min(maxEndHerePrev * nums[i],
    				nums[i]),
    				minEndHerePrev * nums[i]);
    		max = Math.max(max, maxEndHere);
    	}
		return max;
        
    }
    
    
	public static void main(String[] args) {
		MaximumProductSubarray153 test = new MaximumProductSubarray153();
		int[] nums = {-2, 1, -3, 4, -1, 0, 2, 1, -5, 4};
		System.out.println(test.maxProduct(nums));

	}

}
