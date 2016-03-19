package hackerrank.twitter;

public class CountPrime {

	public static int solution(int n){
		return n;
		
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
//		System.out.println(4 == solution(8));
		
		
		System.out.println(isPrime(1));
		System.out.println(isPrime(10));
		System.out.println(isPrime(89));

		System.out.println(isPrime(1111));
		System.out.println(isPrime(57295729));

	}

}
