/**
 * 
 */
package hackerrank.twitter;

/**
 * @author yusong
 *
 */
public class SuperPower {

	public static int solution(int num){
		if (num <= 9){
			return 1;
		}
		int range = (int) Math.floor(Math.sqrt(num));
		for (int i = 2; i < range; i++){
			if (num % i == 0){
				while (num > 1){
					if (num % i > 0){
						// have some other divider
						return 0;
					}
//					System.out.println(num);
					num /= i;
				}
				return 1;
			}
		}
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(1 == solution(2));
		System.out.println(0 == solution(26));
		System.out.println(0 == solution(126));
		System.out.println(0 == solution(39));
		System.out.println(0 == solution(353));

		System.out.println(1 == solution(1));
		System.out.println(1 == solution(9));
		System.out.println(1 == solution(16));
		System.out.println(1 == solution(125));

	}

}
