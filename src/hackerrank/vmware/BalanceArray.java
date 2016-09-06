/**
 * 
 */
package hackerrank.vmware;

/**
 * @author yusong
 *
 */
public class BalanceArray {

	/**
	 * 
	 */
	public BalanceArray() {
		// TODO Auto-generated constructor stub
	}
	
	public static int balancedSubarry(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		if (a.length == 1) {
			return 0;
		}
		int[] preSum = new int[a.length];
		preSum[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			preSum[i] = preSum[i - 1] + a[i];
		}
		// corner case
		if (preSum[0] == 0 && preSum[preSum.length - 1] == 0) {
			return 0;
		}
		for (int i = 1; i < preSum.length; i++) {
			if (preSum[i - 1] == preSum[preSum.length - 1] - preSum[i]) {
				return i;
			}
		}
		return -1;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5};
		System.out.println(balancedSubarry(a) == -1);
		a = new int[] {1, 2, 3, 2, 1};
		System.out.println(balancedSubarry(a) == 2);
		a = new int[] {1, 1, 1, 2};
		System.out.println(balancedSubarry(a) == 2);
		a = new int[] {0, 0, 0, 0, 0};
		System.out.println(balancedSubarry(a) == 0);
//		a = new int[] {1, 2, 3, 2, 1};
//		System.out.println(balancedSubarry(a) == 2);
	}

}
