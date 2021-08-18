package com.ds.string;


import java.util.HashSet;
import java.util.Set;

public class FirstNoRepeating {

	static char firstNonRep(String s) { 
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				return s.charAt(i);
			} else {
				set.add(s.charAt(i));
			}
		}

		return '0';
	}

	static boolean doTest() {
		boolean result = true;
		result = result && firstNonRep("abdacb") == 'a';
		return result;
	}
	public static void main(String[] args) {
		if(doTest()) 
			System.out.println("Pass");
		else 
			System.out.println("Some Failed");
	}
}