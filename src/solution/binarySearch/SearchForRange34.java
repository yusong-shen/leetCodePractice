package solution.binarySearch;

import java.util.Arrays;

public class SearchForRange34 {
	
    public int[] searchRange(int[] nums, int target) {
    	int[] range = new int[]{-1,-1};
    	int l = 0, r = nums.length-1;
		boolean found = false;
		int pos = 0;
		// search for the target
    	while(l<=r){
    		int mid = l + (r-l)/2;
    		if (target==nums[mid]){
    			found = true;
    			pos = mid;
    			break;
    		}
    		else if (target < nums[mid]){
    			r = mid - 1;
    		} else {
    			l = mid + 1;
    		}
    	}
    	if (!found) return range;
		// search for the left border
    	l = 0;
    	r = pos;
    	while(l<=r){
    		int mid = l + (r-l)/2;
//    		System.out.println("left mid:" + mid);
    		if (nums[mid]==target){
    			r = mid-1;
    		} else {
    			l = mid+1;
    		}
    	}
    	range[0] = l;
    	// search for the right border
    	r = nums.length - 1;
    	l = pos;
    	while(l<=r){
    		int mid = l + (r-l)/2;
//    		System.out.println("right mid:" + mid);
    		if (nums[mid]==target){
    			l = mid+1;
    		} else {
    			r = mid-1;
    		}
    	}
    	range[1] = r;    	
		return range;
        
    }

	public static void main(String[] args) {
		int[] nums = new int[]{5,7,7,8,8,10};
		SearchForRange34 test = new SearchForRange34();
		System.out.println(Arrays.toString(test.searchRange(nums, 5)));
		System.out.println(Arrays.toString(test.searchRange(nums, 7)));
		System.out.println(Arrays.toString(test.searchRange(nums, 8)));
		System.out.println(Arrays.toString(test.searchRange(nums, 10)));
		System.out.println(Arrays.toString(test.searchRange(nums, 9)));


	}

}
