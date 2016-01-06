package solution.binarySearch;

public class FindMinInRotatedArray153 {

    public int findMin(int[] nums) {
		return binarySearch(nums, 0, nums.length-1);
        
    }
    
    private int binarySearch(int[] nums, int left, int right){
    	if (left==right) return nums[left];
    	if (right-left==1) return Math.min(nums[left], nums[right]);
    	// sorted
    	if (nums[left]<nums[right]) return nums[left];
    	int mid = left + (right - left)/2;
    	
    	// go right hand side
    	if (nums[mid] < nums[left]){
    		return binarySearch(nums, left, mid);
    	}
    	// go left hand side
    	else if (nums[mid] > nums[left]){
    		return binarySearch(nums, mid, right);
    	}
    	// min == left, eliminate left 
    	else {
    		return binarySearch(nums, left+1, right);
    	}
    	
    }

	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2}; // expected 0
		FindMinInRotatedArray153 test = new FindMinInRotatedArray153();
		System.out.println(test.findMin(nums)); 
	}

}
