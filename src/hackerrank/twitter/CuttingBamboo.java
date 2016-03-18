/**
 * 
 */
package hackerrank.twitter;

/**
 * @author yusong
 *
 */
public class CuttingBamboo {

	public static int[] solution(int[] nums){
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums  = {3, 2, 3, 4, 5, 2};
		int[] expected = {6, 4, 2, 1};
//		3 2 3 4 5 2  (最短是2，所有棍子都砍2，一共能砍6个棍子)
//		1 _ 1 2 3 _  (最短是1，所有棍子都砍1，一共能砍4个棍子)
//		_ _ _ 1 2 _  (最短是1，所有棍子都砍1，一共能砍2个棍子)
//		_ _ _ _ 1 _  (最短是1，所有棍子都砍1，一共能砍1个棍子). 
//		_ _ _ _ _ _ (没了)		
		System.out.println(solution(nums));
	}

}
