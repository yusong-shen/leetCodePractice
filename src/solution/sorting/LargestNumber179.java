/**
 * 
 */
package solution.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/
 * @author yusong
 *
 */
public class LargestNumber179 {

    public String largestNumber(int[] nums) {
        if (nums == null){
            return null;
        }
        
        if (nums.length == 0){
            return "0";
        }
        
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums){
            numsList.add(num);
        }
        
        Collections.sort(numsList, new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2){
                String s1 = "" + num1 + num2;
                String s2 = "" + num2 + num1;
                return s2.compareTo(s1);
            }
        });
        
        StringBuilder str = new StringBuilder();
        for (int num : numsList){
            str.append(num);
        }
        
        // edge case
        if (str.charAt(0) == '0'){
            return "0";
        }
        
        return str.toString();
    }


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
