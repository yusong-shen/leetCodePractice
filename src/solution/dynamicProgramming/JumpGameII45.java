/**
 * 
 */
package solution.dynamicProgramming;

/**
 * @author yusong
 *
 */
public class JumpGameII45 {

    public int jump(int[] A) {
        // maxIndex - maximum index we can reach so far
        // nextMaxIndex - maximum index we can reach after next jump
        int count = 0, max = 0, nextMax = 0;
        
        // loop through the array
        for (int i = 0; i < A.length ; i++) {
            // keep track the max index we can get after next jump
            if (i > max) {
                max = nextMax;
                count++;
            }
            nextMax = Math.max(nextMax, i + A[i]);

        }
        // if there is no way to get to the end, return -1
        return max >= A.length - 1 ? count : -1;        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
