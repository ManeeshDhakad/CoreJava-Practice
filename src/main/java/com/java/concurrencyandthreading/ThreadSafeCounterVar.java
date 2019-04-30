package com.java.concurrencyandthreading;

import java.util.concurrent.atomic.AtomicInteger;

// https://www.programcreek.com/2014/02/how-to-make-a-method-thread-safe-in-java/
//Make a method thread-safe - Method 1
//When synchronized is added to a static method, the Class object is the object which is locked.
//Is marking it synchronized enough? The answer is YES.
class MyCounter {
	private static volatile int counter = 0; // I think volatile should be added here
 
	public static synchronized int getCount() {
		return counter++;
	}
}

//Make a method thread-safe - Method 2
public class ThreadSafeCounterVar {
	private static AtomicInteger counter = new AtomicInteger(0);
	 
	public static int getCount() {
		return counter.getAndIncrement();
	}
}
