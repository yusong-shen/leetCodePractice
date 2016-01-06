package solution.binarySearch;

public class FisrtBadVersion276 {

	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */

	boolean isBadVersion(int version) {
		return false;
	}
	
    public int firstBadVersion(int n) {
    	if (n<1) return -1;
    	int l=1, r=n;
    	while(l < r){
    		int mid = l + (r-l)/2;
    		// good version
    		if (!isBadVersion(mid)){
    			l = mid + 1;
    		} 
    		// bad version
    		else {
    			r = mid;
    		}

    	}
    	// it will stop 
		return l;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
