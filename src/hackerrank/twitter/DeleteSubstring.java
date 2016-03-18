/**
 * 
 */
package hackerrank.twitter;

/**
 * @author yusong
 *
 */
public class DeleteSubstring {

	/**
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static int solution(String s, String t){
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "aabcbdc";
		String t1 = "abc";
		System.out.println(1 == solution(s1, t1));
		
		String s2 = "aabb";
		String t2 = "ab";
		System.out.println(2 == solution(s2, t2));
		
		String s3 = "bababbbab";
		String t3 = "bab";
		System.out.println(3 == solution(s3, t3));
 	}

}
