package solution.binarySearch;

public class SearchInRotatedArray33 {

    public int search(int[] nums, int target) {
    	int left = 0, right = nums.length-1;
    	while(left<right){
    		int mid = left + (right-left)/2;
    		if(nums[mid]<nums[right]){
    			right = mid;
    		} else {
    			left = mid + 1;
    		}
    	}
    	int idxMin = left;
//    	System.out.format("The value of idxMin is: %d%n", idxMin);    	
    	// binary search two sub array
    	int lResult = binarySearch(nums, target, 0, idxMin);
    	int rResult = binarySearch(nums, target, idxMin, nums.length-1);
//    	System.out.println("l: "+lResult);
//    	System.out.println("r: "+rResult);
    	if (lResult==-1&&rResult==-1) return -1;
    	else if (lResult==-1) return rResult;
    	else return lResult;
        
    }
    
    private int binarySearch(int[] nums, int target, int left, int right){
    	if (right < left){
    		return -1;
    	} else{
	    	int mid = left + (right-left)/2;
	    	if (nums[mid]==target) {
	    		return mid;
	    	}
	    	else if (nums[mid]<target){
	    		return binarySearch(nums, target, mid+1, right);
	    	} else {
	    		return binarySearch(nums, target, left, mid-1);
	    	}
    	}
    }

	public static void main(String[] args) {
		SearchInRotatedArray33 test = new SearchInRotatedArray33();
		int[] nums = {4, 5, 6, 7, 0, 1, 2}; 
		System.out.println(test.search(nums, 4));
		System.out.println(test.search(nums, 7));
		System.out.println(test.search(nums, 0));
		System.out.println(test.search(nums, 2));
		System.out.println(test.search(nums, 20));


				
	}

}
