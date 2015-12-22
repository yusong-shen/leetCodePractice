package solution;

/**
 * https://leetcode.com/problems/add-digits/
 * @author yusong
 *
 */
public class AddDigits258 {

	

    public static int addHelper(int num) {
    	int sum = 0;
    	while(num!=0){
        	int digit = num % 10;
        	sum += digit;
        	num = num / 10;
    	}
		return sum;
        
    }
	private static int addDigits(int num) {
		int sum = addHelper(num);
		if (sum<10) return sum;
		else return addDigits(sum);
	}
    
	public static void main(String[] args) {
		System.out.println(addDigits(16589));
	}



}
