package solution.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges163 {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	int n = nums.length;
    	List<String> list = new ArrayList<>();
    	int prev = lower;
    	for (int i=0; i<=n; i++){
    		int curr = (i==n)? upper+1:nums[i];
    		if (curr-prev>=2){
    			String range = rangeHelper(prev+1,curr-1);
    			list.add(range);
    		}
    		prev = curr;
    	}
    	
		return list;
        
    }
    
    private static String rangeHelper(int from, int to){
    	return (from==to)? Integer.toString(from): from + "->" + to;
    	
    }
    
	public static void main(String[] args) {
//		int[] nums1 = {0, 1, 3, 50, 75};
		int[] nums1 = {0,99};
//		List<String> expected = Arrays.asList("2", "4->49", "51->74", "76->99");
		System.out.println(Arrays.toString(findMissingRanges(nums1, 0, 99).toArray()));

	}

}
