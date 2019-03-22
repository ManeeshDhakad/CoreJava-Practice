package com.java8.feature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConcurrentAPI {
	String welcome( Object login, Object land ) {
		if( login.equals("dani")  && land.equals("spain") )	return "welcome";
			return "not welcome";
	}

	
	private  CompletableFuture<?> checkLand( String land ) {
		// only Spanish are allowed
		return CompletableFuture.supplyAsync( ( ) -> {
			return "spain".equals( land );
		} );
	}
	private  CompletableFuture<?> checkLogin( String login, String password ) {
		return CompletableFuture.supplyAsync( ( ) -> {
			return login.equals("dani")  && password.equals("pass");
		} );
	}
	
	static void runAsyncExample() {
	    CompletableFuture cf = CompletableFuture.runAsync(() -> {
	        assertTrue(Thread.currentThread().isDaemon());
	    });
	    assertFalse(cf.isDone());
	    assertTrue(cf.isDone());
	}
	
	public  void main(String[] args) throws InterruptedException, ExecutionException {
		 String login = "dani";
		 String password = "pass";
		 String land = "spain";
		 CompletableFuture<?> loginCompletable = checkLogin( login, password );
		 CompletableFuture<?> checkLandCompletable = checkLand( land );
		 CompletableFuture<?> welcomeOrNot = 
		          loginCompletable.thenCombine( checkLandCompletable,
		          ( cust, shop ) -> welcome( cust, shop ) );
															


		System.out.println( welcomeOrNot.get());
		runAsyncExample();
	}

}
