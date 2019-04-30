package com.java8.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Package : java.util.stream

Stream API :
===========
Process objects from collections. Whey you want to perform bulk operation then we use Stream.

list.stream() once you create stream now here comes following steps

1. Configuration
=================

Filter :
--------
1. Just filter few items from collections based on some boolean condition 
   filer student who's percentage is 80% >=

   public Stream filter(Predicate<T> t);
   Example : Stream s1 = list.stream().filter(i -> i % 2 == 0)

Map :
-----
2. When we want to create seperate new object For all items in collection base on some function.
   public Stream map(Function<T, R> f);

   Covert list of integer to create new object by doubling each number
   Example : Stream s1 = list.stream().map(i -> i * i);


2. Processing :
==============

Collect :
---------
This method collect the element from stream and adding to the specified collection.

List<String> l1 = l.stream().filter(s -> s.lenght() >= 9).collect(Collectors.toList());
List<String> l1 = l.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());


Count :
------
This method return the number of element present in Stream

public long count();

Find number of item who's length is >= 9
long l1 = l.stream().filter(s -> s.lenght() >= 9).count();


Sorted :
-------
We can use sorted() method to sort element of Stream. Can sort either based on default natural order
or based on our own customized sorting order

1. sorted() : For default natural order
2. sorted(Comparator c) : For customized sorting order

//Sort natural sorting order, witch is ascending order
List<Integer> list = list1.stream().sorted().collect(Collectors.toList());
//Sort based on descending order, Used comparator
List<Integer> list = list1.stream().sorted((o1, o2) -> o2 - o2).collect(Collectors.toList());


Min :
-----
min(Comparator c) : Return minimum value according to specified comparator

Integer min = list4.stream().min((i1, i2) -> i1.compareTo(i2)).get();

Max :
-----
max(Comparator c) : Return maximum value according to specified comparator

Integer max = list4.stream().max((i1, i2) -> i1.compareTo(i2)).get();


forEach:
--------
This method wont return anything. This method can take lambda expression as argument and apply that
lambda expression for each element present in stream

//Lambada expression 
list4.stream().forEach(s -> System.out.println(s));
//Method reference
list4.stream().forEach(System.out::println);


toArray :
--------
To copy element present in stream into specified array

Integer []arr = list.stream().toArray(Integer[] ::new);

 */

public class StreamAPI {

	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<10; i++) myList.add(i);

		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		//using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 9);
		//using lambda in forEach
		System.out.println("High Nums parallel=\n" + highNums);

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 9);
		System.out.println("High Nums sequential=\n" + highNumsSeq);

		//Get all even number in list
		List<Integer> list = myList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		//list.forEach(System.out::println);

		List<Integer> list1 = myList.stream().map(x -> x * x).collect(Collectors.toList());
		//list1.forEach(System.out::println);


		List<String> list2 = Arrays.asList("Maneesh", "Dhakad123");
		List<String> l1 = list2.stream().filter(s -> s.length() >= 9).collect(Collectors.toList());
		List<String> l2 = list2.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		List<String> l3 = list2.stream().filter(s -> s.length() >= 9).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);

		long count1 = list2.stream().filter(s -> s.length() >= 9).count();
		System.out.println("Count of string who's length >= " + count1);


		//Sort natural sorting order, witch is ascending order
		List<Integer> list4 = Arrays.asList(4, 5, 2, 1);
		List<Integer> l4 = list4.stream().sorted().collect(Collectors.toList());
		//Sort based on descending order, Used comparator
		List<Integer> l5 = list4.stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
		System.out.println("Nartural soring order \n"+ l4);
		System.out.println("Sort based on comparator desending order\n" +l5);


		Integer min = list4.stream().min((i1, i2) -> i1.compareTo(i2)).get();
		Integer max = list4.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);


		//Lambada expression, forEarch
		list4.stream().forEach(s -> System.out.println(s));
		//Method reference
		list4.stream().forEach(System.out::println);
		
		//toArray()
		Integer []arr = list.stream().toArray(Integer[] ::new);
		
		//Convert array stream, Now you can perform any stream operator
		Stream<Integer> stream = Stream.of(1, 6,  3, 7, 4, 5);
		
		
	}

} 