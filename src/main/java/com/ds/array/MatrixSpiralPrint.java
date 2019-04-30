package com.ds.array; 

class MatrixSpiralPrint  
{ 
	// Function print matrix in spiral form 
	static String spiralPrint(int m, int n, int a[][]) {   
		int i, k = 0, l = 0; 
		StringBuilder sb = new StringBuilder();
		/*  k - starting row index 
            m - ending row index 
            l - starting column index 
            n - ending column index 
            i - iterator 
		 */

		while (k < m && l < n) { 
			// Print the first row from the remaining rows 
			for (i = l; i < n; ++i) { 
				System.out.print(a[k][i]+" "); 
				sb.append(a[k][i]);
			} 
			k++; 

			// Print the last column from the remaining columns  
			for (i = k; i < m; ++i) { 
				System.out.print(a[i][n-1]+" "); 
				sb.append(a[i][n-1]);
			} 
			n--; 

			// Print the last row from the remaining rows */ 
			if ( k < m) { 
				for (i = n-1; i >= l; --i) { 
					System.out.print(a[m-1][i]+" ");
					sb.append(a[m-1][i]);
				} 
				m--; 
			} 

			// Print the first column from the remaining columns */ 
			if (l < n) { 
				for (i = m-1; i >= k; --i) { 
					System.out.print(a[i][l]+" ");
					sb.append(a[i][l]);
				} 
				l++;     
			}         
		} 
		
		System.out.println();
		return sb.toString();
	} 

	static boolean doTest() {
		int R = 3; 
		int C = 3; 
		int a[][] = { 
				      {1,  2,  3}, 
				      {7,  8,  9,}, 
				      {13, 14, 15} 
		            }; 

		int b[][] = { 
				      {5,  6,  4}, 
				      {7,  8,  3}, 
				      {13, 14, 15} 
		            }; 
		return spiralPrint(R, C, a).equals("123915141378") && 
				spiralPrint(R, C, b).equals("564315141378");
	}
	// driver program 
	public static void main (String[] args)  { 
		if(doTest()) {
			System.out.println("All test passed");
		} else {
			System.out.println("Some failed");
		}
	} 
} 
