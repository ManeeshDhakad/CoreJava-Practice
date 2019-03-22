package com.java.core;

/*
Inner Class
1. Static Inner Class (Create inside outer class, Can not access outer class instance variable)
2. Non-Static Inner Class
   a. Local Inner class (Create inside outer class class)
   b. Member Inner class (Create inside outer class method)
   c. Anonymous Inner class (Create a class without name)
 * 
 */

class OuterClass {
	private int outerClassInstanceVariable = 10;
	
	public void outerClassMethod() {
		class LocalInnerClass {
			// Class is accessible within the method 
			private void localClassMethod() {
				System.out.println("Inside Local class method : " + outerClassInstanceVariable);
			}
		}
		LocalInnerClass localClassObject = new LocalInnerClass();
		localClassObject.localClassMethod();
	}
	
	private class MemberInnerClass {
		private void memberClassMethod() {
			System.out.println("Inside member class method : " + outerClassInstanceVariable);
		}
	}
	
	private static class StaticInnerclass {
		
		private void staticClassMethod() {
			//outerClassInstanceVariable = 10; Compiler error can not use instance variable
			// Can use only class variable of outer class (static variable)
			System.out.println("Inside static class method : ");
		}
	}
	
	public static void main(String[] args) {
		OuterClass outerClassObject = new OuterClass();
		MemberInnerClass memberInnerClassObject = outerClassObject.new MemberInnerClass();
		memberInnerClassObject.memberClassMethod();
		
		
		StaticInnerclass staticInnerClass = new StaticInnerclass();
		staticInnerClass.staticClassMethod();
		
	}
}


