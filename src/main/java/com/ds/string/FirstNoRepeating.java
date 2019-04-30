package com.ds.string;


import java.util.HashMap;
import java.util.Map;

public class FirstNoRepeating {

	static char firstNonRep(String s) { 
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i) + 1));
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				return s.charAt(i);
			}
		}
		return '0';
	}

	static boolean doTest() {
		boolean result = true;
		result = result && firstNonRep("abdac") == 'a';
		return result;
	}
	public static void main(String[] args) {
		if(doTest()) 
			System.out.println("Pass");
		else 
			System.out.println("Some Failed");
	}
}