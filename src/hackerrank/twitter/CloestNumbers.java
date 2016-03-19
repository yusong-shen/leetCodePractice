package hackerrank.twitter;

import java.util.*;

public class CloestNumbers {

    static String closestNumbers(int len, String s) {
        String[] strList = s.split(" ");
        long[] numList = new long[len];
        ArrayList<Integer> pairsIndex = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < len; i++){
            numList[i] = Long.parseLong(strList[i]);
            // System.err.println(numList[i]);
        }
        // O(nlogn)
        Arrays.sort(numList);
        long minDiff = Long.MAX_VALUE;
        // find the min difference
        for(int i = 0; i < len - 1; i++){
            // System.err.println(numList[i]);
            long diff = Math.abs(numList[i] - numList[i+1]);
            if (diff <= minDiff){
                minDiff = diff;
            }
            
        }        

        // output
        for(int i = 0; i < len - 1; i++){
            // System.err.println(numList[i]);
            long diff = Math.abs(numList[i] - numList[i+1]);
            if (diff == minDiff){
               
                result.append(numList[i]);
                result.append(" ");
                result.append(numList[i + 1]);
                result.append(" ");

            }
            
        } 
        return result.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
