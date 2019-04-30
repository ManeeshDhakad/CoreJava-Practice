package com.java8.feature;

/*
Method reference is used to refer method of functional interface. It is compact and easy 
form of lambda expression. Each time when you are using lambda expression to just 
referring a method, you can replace your lambda expression with method reference. 

:: - Reference Operator

Need and Usage of Method Reference 
----------------------------------
Let say we have a interface having a abstract method m1
Now We are having a class A implements Interface. Now i do not want to give
Implementation of m1, I have another method m2 inside my class. I want that whenever i call m1 method
It should automatically call m2 method. This can be done with method reference.

Advantage : Code re-usability

Following type method reference available in java 8
1. Reference to a static method.
2. Reference to an instance method.
3. Reference to a constructor.

Note : 
1. Both m1 and m2 method should have same argument type. Return type not metters
2. And interface must be Functional Interface


 */

@FunctionalInterface
interface Sayable{  
	void say();
}  

class StaticMethodReference {  
	public static void saySomething(){  
		System.out.println("Hello, this is static method.");  
	}  

	public static void main(String[] args) {  
		// Referring static method  
		Sayable sayable = StaticMethodReference::saySomething;  
		// Calling interface method  
		sayable.say();  
	}  
}  

class InstanceMethodReference {  
	public void saySomething(){  
		System.out.println("Hello, this is non-static method.");  
	}  
	public static void main(String[] args) {  
		InstanceMethodReference methodReference = new InstanceMethodReference(); // Creating object  
		// Referring non-static method using reference  
		Sayable sayable = methodReference::saySomething;  
		// Calling interface method  
		sayable.say();  
		// Referring non-static method using anonymous object  
		Sayable sayable2 = new InstanceMethodReference()::saySomething; // You can use anonymous object also  
		// Calling interface method  
		sayable2.say();  
		
		
		Runnable r = methodReference::saySomething;
		new Thread(r).start();
	}  
}  

class ConstructorReference {  
	ConstructorReference() {
		System.out.println("");
	}
	public static void main(String[] args) {  
		//Argument type of say method and constructor me be same
		//In this case both having no argument
		Sayable sayable = ConstructorReference::new;  
		sayable.say();  
	}  
}  

public class MethodReference {

}
