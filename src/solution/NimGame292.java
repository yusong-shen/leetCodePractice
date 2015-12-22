package solution;

/**
 * 
 * @author yusong
 *
 */
public class NimGame292 {

	public NimGame292() {
	}
	
    public static boolean canWinNim(int n) {
    	if (n<0) return false;
		return n%4!=0;
        
    }	
    
    public static void main(String[] args){
    	System.out.println(canWinNim(5));
    }

}
