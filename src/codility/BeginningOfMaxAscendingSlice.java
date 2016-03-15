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
		return 0;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
		System.out.println(4 == solution(A) 
				|| 6 == solution(A) 
				|| 8 == solution(A));
		
	}

}
