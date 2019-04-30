package com.ds.array;


public class SecondSmallestAndLargestNum {
	public static int secondSmallest(int[] arr) {

		int first, second, arr_size = arr.length; 
		  
        /* There should be atleast two elements */
        if (arr_size < 2)  { 
            System.out.println(" Invalid Input "); 
            return -1; 
        } 
  
        first = second = Integer.MAX_VALUE; 
        for (int i = 0; i < arr_size ; i ++) { 
            /* If current element is smaller than first 
              then update both first and second */
            if (arr[i] < first) { 
                second = first; 
                first = arr[i]; 
            } 
  
            /* If arr[i] is in between first and second 
               then update second  */
            else if (arr[i] < second && arr[i] != first) 
                second = arr[i]; 
        } 
        
		return second;
	}
	
	public static int secondLargest(int[] arr) {

		int first, second, arr_size = arr.length; 
		  
        /* There should be atleast two elements */
        if (arr_size < 2)  { 
            System.out.println(" Invalid Input "); 
            return -1; 
        } 
  
        first = second = Integer.MIN_VALUE; 
        for (int i = 0; i < arr_size ; i ++) { 
            /* If current element is smaller than first 
              then update both first and second */
            if (arr[i] > first) { 
                second = first; 
                first = arr[i]; 
            } 
  
            /* If arr[i] is in between first and second 
               then update second  */
            else if (arr[i] > second && arr[i] != first) 
                second = arr[i]; 
        } 
        
		return second;
	}

	public static void main(String args[]) {

		int[] a = { 0, 2, 5, 6 };
		int[] b = { 0, 1 };

		boolean result = true;
		result &= secondSmallest(a) == 2;
		result &= secondSmallest(b) == 1;

		if (result) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
		
		result &= secondLargest(a) == 5;
		result &= secondLargest(b) == 0;

		if (result) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

	}
}