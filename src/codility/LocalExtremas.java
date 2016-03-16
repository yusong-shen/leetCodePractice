/**
 * 
 */
package codility;

import java.util.HashSet;

/**
 * @author yusong
 *
 */
public class LocalExtremas {

	public static int solution(int[] A){
		int n = A.length;
		if (n == 0){
			return 0;
		}
		if (n == 1){
			return 1;
		}
		
		HashSet<Integer> set = new HashSet<>();
		// first and last element are always local extremas
		set.add(A[0]);
		set.add(A[n-1]);
		// two pointers
		// use j to indicate the beginning of contiguous sequence
		// i current pointer
		for (int i=1, j=1; i<n-1; i++){
			
			
			
			// local minimum
			if (A[i]<A[j-1] && A[i]<A[i+1]){
				set.add(A[i]);
			}
			// local maximum
			if (A[i]>A[j-1] && A[i]>A[i+1]){
				set.add(A[i]);
			}
			
			// update the beginning of sequence
			if (A[i]!=A[i-1]){
				j = i;
			}
			
		}
		
		return set.size();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = { 2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
		System.out.println(solution(A));
		System.out.println(4 == solution(A));
		
		int[] A1 = {};
		System.out.println(0 == solution(A1));
		
		int[] A2 = {2, 2};
		System.out.println(1 == solution(A2));
		
		int[] A3 = {2, 3};
		System.out.println(2 == solution(A3));
	}

}
