package solution.arrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges163 {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
    	int n = nums.length;
    	List<String> list = new ArrayList<>();
    	if (n==0) return list;
    	if (lower==upper) {
    		list.add(Integer.toString(lower));
    		return list;
    	}
    	for (int i=0; i<n-1; i++){
    		int diff = nums[i+1]-nums[i];
    		if (diff<=1) {
    			continue;
    		} else if (diff==2){
    			list.add(Integer.toString(nums[i]+1));
    		} else {
    			String start = (nums[i]==0)?Integer.toString(lower+1):Integer.toString(nums[i]+1);
    			String end = Integer.toString(nums[i+1]-1);
    			list.add(start+"->"+end);
    		}
    	}
    	// duplicated - can be solved by add the upper to the end of nums
    	if (nums[n-1]!=upper){
    		int diff = upper - nums[n-1];
    		if (diff==2){
    			list.add(Integer.toString(nums[n-1]+1));
    		} else {
    			String start = (nums[n-1]==0)?Integer.toString(lower):Integer.toString(nums[n-1]+1);
    			String end = Integer.toString(upper);
    			list.add(start+"->"+end);
    		}    		
    	}
    	
    	
    	
		return list;
        
    }
    
    private String rangeHelper(int x, int y){
    	int diff = y - x;

    	if (diff<=1) return null;
    	if (diff==2) return Integer.toString(x+1);
    	else{
    		return Integer.toString(x+1)+"->"+Integer.toString(y+1);
    	}
    	
    }
    
	public static void main(String[] args) {
//		int[] nums1 = {0, 1, 3, 50, 75};
		int[] nums1 = {0,99};
//		List<String> expected = Arrays.asList("2", "4->49", "51->74", "76->99");
		System.out.println(Arrays.toString(findMissingRanges(nums1, 0, 99).toArray()));

	}

}
