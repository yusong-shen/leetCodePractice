package solution.bitManipulation;

import java.util.Arrays;

public class SingleNumberIII260 {

	/**
	 * Given an array of numbers nums, 
	 * in which exactly two elements appear only once 
	 * and all the other elements appear exactly twice. 
	 * Find the two elements that appear only once.
	 * For example:
	 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	 * @param nums
	 * @return
	 */
    public int[] singleNumber(int[] nums) {
    	int sum = 0;
    	int[] result = new int[2];
    	// XOR all the numbers
    	// sum must have some bit as 1, 
    	// which means A and B differ in this position
    	for (int i : nums){
    		sum ^= i;
    	}
    	// pick any different bit
    	// here we just pick the highest 1 bit as partition bit
    	int diff = Integer.highestOneBit(sum);
    	
    	// partition all the numbers to two groups according to highest 1 bit
    	for(int j : nums){
    		// all the numbers that has 1 in highest one bit as first group
    		// XOR inside the group to get A
    		// similarly to get B
    		if ((j&diff)==0){
    			result[0] ^= j;
    		} else{
    			result[1] ^= j;
    		}
    	}
    	
		return result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
