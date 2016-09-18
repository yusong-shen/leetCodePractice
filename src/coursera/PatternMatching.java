package coursera;

public class PatternMatching {

	public PatternMatching() {
		// TODO Auto-generated constructor stub
	}

	public static int strStr(String str, String pattern) {
		if (pattern.length() == 0) {
			return 0;
		}
		if (str == null || pattern.length() > str.length()) {
			return -1;
		}
		int n = str.length();
		int m = pattern.length();
		for (int i = 0, j = 0; i < n - m + 1;) {
			char c1 = str.charAt(i + j);
			char c2 = pattern.charAt(j);
			if (c1 == c2 || c2 == '*') {
				// move second pointer in pattern
				j++;
				// if scan through the pattern
				if (m == j) {
					return i;
				}
				// scan next char
				continue;
			} else {
				j = 0;
			}
			i++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("abcdef", "bcd"));
		System.out.println(strStr("abcdef", "*cd"));
		System.out.println(strStr("abcdef", "bc*"));
		System.out.println(strStr("abcdef", "bc*ef"));

	}

}
