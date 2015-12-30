package solution.bitManipulation;

public class SingleNumberII137 {

	/**
	 * Given an array of integers, 
	 * every element appears three times except for one. 
	 * Find that single one.
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
    	int result = 0;
    	int n = nums.length;
    	// the array will be filled with 0 by default in Java
    	// use 32 size array to record the number of appear of ith bit
    	int[] count = new int[32];
    	for (int i=0; i<32; i++){
    		for (int j=0; j<n; j++){
    			// get the ith bit of nums[j]
    			if (((nums[j]>>i)&1)==1) {
    				count[i]++;
    			}
    		}
    		// since every elements appear three times except for one.
    		// count[i]%3 must be 0 and 1, which is the ith bit of single number
    		// update the ith bit
    		result |= (count[i]%3<<i);
    	}
		return result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
