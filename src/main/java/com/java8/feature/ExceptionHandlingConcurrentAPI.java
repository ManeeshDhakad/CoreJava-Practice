package com.java8.feature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

public class ExceptionHandlingConcurrentAPI {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture completableFutureException = CompletableFuture.supplyAsync( ( ) -> {
			return 10 / 0;  
			// return 10/0 produces an exception, division by zero
		} );
		
		// This will produce divide by zero exception 
		System.out.println( completableFutureException.get() );
				
				
		//Handle Exception 
		// exceptionally()
		CompletableFuture fallback = completableFutureException.exceptionally( x -> 0 );

		// “waits” for the results of the computation and in case an exception happens, 
		// provides a basic fallback. In the snippet no exception is thrown during the calculation
		System.out.println( fallback.get() );
		
		//handle()
		CompletableFuture handleOkError = completableFutureException.handle( ( ok, ex ) -> {
			if( ok != null ) {
				return ok; // return the value if everything ok
			}
			else {
				// in case of an exception print the stack trace and return null
				((CompletionException) ex).printStackTrace();
				return null;
			}
		});
		System.out.println( "ok or error ? " + handleOkError.get() );

		
	}

}
