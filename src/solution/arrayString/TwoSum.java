package solution.arrayString;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
    	// build a hash table
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i=0; i<nums.length; i++){
    		int k = nums[i];
    		if (map.containsKey(target-k)){
    			return new int[] {map.get(target-k)+1, i+1};
    		}
    		map.put(k, i);
    	}
    	throw new IllegalArgumentException("No two sum solution");
    	
        
    }

	public static void main(String[] args) {
//		int[] numbers={2, 7, 11, 15};
//		int target=9;
//		int[] numbers = {-1,-2,-3,-4,-5};
//	    int target=-8;
		int[] numbers = {0,4,3,0};
	    int target=7;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}

}
