package com.java.core;

/*
Wrapper classes use to covert primitive to object and visa versa
int - Integer
char - Character
float - Float
double - Double
boolean - Boolean
...
...

 */
public class WrapperClass {

	Integer i = 10; // Auto Boxing
	Integer i1 = new Integer(10); //Boxing - Converting int to object
	int i2 = i.intValue(); // Unboxing
	int i3 = i; // Auto unboxing 
}
