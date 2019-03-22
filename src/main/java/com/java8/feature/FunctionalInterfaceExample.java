package com.java8.feature;

/*
An interface with exactly one abstract method is called Functional Interface. 
@FunctionalInterface  annotation is added so that we can mark an 
interface as functional interface. It is not mandatory to use it, but it’s best practice to 
use it with functional interfaces to avoid addition of extra methods accidentally.

Java 8 has defined a lot of functional interfaces in java.util.function package. 
Some of the useful java 8 functional interfaces are Consumer, Supplier, Function and Predicate.

Objects are the base of java programming language and we can never have a 
function without an Object, that’s why Java language provide support for using 
lambda expressions only with functional interfaces.

*/

interface Foo { boolean equals(Object obj); }
//Not functional because equals is already an implicit member (Object class)

@FunctionalInterface
interface Comparator<T> {
	int compare(T o1, T o2); //abstract method
	
	// It can contain any number of Object class methods.  
    int hashCode();  
    String toString();
	boolean equals(Object obj);
}
//Functional because Comparator has only one abstract non-Object method


interface Foo1 {
	int m();
	Object clone();
}
//Not functional because method Object.clone is not public

interface X { int m(Iterable<String> arg); }
interface Y { int m(Iterable<String> arg); }
interface Z extends X, Y {}
//Functional: two methods, but they have the same signature

interface X1 { Iterable m(Iterable<String> arg); }
interface Y1 { Iterable<String> m(Iterable arg); }
interface Z1 extends X, Y {}
//Functional: Y.m is a subsignature & return-type-substitutable

interface X2 { int m(Iterable<String> arg); }
interface Y2 { int m(Iterable<Integer> arg); }
interface Z2 extends X, Y {}
//Not functional: No method has a subsignature of all abstract methods

interface X3 { int m(Iterable<String> arg, Class c); }
interface Y3 { int m(Iterable arg, Class<?> c); }
interface Z3 extends X, Y {}
//Not functional: No method has a subsignature of all abstract methods

interface X4 { long m(); }
interface Y4 { int m(); }
interface Z4 extends X, Y {}
//Compiler error: no method is return type substitutable

interface Foo2<T> { void m(T arg); }
interface Bar2<T> { void m(T arg); }
//interface FooBar2<X, Y> extends Foo2<X>, Bar2<Y> {}
//Compiler error: different signatures, same erasure

public class FunctionalInterfaceExample {

}
