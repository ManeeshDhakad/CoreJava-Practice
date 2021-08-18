package com.java.collection;

//Java program to sort hashmap by values
import static java.util.stream.Collectors.*;

import java.lang.*;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class SortHashMapByValues {

	// function to sort hashmap by values
	public static HashMap<String, Integer>
	sortByValue(HashMap<String, Integer> hm)
	{
		HashMap<String, Integer> temp
			= hm.entrySet()
				.stream()
				.sorted((i1, i2) -> i1.getValue() - i2.getValue())
				.collect(Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(e1, e2) -> e1, LinkedHashMap::new));

		return temp;
	}

	// Driver Code
	public static void main(String[] args)
	{

		HashMap<String, Integer> hm
			= new HashMap<String, Integer>();

		// enter data into hashmap
		hm.put("Math", 98);
		hm.put("Data Structure", 85);
		hm.put("Database", 91);
		hm.put("Java", 95);
		hm.put("Operating System", 79);
		hm.put("Networking", 80);
		Map<String, Integer> hm1 = sortByValue(hm);

		// print the sorted hashmap
		for (Map.Entry<String, Integer> en :
			hm1.entrySet()) {
			System.out.println("Key = " + en.getKey()
							+ ", Value = "
							+ en.getValue());
		}
	}
}
