package coursera;
import java.util.*;

public class MagicBinaryNumber {

	private static HashMap<String, Boolean> magicTable = new HashMap<>();
	private static TreeSet<String> magicStrSet = new TreeSet<>();

    static boolean isMagical(String str) {
    	if (magicTable.containsKey(str)) {
    		return magicTable.get(str);
    	}
        int n = str.length();
        if (n % 2 == 1) {
        	magicTable.put(str, false);
            return false;
        }
        int count = 0;
        // first condition : check if #1 == #0
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        if (count != n - count) {
        	magicTable.put(str, false);
            return false;
        }
        // check each prefix
        for (int i = 1; i < n; i++) {
            String prefix = str.substring(0, i);
            int numOnes = 0;
            for (int j = 0; j < prefix.length(); j++) {
                if (prefix.charAt(j) == '1') {
                    numOnes++;
                }
            }
            // second condition
            if (numOnes < prefix.length() - numOnes) {
            	magicTable.put(str, false);
                return false;
            }
        }
        magicTable.put(str, true);
        return true;
    }

    static void searchMagical(String str) {
//        System.out.println(str);
        magicStrSet.add(str);
        int n = str.length();
        // try every combination
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j; k < n; k++) {
                    // i to j - 1
                    String sub1 = str.substring(i, j);
                    // j to k - 1
                    String sub2 = str.substring(j, k);
                    String swapedStr = "";
                    if (!isMagical(sub1) || !isMagical(sub2)) {
                        continue;
                    } else {
                       // swap two substrings
                       swapedStr = str.substring(0,i) + sub2 + sub1 + str.substring(k);
                       if (!isMagical(swapedStr) || magicStrSet.contains(swapedStr)) {
                    	   continue;
                       } else {
                    	   searchMagical(swapedStr);
                       }
                    }
                }
            }
        }        
    }
    
    static String largestMagical(String str) {
//        System.out.println(isMagical(str));
    	magicStrSet = new TreeSet<>();
    	searchMagical(str);
        String maxStr = magicStrSet.last();
        return maxStr;
    }


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test 0
		String str = "11011000";
		String expected = "11100100";
		System.out.println(expected.equals(largestMagical(str)));
		// test 1
		System.out.println(largestMagical("1100"));
		expected = "1100";
		System.out.println(expected.equals(largestMagical("1100")));
		// test 2
		System.out.println(largestMagical("1101001100"));
		expected = "1101001100";
		System.out.println(expected.equals(largestMagical("1101001100")));

	}

}
