package solution.arrayString;

public class EditDistance72 {

	/**
	 * Dynamic Programming
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
		return minDistanceHelper(word1, word2, word1.length(), word2.length());
    }
    
    /**
     * 
     * @param word1
     * @param word2
     * @param i check the first ith character in word1
     * @param j check the first jth character in word2
     * @return
     */
    private int minDistanceHelper(String word1, String word2, int i, int j){
    	// Base case
    	if (i==0) return j;
    	if (j==0) return i;
    	// Recursion
    	if (word1.charAt(i-1)==word2.charAt(j-1)){
    		return minDistanceHelper(word1, word2, i-1, j-1);
    	} else {
    		return Math.min(Math.min(minDistanceHelper(word1, word2, i, j-1), 
    				minDistanceHelper(word1, word2, i-1, j)),
    				minDistanceHelper(word1, word2, i-1, j-1))+1;
    	}
    	
    }

	public static void main(String[] args) {
		EditDistance72 test = new EditDistance72();
		String word1 = "hello";
		String word2 = "hillu!";
		System.out.println(test.minDistance(word1, word2));
	}

}
