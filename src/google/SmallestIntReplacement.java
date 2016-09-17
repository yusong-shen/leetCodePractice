package google;

public class SmallestIntReplacement {

	public SmallestIntReplacement() {
		// TODO Auto-generated constructor stub
	}

	static int solution(int X) {
		int[] digits = getDigits(X);
		int[] result = new int[digits.length - 1];
		// brute force
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < digits.length; i++) {
			int maxIndex = (digits[i - 1] > digits[i]) ? i - 1 : i;
			// get the transformed number
			for (int j = 0; j < result.length; j++) {
				if (j == i - 1) {
					result[j] = digits[maxIndex];
				} else {
					// skip one number if j > i - 1
					result[j] = (j < i - 1)? digits[j] : digits[j + 1];
				}
			}
			int number = getInt(result);
			if (number < min) {
				min = number;
			}
		}
		return min;
	}
	
	private static int[] getDigits(int X) {
		int divider = 10;
		int numDigits = 2;
		while (X / divider >= 10) {
			divider *= 10;
			numDigits++;
		}
//		System.out.println(divider);
		int[] digits = new int[numDigits];
		for (int i = 0; i < numDigits; i++) {
			int digit = X / divider;
			X = X % divider; 
			divider /= 10;
			digits[i] = digit;
//			System.out.println(digit);
		}
		
		return digits;
	}
	
	private static int getInt(int[] digits) {
		int result = 0;
		int n = digits.length;
		for (int i = 0; i < n; i++) {
			result += digits[i] * (int) Math.pow(10, n - 1 - i);
		}
		return result;
	}
	public static void main(String[] args) {
		// X is an integer with the range [10, 1,000,000,000]
		int X = 233614;
//		getDigits(10);
//		getDigits(100);
//		getDigits(X);
//		System.out.println(getInt(getDigits(10)));
//		System.out.println(getInt(getDigits(100)));
//		System.out.println(getInt(getDigits(X)));
		System.out.println(23364 == solution(X));
		X = 23;
		System.out.println(3 == solution(X));
		X = 10;
		System.out.println(1 == solution(X));
		X = 100;
		System.out.println(10 == solution(X));	
		X = 1000000000;
		System.out.println(100000000 == solution(X));	
		X = 33333;
		System.out.println(3333 == solution(X));
		X = 17854;
		System.out.println(1784 == solution(X));
	}

}
