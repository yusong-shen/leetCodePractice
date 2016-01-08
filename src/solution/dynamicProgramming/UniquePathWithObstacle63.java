package solution.dynamicProgramming;

public class UniquePathWithObstacle63 {

	/**
	 * bottom-up dynamic programming
	 * @param obstacleGrid
	 * @return
	 */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] dp = new int[m+1][n+1];
    	// Base Case
    	dp[m-1][n] = (obstacleGrid[m-1][n-1]==0)? 1 : 0;
    	for(int i=m-1; i>=0; i--){
    		for(int j=n-1; j>=0; j--){
    			if(obstacleGrid[i][j]==1){
    				dp[i][j] = 0;
    			} else{
    	    		dp[i][j] = dp[i+1][j] + dp[i][j+1];    				
    			}
    		}
    	}

    	return dp[0][0];
    }

	public static void main(String[] args) {

	}

}
