package com.java.core;
import java.io.IOException;


class A {}
class B extends A {}
class C extends B {}

public class TypeCasting extends B {
	public static void main(String[] args) throws IOException {
		B b = new B();
		C c = new C();
		
		//Upcasting
		B b1 = (B)c;
		
		//Downcasting
		C c1 = (C)b;
	}
}
