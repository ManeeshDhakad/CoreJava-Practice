package com.ds.string;


/* 
Question: 
Combine ingredients in a specific order, any of which may be repeated

As an example, consider the following  
(A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, E 

Encode the string above using only 6 characters: A,B,*,C,*,E

Implement function that takes as input an un-encoded potion and returns the 
minimum number of characters required to encode
 */
public class MagicPotion {
	private static Integer minimalSteps(String ingredients) {
		int n = ingredients.length();
		if (n == 0) {
			return 0;
		}

		Integer dp[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);

			if (2*i + 1 < n 
					&& ingredients.substring(0, i + 1).equals(ingredients.substring(i + 1, 2*i + 2))) {
				dp[2*i + 1] = dp[ i ] + 1;
			}
		}

		return dp[n - 1];
	}

	private static boolean doTestsPass() {
		return (minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5 );
	}
	
	public static void main(String[] args) {


		if (doTestsPass()) {
			System.out.println( "All tests passed" );
		}
		else {
			System.out.println( "Tests failed" );
		}
	}
}