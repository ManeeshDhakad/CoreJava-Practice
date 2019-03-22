package com.java8.feature;

/*
Method reference is used to refer method of functional interface. It is compact and easy 
form of lambda expression. Each time when you are using lambda expression to just 
referring a method, you can replace your lambda expression with method reference. 


1. Reference to a static method.
2. Reference to an instance method.
3. Reference to a constructor.

*/

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
    }  
}  

class ConstructorReference {  
	ConstructorReference() {
		System.out.println("");
	}
    public static void main(String[] args) {  
        Sayable sayable = ConstructorReference::new;  
        sayable.say();  
    }  
}  

public class MethodReference {

}
