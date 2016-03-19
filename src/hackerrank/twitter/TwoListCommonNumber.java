/**
 * 
 */
package hackerrank.twitter;

/**
 * @author yusong
 *
 */
public class TwoListCommonNumber {

	
	public static int solution(int a0, int d, int b0, int q, int max){
		int count = 0;
		// geometry sequence
		int b = b0;
		
		if (q == 0){
			if ( d == 0 && (a0 == b0)){
				return 1;
			} 
			if ( d!=0 && (a0 - b0) % d == 0){
				return 1;
			}
		}
		
		if (q == 1){
			if (d != 0 && (b - a0) % d == 0){
				return 1;
			} else if (d == 0 && a0 == b0){
				return 1;
			} else {
				return 0;
			}
		} 
		
		// q = -1
		if (q == -1){
			// d == 0
			if (d == 0){
				if(b0 >= a0 || b0 >= -a0){
					count ++;
				}
			} 
			// d != 0
			else {
				if((b0 - a0) % d == 0 && b0 >= a0 ){
					count ++;
				}	
				
				if((-b0 - a0) % d == 0 && -b0 >= a0 ){
					count ++;
				}
			}
			
			return count;
		}
		
		// d = 0 && q!= +- 1
		if (d == 0){
			while (b <= max){
				if (b == a0){
					return 1;
				}
				b *= q;
			}
			return 0;
		}
		
		
		// q > 1
		while ( b <= max){
			if ((b - a0) % d == 0){
				count += 1;
//				System.out.println(b);
			}
			
			b *= q;
			
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1, 2, 3, 4
		// 1, 2, 4, 8...
		// common : 1, 2, 4
		System.out.println(solution(1, 1, 1, 2, 9));
		System.out.println(4 == solution(1, 1, 1, 2, 9));
		
		System.out.println(1 == solution(1, 0, 1, 0, 9));

		System.out.println(1 == solution(1, 0, 1, 1, 9));
		
		System.out.println(1 == solution(1, 1, 1, 0, 9));
		
		System.out.println(0 == solution(2, 0, 1, 3, 9));

		System.out.println(2 == solution(-3, 2, 1, -1, 9));

		System.out.println(solution(1, 2, 1, -1, 9));
		System.out.println(1 == solution(1, 2, 1, -1, 9));

	}

}
