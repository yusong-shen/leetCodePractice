/**
 * 
 */
package hackerrank.twitter;

/**
 * @author yusong
 *
 */
public class ValidNationFlag {

	public static boolean solution(int[][] A, int n, int m){

		for (int i = 0; i < n; i++){
//			boolean areRowsDifferent = false;
			for (int j = 0; j < m; j++){
				// check if a row has same color
				if (j < m - 1 && A[i][j] != A[i][j+1]){
					return false;
				}
				// check if two row has different color
				if (i < n - 1 && A[i][j] == A[i+1][j]){
					return false;
				} 
			}
			
		}
		
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A1 = { {0, 0, 0},
				{1, 1, 1},
				{2, 2, 2}
		};
		
		System.out.println(true == solution(A1, 3, 3));
		
		int[][] A2 = { {0, 0, 0},
				{0, 0, 0},
				{2, 2, 2}
		};
		
		System.out.println(false == solution(A2, 3, 3));
		
		int[][] A3 = { {0, 0, 0},
				{1, 1, 1},
				{0, 0, 2}
		};
		
		System.out.println(false == solution(A3, 3, 3));
	}

}
