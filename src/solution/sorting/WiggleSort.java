package solution.sorting;

import java.util.Arrays;

/**
 * 
 * @author yusong
 *
 */
public class WiggleSort {

//    public void wiggleSort(int[] nums) {
//    	Arrays.sort(nums);
//    	for(int i=1; i< nums.length-1; i+=2){
//    		swap(nums, i, i+1);
//    	}
//        
//    }
	
	public void wiggleSort(int[] nums){
		int[] temp = Arrays.copyOf(nums, nums.length);
		Arrays.sort(temp);
		int j=temp.length-1;

		// odd index
		for(int i=1; i<nums.length; i+=2){
			nums[i] = temp[j];
//			System.out.println(j);
			j--;
		}
		// even index
		for(int i=0; i<nums.length; i+=2){
			nums[i] = temp[j];
//			System.out.println(j);
			j--;
		}
	}

    private void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
	public static void main(String[] args) {
//		int[] nums = {3,5,2,1,6,4};
//		int[] nums = {1,5,1,1,6,4};
		int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
		WiggleSort test = new WiggleSort();
		test.wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
