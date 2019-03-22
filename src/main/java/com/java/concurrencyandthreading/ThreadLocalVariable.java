package com.java.concurrencyandthreading;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalVariable implements Runnable{
	private static final AtomicInteger atomicInt = new AtomicInteger(0);
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
		@Override protected Integer initialValue() {
			return atomicInt.getAndIncrement();
		}
	};
	

	@Override
	public void run() {
		threadLocal.set( (int) (Math.random() * 100D) );
	    
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());
	}
	

	public static void main(String[] args) {
		Runnable sharedRunnableInstance = new ThreadLocalVariable();
		
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
			thread1.join();//wait for thread 1 to terminate
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
        try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace(); //wait for thread 2 to terminate
		} 
 
	}

}
