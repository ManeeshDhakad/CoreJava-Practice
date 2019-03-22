package com.java.concurrencyandthreading;


import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/*
 * Future is a base interface and defines abstraction of an object which promises result to be 
 * available in future while FutureTask is an implementation of the Future interface.
 * Future is a parametric interface and type-safe written as Future<V>, where V denotes value.
 * Future provides get() method to get result, which is blocking method and blocks until result is available to Future.
 * Future interface also defines cancel() method to cancel task.
 * isDone() and isCancelled() method is used to query Future task states. 
 * isDone() returns true if task is completed and result is available to Future. 
 * If you call get() method, after isDone() returned true then it should return immediately. 
 * On the other hand, isCancelled() method returns true, if this task is cancelled before its 
 * completion.
 * Future has four sub interfaces, each with additional functionality e.g. Response, 
 * RunnableFuture, RunnableScheduledFuture and ScheduledFuture. RunnableFuture also 
 * implements Runnable and successful finish of run() method cause completion of this Future. 
 * FutureTask and SwingWorker are two well known implementation of Future interface. 
 * FutureTask also implements RunnableFuture interface, which means this can be used as 
 * Runnable and can be submitted to ExecutorService for execution.
 * Though most of the time ExecutorService creates FutureTask for you, i.e. when you submit() 
 * Callable or Runnable object. You can also created it manually.
 * FutureTask is normally used to wrap Runnable or Callable object and submit them to 
 * ExecutorService for asynchronous execution.
 */


class MyCallable implements Callable<String> {

	private long waitTime;
	
	public MyCallable(int timeInMillis){
		this.waitTime=timeInMillis;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
	}

}

public class FutureTaskAsyncThreadPool {

	public static void main(String[] args) {
		MyCallable callable1 = new MyCallable(1000);
		MyCallable callable2 = new MyCallable(2000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		
		while (true) {
			try {
				if(futureTask1.isDone() && futureTask2.isDone()){
					System.out.println("Done");
					//shut down executor service
					executor.shutdown();
					return;
				}
				
				if(!futureTask1.isDone()){
				//wait indefinitely for future task to complete
				System.out.println("FutureTask1 output="+futureTask1.get());
				}
				
				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
				if(s !=null){
					System.out.println("FutureTask2 output="+s);
				}
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}catch(TimeoutException e){
				//do nothing
			}
		}
		
	}

}
