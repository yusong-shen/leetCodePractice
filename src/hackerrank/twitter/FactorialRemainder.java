/**
 * 
 */
package hackerrank.twitter;

/**
 * @author yusong
 *
 */
public class FactorialRemainder {

    static int factorialRemainder(int n) {
        int count = 0;
        for (int i = 1 ; i <= n; i++){
            if (isPrime(i)){
                count ++;
            }
        }
        return count;
    }

    static boolean isPrime(int n){
        // should be O(sqrt(n))
		if (n <= 3){
			return true;
		}
		if (n % 2 == 0){
			return false;
		}
		if (n % 3 == 0){
			return false;
		}
		
		int range = (int) Math.sqrt(n);
		
		int i = 5, d = 2;
		while (i <= range){
			if (n % i == 0){
				return false;
			}
			
			i += d;
			d = 6 - d;
		}
		
		return true;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
