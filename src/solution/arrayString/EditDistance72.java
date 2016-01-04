package solution.arrayString;

public class EditDistance72 {

	/**
	 * Dynamic Programming
	 * @param word1
	 * @param word2
	 * @return
	 */
    public int minDistance(String word1, String word2) {
    	int n = word1.length();
    	int m = word2.length();
    	int[][] dp = new int[n+1][m+1];
    	// Base case
    	for (int i=0; i<=n; i++) dp[i][0]=i;
    	for (int j=0; j<=m; j++) dp[0][j]=j;
    	// DP
    	for (int i=0; i<n; i++){
    		char c = word1.charAt(i);
    		for (int j=0; j<m; j++){
    			char d = word2.charAt(j);
    			if (c==d){
    				dp[i+1][j+1] = dp[i][j];
    			} else {
    				int delete = dp[i+1][j]+1;
    				int append = dp[i][j+1]+1;
    				int replace = dp[i][j]+1;
    				dp[i+1][j+1] = Math.min(Math.min(delete, append), replace);
    			}
    		}
    	}
		return dp[n][m];
    }
//    
//    /**
//     * 
//     * @param word1
//     * @param word2
//     * @param i check the first ith character in word1
//     * @param j check the first jth character in word2
//     * @return
//     */
//    private int minDistanceHelper(String word1, String word2, int i, int j){
//    	// Base case
//    	if (i==0) return j;
//    	if (j==0) return i;
//    	// Recursion
//    	if (word1.charAt(i-1)==word2.charAt(j-1)){
//    		return minDistanceHelper(word1, word2, i-1, j-1);
//    	} else {
//    		return Math.min(Math.min(minDistanceHelper(word1, word2, i, j-1), 
//    				minDistanceHelper(word1, word2, i-1, j)),
//    				minDistanceHelper(word1, word2, i-1, j-1))+1;
//    	}
//    	
//    }

	public static void main(String[] args) {
		EditDistance72 test = new EditDistance72();
		String word1 = "hello";
		String word2 = "hillu!";
		System.out.println(test.minDistance(word1, word2));
	}

}
