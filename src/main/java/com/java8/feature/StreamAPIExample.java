package com.java8.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIExample {

	//Traditional approach
	private static boolean isPrime(int number) {		
		if(number < 2) return false;
		for(int i=2; i<number; i++){
			if(number % i == 0) return false;
		}
		return true;
	}

	/*
		 Declarative approach with lambda and stream API
		 range() method returns a sequential ordered IntStream from startInclusive (inclusive) 
		 to endExclusive (exclusive) by an incremental step of 1.

	    noneMatch() method returns whether no elements of this stream match the provided 
	    predicate. It may not evaluate the predicate on all elements if not necessary 
	    for determining the result.
	 */

	private static boolean isPrimeLambda(int number) {		
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}
	

	
	public static void main(String args[]) {
		Integer arr[] = {1, 2, 3, 4, 5};
		Arrays.stream(arr).forEach(System.out::println);
		
		Stream.of(1, 2, 3, 4, 5).filter(num -> num % 2 != 0).forEach(System.out::println);
		
		System.out.println("5 is prime : " + isPrimeLambda(5));
		
		List<Item> list = new ArrayList<>();
		//list.add(e)
		list.add(new Item(1, "ABC"));list.add(new Item(4, "BCD"));list.add(new Item(5, "CDE"));
		int sum = list.stream().filter(i -> i.getCount() % 2 != 0)
			.mapToInt(i -> i.getCount()).sum();
		System.out.println("Sum of odd: " + sum);
		
	}
}

class Item {
	private int count;
	private String name;
	public Item(int count, String name) {
		this.count = count;
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
