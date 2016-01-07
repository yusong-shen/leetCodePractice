package solution.dynamicProgramming;



public class ClimbingStairs {

	
    public int climbStairs(int n) {
    	// base case check
    	if (n==1){
    		return 1;
    	}
    	if (n==2){
    		return 2;
    	}
    	// steps : index+1 
    	// chache[steps-1] : number of distinct ways
    	int[] cache = new int[n];
    	// base case
    	cache[0] = 1;
    	cache[1] = 2;
    	// dynamic programming
    	for(int i=2; i<n; i++){
    		cache[i] = cache[i-1]+cache[i-2];
    	}
		return cache[n-1];
        
    }

	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		System.out.println(test.climbStairs(1));
		System.out.println(test.climbStairs(2));
		System.out.println(test.climbStairs(3));
		System.out.println(test.climbStairs(4));

	}

}
