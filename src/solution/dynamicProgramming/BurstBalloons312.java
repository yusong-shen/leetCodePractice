/**
 * 
 */
package solution.dynamicProgramming;

/**
 * @author yusong
 *
 */
public class BurstBalloons312 {

	public static int solution(int[] nums){
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//		coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167		
		int[] A = {3, 1, 5, 8};
		System.out.println(167 == solution(A));
	}

}
