package test;

import static org.junit.Assert.*;

import org.junit.Test;

import solution.arrayString.String2Integer8;

public class String2Integer8Test {

//	"afakn-41947235gs"
//	"2579-"
//	"-2578-"
//	"555525955555555552gebksnk"
//	"2578afag"
//	"gaga2578"
//	"     93857"
	
//	Expected answer
//
//	0
//	2579
//	-2578
//	2147483647
//	2578
//	0
//	93857
	@Test
	public void testMyAtoi() {
		new String2Integer8();
		String s1 = "afakn-41947235gs";
		assertEquals(0, String2Integer8.myAtoi(s1));
	}
	@Test
	public void testMyAtoi2() {
		new String2Integer8();
		String s2 = "555525955555555552gebksnk";
		assertEquals(2147483647, String2Integer8.myAtoi(s2));
	}
	@Test
	public void testMyAtoi3() {
		new String2Integer8();
		String s3 = "2578afag";
		assertEquals(2578, String2Integer8.myAtoi(s3));
	}
}
