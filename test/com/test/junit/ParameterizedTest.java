package com.test.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class ParameterizedTest {

	private String input;
	private String expectedOut;	
	public ParameterizedTest(String input, String expectedOut) {
		super();
		this.input = input;
		this.expectedOut = expectedOut;
	}
	@Parameters
	public static Collection testParametized() {
		String expectedOutputs[][] = {{"AACD", "CD"},
									  {"ACD", "CD"}
		                             };
		return Arrays.asList(expectedOutputs);
	}
	@Test
	public void testTrucncateAinFirst2Position() {
		assertEquals(expectedOut, truncateAinFirst2Pos(input));
	}
	public static String truncateAinFirst2Pos(String s) {
		if(s.length() <= 2)
			return s.replaceAll("A", "");
		String first2Char = s.substring(0, 2);
		String restChar = s.substring(2);
		return first2Char.replaceAll("A","") + restChar;
	}
	

}
