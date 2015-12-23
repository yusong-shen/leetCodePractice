package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.arrayString.ValidPalindrome125;

public class ValidPalindrome125Test {

	@Test
	public void testIsPalindrome() {
		ValidPalindrome125 palindrome = new ValidPalindrome125();
		String s1 = "A man, a plan, a canal: Panama";
		assertTrue(palindrome.isPalindrome(s1));
		String s2 = "race a car";
		assertFalse(palindrome.isPalindrome(s2));
	}

}
