package solution.arrayString;

public class OneEditDistance161 {

/*    
 * public boolean isOneEditDistance(String s, String t) {
    	if (Math.abs(s.length()-t.length())>1) return false;
    	// check modify operation
    	int count = 0;
    	if (s.length()==t.length()){
    		for (int i=0; i<s.length(); i++){
    			if(s.charAt(i)!=t.charAt(i)) count ++;
    			if(count>1) return false;
    		}
    		return count!=0;
    	}
    	// check insert operation
    	else {
    		// make sure s is the shorter string
    		if (s.length()>t.length()){
    			String temp = s;
    			s = t;
    			t = temp;
    		}
    		for (int i=0,j=0; i<s.length(); i++){
    			if (s.charAt(i)!=t.charAt(j)){
    				count++;
    				j++;
    			}
//    			System.out.println(s.charAt(i));
//    			System.out.println(t.charAt(j));
//    			System.out.println(count);
    			if (count==1 && s.charAt(i)!=t.charAt(j)) return false;
    			if (count>1) return false;
    			j++;
    		}
    		if (count==1)
    			return t.charAt(t.length()-1)==s.charAt(s.length()-1);
    	}
		return true;
    }
    */
	public boolean isOneEditDistance(String s, String t) {
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
	        if (s.charAt(i) != t.charAt(i)) {
	        	// s has the same length as t, 
	        	// so the only possibility is replacing one char in s and t
	            if (s.length() == t.length()) 
	                return s.substring(i + 1).equals(t.substring(i + 1));
	            // t is longer than s, so the only possibility is deleting one char from t
	            else if (s.length() < t.length()) 
	                return s.substring(i).equals(t.substring(i + 1));               
	            else // s is longer than t, so the only possibility is deleting one char from s
	                return t.substring(i).equals(s.substring(i + 1));
	        }
	    }
		return Math.abs(s.length()-t.length())==1;   
       
	}
	public static void main(String[] args) {
		OneEditDistance161 test = new OneEditDistance161();
		String s = "teacher";
		String t = "bleacher";
		System.out.println(test.isOneEditDistance(s, t));
	}

}
