package solution.bitManipulation;

public class SingleNumber136 {

	/**
	 * One pass without extra space
	 * By using XOR
	 * @param nums
	 * @return
	 */
    public int singleNumber(int[] nums) {
    	int target = 0;
    	// a^0=a, a^1=~a
    	// since a^a=0, all the duplicate pair will disappear
    	// only the single number will remain
    	for (int i=0; i<nums.length; i++){
    		target ^= nums[i];
    	}
		return target;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
