package com.ds.array;

import java.util.Arrays;
import java.util.HashSet; 
  
public class PairSum { 
	//Approach 1
    static void printpairs(int arr[],int sum) {        
        HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i=0; i<arr.length; ++i) { 
            int temp = sum-arr[i]; 
  
            // checking for condition 
            if (temp>=0 && s.contains(temp)) { 
                System.out.println("Pair with given sum " + 
                                    sum + " is (" + arr[i] + 
                                    ", "+temp+")"); 
            } 
            s.add(arr[i]); 
        } 
    } 
    
    //Approach 2
    static void hasArrayTwoCandidates(
            int A[],
            int arr_size, int sum)
        {
            int l, r;
     
            /* Sort the elements */
            Arrays.sort(A);
     
            /* Now look for the two candidates
            in the sorted array*/
            l = 0;
            r = arr_size - 1;
            while (l < r) {
                if (A[l] + A[r] == sum) {
                	System.out.println("Pair with given sum " + 
                            sum + " is (" + A[l] + 
                            ", "+A[r]+")"); 
                	l++;
                	r--;
                }
   
                else if (A[l] + A[r] < sum)
                    l++;
                else // A[i] + A[j] > sum
                    r--;
            }
    
        }
  
    // Main to test the above function 
    public static void main (String[] args) { 
        int A[] = {1, 5, 45, 6, 10, 8}; 
        int n = 11; 
        printpairs(A,  n); 
        System.out.println("Second Approach");
        hasArrayTwoCandidates(A, A.length, n);
    } 
} 