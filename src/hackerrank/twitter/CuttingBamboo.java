/**
 * 
 */
package hackerrank.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yusong
 *
 */
public class CuttingBamboo {

	public static List<Integer> solution(int[] nums){
		List<Integer> result = new ArrayList<Integer>();
		// sort the array first
		Arrays.sort(nums);
		
		int n = nums.length, curr = 0;
		for (int i = 0; i < n; i++){
			if (curr < nums[i]){
				result.add(nums.length - i);
				curr = nums[i];
			}
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums  = {3, 2, 3, 4, 5, 2};
		int[] expected = {6, 4, 2, 1};
//		3 2 3 4 5 2  (最短是2，所有棍子都砍2，一共能砍6个棍子)
//		1 _ 1 2 3 _  (最短是1，所有棍子都砍1，一共能砍4个棍子)
//		_ _ _ 1 2 _  (最短是1，所有棍子都砍1，一共能砍2个棍子)
//		_ _ _ _ 1 _  (最短是1，所有棍子都砍1，一共能砍1个棍子). 
//		_ _ _ _ _ _ (没了)		
		System.out.println(solution(nums));
	}

}
