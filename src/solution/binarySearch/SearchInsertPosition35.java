package solution.binarySearch;

/**
 * https://leetcode.com/problems/search-insert-position/
 * @author yusong
 *
 */
public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
    	if (nums.length==0) return 0;
    	int start = 0, end = nums.length-1;
    	int mid = (start + end)/2;
    	while (start < end){
        	mid = (start + end)/2;
//    		System.out.println("mid :" +nums[mid]);
        	if (target <= nums[mid]){
        		end = mid - 1;

        	} else {
        		start = mid + 1; 
        	}
    	}
    	
		return (nums[start]<target)? start+1 : start;
        
    }

	public static void main(String[] args) {
		SearchInsertPosition35 test = new SearchInsertPosition35();
		int[] nums = {1,3,5,6};
		System.out.println(test.searchInsert(nums, 0));
		System.out.println(test.searchInsert(nums, 1));
		System.out.println(test.searchInsert(nums, 2));
		System.out.println(test.searchInsert(nums, 5));
		System.out.println(test.searchInsert(nums, 6));
		System.out.println(test.searchInsert(nums, 7));
	}

}
