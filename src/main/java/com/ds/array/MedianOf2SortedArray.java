package com.ds.array;

//find the median of the two sorted arrays.
// ex. {1, 3} and {2} is 2


public class MedianOf2SortedArray
{

	public static double logic(int[] ar1, int[] ar2) {
		
		int n = ar1.length;
		int m = ar2.length;
		
		
		if(n == 0 && m == 0)
			return -1.0;
		if((n + m) == 0)
			return -1.0;
		
		
		int i = 0; /* Current index of input array ar1[] */
	    int j = 0; /* Current index of input array ar2[] */
	    int count;  
	    int m1 = -1, m2 = -1;  
	  
	    // Since there are (n+m) elements,  
	    // There are following two cases 
	    // if n+m is odd then the middle  
	    //index is median i.e. (m+n)/2 
	    
	    // if m+n is even then median will be average of elements  
	    // at index ((m+n)/2 - 1) and (m+n)/2 
	    // in the array obtained after merging ar1 and ar2 
	    
	    for (count = 0; count <= (n + m)/2; count++) { 
	    	if((m + n) % 2 == 0) {
	    		m2 = m1; 
	    	}
	    	
	        if(i != n && j != m) { 
	            m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++]; 
	        } else if(i < n) { 
	            m1 = ar1[i++]; 
	        } else { // for case when j<m, 
	            m1 = ar1[j++]; 
	        } 
	    } 
	    
	    if((m + n) % 2 == 0) {
	    	Double result = (Double.valueOf(m1) + Double.valueOf(m2))/2;
	    	System.out.println(result);
	    	return (result); 
	    } else {
	    	Double result = Double.valueOf(m1);
	    	System.out.println(result);
	    	return result; 
	    }
	}

	public static boolean pass() {
		boolean result = true;
		result = result && logic(new int[]{1, 3}, new int[]{2}) == 2.0;
		result = result && logic(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
		result = result && logic(new int[]{}, new int[]{}) == -1.0;
		return result;
	};

	public static void main(String[] args) {
		if(pass()) {
			System.out.println("pass");
		}
		else
		{
			System.out.println("some failures");
		}
	}
}