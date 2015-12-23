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

    /**
     * when the input array is sorted
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
    	for (int i =0; i<nums.length; i++){
    		int x = nums[i];
    		int ind = search(nums, target-x, i+1);
    		if (ind!=-1)
    			return new int[] {i+1, ind+1};
    			
    	}
    	throw new IllegalArgumentException("No two sum solution");
    	
        
    }
    
    /**
     * Binary search
     * @param nums sorted array
     * @param target
     * @return
     */
	public static int search(int[] nums, int target, int start) {
		int l = start;
		int h = nums.length-1;
		while(l<=h){
			int m = l+(h-l)/2;
			if (nums[m]==target) return m;
			if (nums[m]<target) l=m+1;
			if (nums[m]>target) h=m-1;
		}
		return -1;		
	}

	public static void main(String[] args) {
//		int[] numbers={2, 7, 11, 15};
//		int target=9;
//		int[] numbers = {-1,-2,-3,-4,-5};
//	    int target=-8;
		int[] numbers = {0,4,3,0};
	    int target=0;
	    System.out.println(search(numbers, target, 1));
		System.out.println(Arrays.toString(twoSum2(numbers, target)));
		int[] nums1 = {2, 7, 11, 15, 17, 19};
		int t = 2;
		System.out.println(search(nums1, t, 0));
		
	}

}
