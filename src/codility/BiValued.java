package codility;

/**
 * Similar to 159. Longest Substring with At Most Two Distinct Characters
 * @author yusong
 *
 */
public class BiValued {

	// return the size of the largest bi-valued slice in A
	public static int solution(int[] A){
		int n = A.length;
		if (n <= 2) {
			return n;
		}
		
		int[] count = new int[100];
		int maxSize = 0, numDistinct=0;
		
		// two pointers
		// j indicates the beginning of window - slow pointer
		for (int i=0, j=0; i<n; i++){
			
			if (count[A[i]]==0){
				numDistinct ++;
			}
			count[A[i]]++;
			
			// update window
			// move the slow pointer if numDistinct > 2
			while (numDistinct > 2){
				count[A[j]] --;
				if (count[A[j]]==0){
					numDistinct --;
				}
				// move the slow pointer one step at a time
				j++;
			}
			
			maxSize = Math.max(maxSize, i-j+1);
		}
		
		
		return maxSize;
		
	}

	public static void main(String[] args) {
		int[] A = {5, 4, 4, 5, 0, 12};
		// (0, 3) is slice containing only 4 and 5
		System.out.println(4 == solution(A));
		
		int[] A1 = {};
		System.out.println(0 == solution(A1));

		int[] A2 = {5, 4, 4, 4, 6, 6, 0, 12};
		System.out.println(5 == solution(A2));
		
		
		int[] A3 = {5, 5, 4, 4, 5, 4, 5};
		System.out.println(7 == solution(A3));
		
	}

}
