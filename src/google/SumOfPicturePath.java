package google;

import java.util.Stack;

public class SumOfPicturePath {

	public SumOfPicturePath() {
		// TODO Auto-generated constructor stub
	}
	
	static int solution(String S) {
        // write your code in Java
		if (S.length() == 0) {
			return 0;
		}
		int len = 0;
		int totalLen = 0;
		Stack<String> stack = new Stack<>();
		String[] strs= S.split("\n");
		for (int i = 0; i < strs.length; i++) {
			// check the number of spaces at beginning
			// to determine structure
			String current = strs[i];
			int numSpace = 0;
			for (int j = 0; j < current.length(); j++) {
				if (current.charAt(j) == ' ') {
					numSpace++;
				} else {
					break;
				}
			}
			String fileName = current.substring(numSpace);
			// use stack to traverse folder structure
			if (numSpace == stack.size()) {
				// get to leaf image file
				if (fileName.endsWith(".jpeg") || fileName.endsWith(".gif") || fileName.endsWith(".png")) {
					stack.push(fileName);
					len += fileName.length() + 1;
					totalLen += len;
					// print absolute path
//					for (String s : stack) {
//						System.out.print('/' + s);
//					}
//					System.out.println("");
				} else {
					stack.push(fileName);
					len += fileName.length() + 1;
				}
			} else if (numSpace < stack.size()) {
				// not the subfolder
				String tempName = stack.pop();
				len -= tempName.length() + 1;
				// Move back to upper level
				i--;
			}
		}
				
		return totalLen;
	}
	
	public static void main(String[] args) {
		/*
		 * abc
		 *  abcd
		 *   pic.jpeg
		 */
		String input = "abc\n abcd\n  pic.jpeg";
		String path = "/abc/abcd/pic.jpeg";
		System.out.println(path.length() == solution(input));
//		System.out.println(path.length() == longestPath(input));

		/*
		 * dir1
		 *  dirl1
		 *  dirl2
		 *   picture.jpeg
		 *   dirl21
		 *   file1.txt
		 * dir2
		 *  file2.gif
		 */
		input = new StringBuilder()
					.append("dir1\n")
					.append(" dirl1\n")
					.append(" dirl2\n")
					.append("  picture.jpeg\n")
					.append("  dirl21\n")
					.append("  file1.txt\n")
					.append("dir2\n")
					.append(" file2.gif\n")
					.toString();
//		System.out.println(input);
		path = "/dir1/dirl2/picture.jpeg" + "/dir2/file2.gif";
		System.out.println(path.length() == solution(input));
//		System.out.println(path.length() == longestPath(input));
	}

}
