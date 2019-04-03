package com.java.concurrencyandthreading;

import java.util.concurrent.atomic.AtomicInteger;


//Make a method thread-safe - Method 1
//Is marking it synchronized enough? The answer is YES.
//If the method is not static, then adding synchronized keyword will synchronize the instance of the class, not the Class object.
class MyCounter {
	private static int counter = 0;
 
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
