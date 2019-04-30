package com.ds.string;

/* 
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */
import java.util.*;

public class LongestUniformString {

	private static final Map<String, int[]> testCases = new HashMap<String, int[]>();

	static int[] longestUniformSubstring(String input){
		int longestStart = -1;
		int longestLength = 0;
		int ix = 1;
		
		while(ix < input.length()) {
			int start = ix - 1;
			int currentLength = 1;
			while(ix < input.length() && input.charAt(ix) == input.charAt(ix - 1) ){
				ix++;
				currentLength++;
			}
			if(currentLength > longestLength){
				longestStart = start;
				longestLength = currentLength;
			}
			ix++;
		}
		return new int[]{ longestStart, longestLength };
	}

	public static void main(String[] args) {
		testCases.put("", new int[]{-1, 0});
		testCases.put("10000111", new int[]{1, 4});
		testCases.put("aabbbbbCdAA", new int[]{2, 5});

		boolean pass = true;
		for(Map.Entry<String,int[]> testCase : testCases.entrySet()){
			int[] result = longestUniformSubstring(testCase.getKey());
			pass = pass && (Arrays.equals(result, testCase.getValue()));
		}
		if(pass){
			System.out.println("All tests pass!");
		} else {
			System.out.println("At least one failure! :( ");
		}
	}
}
