package com.java.concurrencyandthreading;

public class TheadT1T2T3 implements Runnable{

	public void run() {
		for(int i = 0; i <= 5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("I am from run() :" +i);
			} catch(Exception e) {
				System.out.println(e);
			}
		} 
	}
	
	public static void main(String []args){
		TheadT1T2T3 obj = new TheadT1T2T3();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);
		t1.setPriority(10);
		t1.start();
		try {
			System.out.println("t1");
			t1.join();

		} catch(Exception e) {
			System.out.println(e);
		}

		t2.start();
		try{
			System.out.println("t2");
			t2.join();

		}catch(Exception e){System.out.println(e);}

		t3.start();
		try{
			System.out.println("t3");
			t3.join();

		}catch(Exception e){System.out.println(e);}

		System.out.println("I am from main()");
	}
}

