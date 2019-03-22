package com.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java	
public class Generics {
	public static <T> List<T> getSome(T... arr) {
		List<T> list = new ArrayList<>();
		for(T t : arr)
			list.add(t);
		return list;
	}
	
	
	public static <T extends Comparable> T min(T t1, T t2) {
		T smallest = t1;
		int i = 1;
		if(smallest.compareTo(t2) > 0) {
			smallest = t2;
		}
		return smallest;
		
	}
	
	public static <T extends Comparable> T max(T t1, T t2) {
		T largest = t1;
		int i = 1;
		if(t2.compareTo(largest) > 0) {
			largest = t2;
		}
		return largest;
		
	}
	
	public static double average(List<? extends Number> list) {
		int count = 0;
		double total = 0;
		for(Number n : list) {
			total = total + n.doubleValue();
			count++;
		}
		return total/count;
	}
	
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for(int i = 0; i < src.size(); i++) {
			dest.set(i, src.get(i));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> listInt = getSome(5, 6, 7, 8);
		List<String> listString = getSome("A", "B", "C", "D");
		
		
		listInt.forEach(System.out::println);
		listString.forEach(System.out::println);
		
		System.out.println("Min of 5 and 3 = " + min(5, 3));
		System.out.println("Max of 5 and 3 = " + max(5, 3));
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println("Average = " + average(list));
		
		List<Integer> srcList = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> destList = new ArrayList<>();
		copy(destList, srcList);
		destList.forEach(System.out::println);
	}
}
