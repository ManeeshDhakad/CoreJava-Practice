package com.java8.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Objects are the base of java programming language and we can never have a 
function without an Object, that’s why Java language provide 
support for using lambda expressions only with functional interfaces.

Advantage:
1. Reduced Lines of Code
2. Readable and manageable code
2. Sequential and Parallel Execution Support : 
   Stream API sequential and parallel operations support.
3. Functional programming support (Passing Behaviors into methods)


Note : Local variable reference in lambda expression must be final (Mean we can not change local variable value in lambda expression,
       But we can change instance variable value from lambda expression)


() -> { return 42; }         // No parameters, block body with return
() -> { System.gc(); }       // No parameters, void block body

// Complex block body with multiple returns
() -> {
  if (true) return 10;
  else {
    int result = 15;
    for (int i = 1; i < 10; i++)
      result *= i;
    return result;
  }
}                          

(int x) -> x+1             // Single declared-type argument
(int x) -> { return x+1; } // same as above
(x) -> x+1                 // Single inferred-type argument, same as below
x -> x+1                   // Parenthesis optional for single inferred-type case

(String s) -> s.length()   // Single declared-type argument
(Thread t) -> { t.start(); } // Single declared-type argument
s -> s.length()              // Single inferred-type argument
t -> { t.start(); }          // Single inferred-type argument

(int x, int y) -> x+y      // Multiple declared-type parameters
(x,y) -> x+y               // Multiple inferred-type parameters
(x, final y) -> x+y        // Illegal: can't modify inferred-type parameters
(x, int y) -> x+y          // Illegal: can't mix inferred and declared types


 */

@FunctionalInterface // Only one abstract method
interface Interface3 {
	void print(String s); 
	default void show() {}
	static void display() {}
}
public class LamdaExpExample {

	public static void main(String[] args) {
		Interface3 i1 = new Interface3() {
			@Override 
			public void print(String str) {
				System.out.println(str);
			}
		};
		i1.print("Normal implementation");
		
		// Lamda exp for multiple statement
		Interface3 i2 = (s) -> { 
			System.out.println("Statement 1 : " + s); 
			System.out.println("Statement 2 : " + s); 
		};
		i2.print("Lamda exp with multiple statement");
		
		// Lamda exp for single statement
		Interface3 i3 = (s) -> System.out.println("Statement 1 : " + s); 
		i3.print("Lamda exp with single statement");
		
		
		
		List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");  
          
        list.forEach(  
            n-> System.out.println(n)  
        );  
        
        
        // Sort any object list (let say employee) based on there name
        class Employee { private String name; };
        List<Employee> empList = new ArrayList<>();
        Collections.sort(empList,(p1,p2)->{  
            return p1.name.compareTo(p2.name);  
        });  
        
        // Print employee list
        empList.forEach(  
             emp -> System.out.println(emp.name) 
        ); 
		
	}
	
}
