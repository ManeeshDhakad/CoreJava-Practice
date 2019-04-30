package com.ds.string;


public class AToI {

	// Takes a string str and returns the int value represented by
	// the string. 
	//For example, atoi("42") returns 42.

	public static int atoi(String str) {
		int result = 0;
		int strLength = str.length();

		for(int i = 0; i < strLength; i++) {
			char ch = str.charAt(i);
			
			if(!isNumaricChar(ch)) {
				return -1;
			} 
			result = result * 10 + ch - '0'; 
			
		}

		return result;
	}
	
	public static boolean isNumaricChar(char ch) {
		return (ch >= '0' && ch <= '9'); 
	}

	public static boolean pass() {
		boolean result = true;
		result = result && atoi("42") == 42;
		result = result && atoi("46") == 46;
		result = result && atoi("40") == 40;
		result = result && atoi("1234") == 1234;
		
		return result;
	}

	public static void main(String[] args) {
		if(pass()) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Some fail");
		}
	}
}
