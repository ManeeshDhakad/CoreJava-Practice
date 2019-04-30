package com.ds.string;



/* 
 *					******** IMPORTANT ********
 *
 * THIS IS SAMPLE SOLUTION. IF YOU FIND BETTER SOLUTION PLEASE CONSIDER USING SAME.
 * USE YOUR OWN VARIABLE NAMES - @@@ DO NOT COPY @@@ EXACT VARIABLE NAMES
 *
 */

import java.util.*;

public class Panagram {

	private static class PanagramDetector {
		private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

		public String findMissingLetters(String sentence) {
//			SortedSet<Character> missing = new TreeSet<Character>();
//			for (int i = 0; i < ALPHABET.length(); i++) {
//				missing.add(new Character(ALPHABET.charAt(i)));
//			}
//
//			String s = sentence.toLowerCase();
//
//			for (int i = 0; i < s.length(); i++) {
//				missing.remove(new Character(s.charAt(i)));
//			}
//
//			StringBuilder sb = new StringBuilder();
//			for (Character c : missing) {
//				sb.append(c.charValue());
//			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < ALPHABET.length(); i++) {
				String temp = String.valueOf(ALPHABET.charAt(i));
				if(!sentence.contains(temp)) {
					sb.append(temp);
				}
			}
			
			
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		PanagramDetector pd = new PanagramDetector();
		boolean success = true;

		success = success && "".equals(pd.findMissingLetters("The quick brown fox jumps over the lazy dog"));
		success = success && "abcdefghijklmnopqrstuvwxyz".equals(pd.findMissingLetters(""));

		if (success) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
}