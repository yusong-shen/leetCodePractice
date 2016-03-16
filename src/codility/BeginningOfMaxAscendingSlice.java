/**
 * 
 */
package codility;

/**
 * @author yusong
 *
 */
public class BeginningOfMaxAscendingSlice {

	// return the beginning of any ascending slice of A
	// of maximal size
	public static int solution(int[] A){
		int n = A.length;
		if (n<=1){
			return 0;
		}
		int maxSize = 0, maxInd=0;
		
		// two pointers
		// j - slow pointer
		for (int i=1, j=1; i<n; i++){
			if (A[i] <= A[i-1]){
				j = i;
			}
			if (i-j+1 >= maxSize){
				maxSize = i -j + 1;
				maxInd = j;
			}
		}
		
		return maxInd;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
		System.out.println(solution(A));
		System.out.println(4 == solution(A) 
				|| 6 == solution(A) 
				|| 8 == solution(A));
		
	}

}
