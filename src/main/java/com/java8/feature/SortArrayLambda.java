package com.java8.feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortArrayLambda {
	public static void main(String args[]) { 
    	List<Integer> list = Arrays.asList(4, 1, 6, 5, 8, 3);
    	System.out.println("Natural Order\n");
    	for(Integer a : list) System.out.print(a + " ");
    	
    	System.out.println("\nSort in ascending Order by compartor\n");
    	Collections.sort(list, (o1, o2) -> o1-o2);
        for(Integer a : list) System.out.print(a + " ");
        
        System.out.println("\nSort in descending Order by compartor\n");
        Collections.sort(list, (o1, o2) -> o2-o1);
        for(Integer a : list) System.out.print(a + " ");
    }
}
