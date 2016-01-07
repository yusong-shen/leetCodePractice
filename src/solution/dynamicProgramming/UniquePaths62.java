package solution.dynamicProgramming;

public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
    	// store the number of unique paths for (i+1)*(j+1) grid
    	int[][] cache = new int[m][n];
    	// Base case
    	for(int i=0; i<m; i++){
    		cache[i][0] = 1;
    	}
    	for(int j=0; j<n; j++){
    		cache[0][j] = 1;
    	}
    	// Dynamic programming
    	for(int i=0; i<m-1; i++){
    		for(int j=0; j<n-1; j++){
    			cache[i+1][j+1] = cache[i][j+1] + cache[i+1][j];
    		}
    	}
		return cache[m-1][n-1];
        
    }

	public static void main(String[] args) {

	}

}
