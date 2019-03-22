package com.java8.feature;

interface Interface1 {
	void method1(String str);

	default void log(String str){
		System.out.println("I1 logging::"+str);
	}

	static void print(String str){
		System.out.println("Printing "+str);
	}
}

interface Interface2 {
	void method2();

	default void log(String str) {
		System.out.println("I2 logging::"+str);
	}
}

public class InterfaceStaticDefaultMethod implements Interface1, Interface2 {

	@Override
	public void method2() {
	}

	@Override
	public void method1(String str) {
	}

	//MyClass won't compile without having it's own log() implementation
	// If Both interface have same default method then need to give implementation here
	// If any of the method do not have default method then no implementation needed here
	@Override
	public void log(String str){
		System.out.println("MyClass logging::"+str);
	}
	
	public static void main(String []args) {
		Interface1.print("abc");
		InterfaceStaticDefaultMethod obj = new InterfaceStaticDefaultMethod();obj.log("Hello");
		
		Interface1 obj1 = new InterfaceStaticDefaultMethod();obj1.log("Hello");
		Interface2 obj2 = new InterfaceStaticDefaultMethod();obj2.log("Hello");
	}
}