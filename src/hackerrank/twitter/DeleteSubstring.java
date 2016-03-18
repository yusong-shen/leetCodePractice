/**
 * 
 */
package hackerrank.twitter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yusong
 *
 */
public class DeleteSubstring {

	/**
	 *  Greedy
	 * @param s
	 * @param t
	 * @return
	 */
 //	public static int solution(String s, String t){
//		if(t.length() == 0){
//			return 0;
//		}
//		int count = 0, preIndex = 0;
//		while(s.length() >= t.length()){
//			int index = s.indexOf(t, preIndex - t.length());
//			if(index == -1){
//				break;
//			}else{
//			s = s.substring(0, index) + s.substring(index + t.length());
//				count ++;
//				preIndex = index;
//			}
//		}
//		return count;
//	}

	static Map<String, Integer> m = new HashMap<>();
	
	public static int solution(String s, String t){
	    int ret = 0;
	    int idx = s.indexOf(t, 0);
	    while (idx >= 0) {
	      String ss = s.substring(0, idx) + s.substring(idx + t.length());
	      if (m.containsKey(ss)) {
	        ret = Math.max(ret, 1 + m.get(ss));
	      } else {
	        int r = solution(ss, t);
	        ret = Math.max(ret, 1 + r);
	      }
	      idx = s.indexOf(t, idx + 1);
	    }
	    m.put(s, ret);
	    return ret;
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
