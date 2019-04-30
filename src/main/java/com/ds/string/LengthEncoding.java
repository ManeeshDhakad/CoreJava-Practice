package com.ds.string;

public class LengthEncoding {

	static String lengthEncoding(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char lastChar = s.charAt(0);
		for(int i = 1; i < s.length(); i++) {
			if(lastChar == s.charAt(i)) {
				count++;
			} else {

				sb.append(lastChar).append(count);
				lastChar = s.charAt(i);
				count = 1;
			}
		}
		sb.append(lastChar).append(count);

		System.out.println(sb.toString());
		return sb.toString();
	}

	static boolean doTest() {



		boolean result = true;
		result = result && lengthEncoding("aabcdd").equals("a2b1c1d2");
		return result;
	}
	public static void main(String[] args) {
		if(doTest()) 
			System.out.println("Pass");
		else 
			System.out.println("Some Failed");
	}
}