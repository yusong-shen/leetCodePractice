package hackerrank.twitter;

import java.util.Arrays;

public class FirstReaptingLetter {

	public static int solution(String s) {
		int[] map = new int[256];
		Arrays.fill(map, -1);
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
//			System.out.println(min);
			
			if (map[ch] == -1){
				map[ch] = i;
			} 
			// encounter repeat letter
			else{
				min = Math.min(map[ch], min);
			}
		}
		
		
		return 	(min == Integer.MAX_VALUE) ? -1 : min;

	}

	public static void main(String[] args) {
		String s1 = "abcba";
		System.out.println(solution(s1));
		System.out.println(0 == solution(s1));
		
	}

}
