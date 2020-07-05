package com.java8.feature;

/*
 
Java 8 Interface vs Abstract Class :
Interface :																				   Abstract Class
1. All variables are public static and final. We can not declare instance variable.		   1. We can declare instance variable.
2. Interface Never talk about state of object.											   2. Abstract class can talk about state of object.
3. It cant have constructor 															   3. Abstract class has constructor.
4. Inside interface we can not declare instance and static block.						   4  Inside Abstract class we can declare instance and static block.
5. Functional interface can refer lambda expression. 									   5. Abstract class can not refer lambda expression

 
Default Method :
- Backward compatibility 
- Concrete menthod in interface
- Optional to overried in class while implementing interface
- If class implementing multiple interface and they are containing same signature default method
  Then class must override that default mehod else give compilcation error



Static Method :
- General utility methods. Always call by Interface.method()  only can not be called by ClassName.method() or ClassObject.method()
  Because interface static method by default not available in implementing class
  Overriding concepts not true in case of static method of interface.
  We can have similar method in class, We can increase of decrease the scope (public - private etc), We can also remove static keyword from method	
  
  
Note : We can declare main method in java8 Interface also we can directly run Interface containing main method.
 */
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

	// InterfaceStaticDefaultMethod won't compile without having it's own log() implementation
	// If Both interface have same named default method then need to give implementation here
	// If any of the interface do not have default method then no implementation needed here
	@Override
	public void log(String str){
		// If Dont want to give own implementation then use following
		//Interface1.super.log(str);
		//Or
		//Interface2.super.log(str);
		//Or
		// Give you own Implementation 
		System.out.println("MyClass logging::"+str);
	
	}
	
	public static void main(String []args) {
		Interface1.print("abc");
		InterfaceStaticDefaultMethod obj = new InterfaceStaticDefaultMethod();obj.log("Hello");
		
		Interface1 obj1 = new InterfaceStaticDefaultMethod();obj1.log("Hello");
		Interface2 obj2 = new InterfaceStaticDefaultMethod();obj2.log("Hello");
	}
}