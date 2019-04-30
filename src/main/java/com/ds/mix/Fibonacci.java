package com.ds.mix;

// Fibonacci : 1, 1, 2, 3, 5, 8, 13, 21, 34

public class Fibonacci { 
    static int fibNthNumberRecursion(int n) { 
        if (n <= 1) 
            return n; 
        return fibNthNumberRecursion(n - 1) + fibNthNumberRecursion(n - 2); 
    } 
  
    static int fibNthNumber(int n) { 
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n + 1]; 
        int i; 
  
        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0; 
  
        if (n > 0) { 
            f[1] = 1; 
  
            for (i = 2; i <= n; i++) { 
                /* Add the previous 2 numbers in the series 
             and store it */
                f[i] = f[i - 1] + f[i - 2]; 
            } 
        } 
  
        return f[n]; 
    } 
    
    static boolean doTest() {
    	return fibNthNumberRecursion(9) == 34 && fibNthNumber(9) == 34;
    }
    
    public static void main(String args[]) 
    { 
       if(doTest()) {
    	   System.out.println("All test passed");
       } else {
    	   System.out.println("Some failed");
       }
    } 
}