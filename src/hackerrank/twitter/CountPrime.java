package hackerrank.twitter;

public class CountPrime {

	public static int solution(int n){
		// Euler's totient function 
		// e.g n = p1^k1 * p2*k2 ...
		// phi(n) = p1^(k1-1) * (p1 - 1) * p2^(k2-1) * (p2 - 1)...
		// phi(72) = phi(2^3 * 3^2) = 2^(3-1) * (2-1) * 3 ^(2-1) * (3-1) = 24
	    int result = 1;
	    for (int i = 2; i * i <= n; i++)
	    {	
	    	// get p_i
	        if (n % i == 0)
	        {
	            n /= i;
	            // (p_i - 1)
	            result *= i - 1;
	            // get k_i
	            // compute p_i^(k_i-1)
	            while (n % i == 0)
	            {
	                n /= i;
	                result *= i;
	            }
	        }
	    }
	    // the remaining n is prime
	    if (n > 1)
	    {
	    	result *= n - 1;
	    }
	 
	    return result;
	}
	
	public static boolean isPrime(int n){
		if (n == 2){
			return true;
		}
		if (n == 3){
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

	public static void main(String[] args) {
		// 1, 3, 5, 7 ==> 4
		System.out.println(4 == solution(8));
		
		
		System.out.println(isPrime(1));
		System.out.println(isPrime(10));
		System.out.println(isPrime(89));

		System.out.println(isPrime(1111));
		System.out.println(isPrime(57295729));

	}

}
