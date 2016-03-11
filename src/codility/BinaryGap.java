package codility;

public class BinaryGap {

    public int solution(int N) {
        // write your code in Java SE 8
        int maxGap = 0;
        int zeros = 0;
        boolean isBegin = false;
        while(N>0){
            int bit = N & 1;

            // System.out.println(bit);
            N = N >> 1;
            // encounter first 1
            if ( !isBegin && bit == 1){
                isBegin = true;
                
            }
            // consecutives zeros
            else if (isBegin && bit == 0){
                zeros ++;
            } 
            // update the gap stat
            else if (isBegin && bit == 1){
                maxGap = Math.max(maxGap, zeros);
                zeros = 0;
            }
            
        }
        return maxGap;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
