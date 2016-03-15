/**
 * 
 */
package codility;

/**
 * @author yusong
 *
 */
public class DecimalZip {

	public static int decimalZip(int A, int B){
		
		int dividerA = 1, dividerB = 1; 
		int result = 0;
		
		// deal with corner case
		if(A == 0){
			return (B>100000000)? -1 : B;
		}
		
		
		while(A / dividerA >= 10){
			dividerA *= 10;
		}
		
		if(B == 0){
			int digit = A / dividerA;
			result = digit*dividerA*10 + (A%dividerA);
			return (result > 100000000)? -1 : result;
		}
		
		if(dividerA > 100000000) return -1;
		
		while(B / dividerB >= 10){
			dividerB *= 10;
		}	
		if(dividerB > 100000000) return -1;
		
		while(A > 0 && B > 0){
			int digitA = A / dividerA;
			int digitB = B / dividerB;
			result += digitA*dividerA*dividerB*10;
			result += digitB*dividerA*dividerB;
			if(result > 100000000) return -1;
			// update A and B
			A = A % dividerA;
			dividerA /= 10;
			B = B % dividerB;
			dividerB /= 10;
		}
		if (A == 0 ){
			result += B;
		} else if ( B== 0){
			result += A;
		}
		
		
		return (result > 100000000)? -1 : result;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int A = 12345 ;
		int B = 678 ;
		int expected = 16273845 ;
		int result = decimalZip(A, B);
		System.out.println(result);
		System.out.println(result == expected);
		
		int A2 = 1234 ;
		int B2 = 0 ;
		int expected2 = 10234 ;
		int result2 = decimalZip(A2, B2);
		System.out.println(result2);
		System.out.println(result2 == expected2);

		int A3 = 0 ;
		int B3 = 1234 ;
		int expected3 = 1234 ;
		int result3 = decimalZip(A3, B3);
		System.out.println(result3);
		System.out.println(result3 == expected3);
		
		int A4 = 200000 ;
		int B4 = 22340000 ;
		int expected4 = -1 ;
		int result4 = decimalZip(A4, B4);
		System.out.println(result4);
		System.out.println(result4 == expected4);
		
	}

}
