package solution.arrayString;

public class StrStr28 {

    public static int strStr(String haystack, String needle) {
    	int i = 0;
    	int j = 0;
    	if (needle.length()==0) return 0;
    	while(i<=haystack.length()-needle.length()){
    		char x = haystack.charAt(i+j);
    		char y = needle.charAt(j);
    		if (x==y) {
    			j++;
        		if (needle.length()==j) return i;
    			continue;
    		} else{
    			j = 0;
    		}
    		i++;
    		
    	}
		return -1;
        
    }

	public static void main(String[] args) {
		String haystack = "This is a simple string";
		String needle = "This is a simple string";
//		String needle = "";
		System.out.println(strStr(haystack, needle));
		assert strStr(haystack, needle) == 10 : "index is " + strStr(haystack, needle) ;

	}

}
