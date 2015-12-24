package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.arrayString.LongestSubstring3;

public class LongestSubstring3Test {

	@Test
	public void testLengthOfLongestSubstring() {
		new LongestSubstring3();
		String s = "abcabcbb";
		int expected = 3;
		int actual = LongestSubstring3.lengthOfLongestSubstring(s);
		String message = String.format("Actual is %d , Expected is %d", actual, expected);
		System.out.println(message);
		assertEquals(message, expected, actual);
	}

	@Test
	public void testLengthOfLongestSubstring1() {
		new LongestSubstring3();
		String s = "bbbbbbb";
		int expected = 1;
		int actual = LongestSubstring3.lengthOfLongestSubstring(s);
		String message = String.format("Actual is %d , Expected is %d", actual, expected);
		System.out.println(message);
		assertEquals(message, expected, actual);
	}

	
}
