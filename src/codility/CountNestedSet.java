package codility;

/**
 * Array has N integers，range[0...N-1]。Set S[k], 0 <= K < N as S[K] = {A[K], A[A[K]], A[A[A[K]]],....},
 *	write a function returns the size of the largest set S[K] for this array. return 0 if empty.. more info on 1point3acres.com
 *	ex:
 *	A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2
 *	return 4 because S[2] equals {0, 5, 6, 2} 4 elements
 * @author yusong
 *
 */
public class CountNestedSet {

	/* Brute Force*/
//	public static int solution(int[] A){
//		int n = A.length;
//		
//		if(n <= 0){
//			return 0;
//		}
//		
//		int maxSet = 1, count =0;
//		int j = 0, index = 0;
//		// brute force
//		for (int i=0; i<n; i++){
//			index = i;
//			while(A[index] >= 0){
//				count ++;
//				j = index;
//				index = A[index];
//				// mark it as visited to avoid infinite loop
//				A[j] = -1;
//			}
//			
//			maxSet = count > maxSet ? count : maxSet ;
//			count = 0;
//		}
//		
//		
//		return maxSet;
//	}

	
	public static int[] M;
	/*
	 * keep track if computed
	 */
	public static int[] flag;
	/**
	 * Helper function 
	 * based on sizeCount(i)=1+sizeCount(a[i])
	 * @param A
	 * @param M
	 * @param i
	 * @param len
	 * @return
	 */
	public static int sizeCount(int[] A, int i, int len){
		int count = 1;
		int j = A[i];
		flag[i] = 1;
		
		if (j < len && j >=0){
			if (M[j] == 0 && flag[j]==0){
				count = 1 + sizeCount(A, j, len);
			}
			else if (M[j] == 0 && flag[j]==1)
			{
				count = 1;
				M[j] = 1;			
			}
			else {
				count = 1 + M[j];
			}
		}
		
		M[i] = count;
		return count;
	}
	
	/**
	 * Recursion with cache
	 * @param A
	 * @return
	 */
	public static int solution(int[] A){
		int n = A.length;
		
		if(n <= 0){
			return 0;
		}
		
		int maxSet = 0;
		M = new int[n];
		flag = new int[n];

		for (int i=0; i<n; i++){
			
			if(M[i] == 0){
				M[i] = sizeCount(A, i, n);
				if (M[i] > maxSet){
					maxSet = M[i];
				}
				
			}
		}
		
		
		return maxSet;
	}
	
	public static void main(String[] args) {
		int[] A = {5, 4, 0, 3, 1, 6, 2};
		System.out.println(4 == solution(A));
	}

}
