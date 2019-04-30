package com.java8.feature;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

/*
Package : Java.util.function

All are function interfaces
===========================


1. Predicate
   Predicate are boolean value function, Predicate can refer lambda expression
   Perform some conditional check and return boolean (employee age > 30)
   interface Predicate<T>{  //: Predicate Interface has only 1 parameter 
    boolean test(T t);
   }
   
   Example :
   Predicate<Integer> p = i -> i > 10;
   p.test(100) : true
   
2. Function
   function is just is like predicate but need not to return boolean value. can return any value or Object
   interface Function<T, R>{ //: Function interface have 2 parameter input parameter, and Return return.
      R  apply(T t);
   }
   Example :
   Function<String, Integer> f = s -> s.length();

3. Consumer
   It consume the value and perform certain operation but dont return any value
   interface Consumer<T>{
    void accept(T t);
   }
   Example
   Consumer<String> c = s -> System.out.println(s);

4. Supplier 
   It does not accept any inputs, It always return R type.
   No Default and static function available
   interface Supplier<R> {
      R get();
   }
   
   Example 
   Supplier<Date> s = () -> new Date();
   Best example to generate otp, see example below
  
5. BiPredicate
   It access 2 input values and do the similar check as predicate
   interface BiPredicate<T1, T2> {
     public boolean test(T1 t1, T2 t2);
   }
   
6. BiFunction
   It take 2 input values and Also accept return type. and do similar operation as Function
   interface BiFunction<T1, T2, R> {
     public R apply(T1 t1, T2 t2);
   }
   
6. BiConsumer
   It take 2 input and do the similar operation as consumer 
   interface BiConsumer<T1, T2> {
     public void accept(T1 t1, T2 t2);
   }



Disadvantage of Object Functional Interface.
1. Let say we are using Predicate<Integer> now test method accept Integer, Suppose be pass int value (10, 20 ,30) 
   Then every time it has to do auto boxing and convert int to Integer then auto unboking to convert Integer to int and then
   Perform operation which is very time consuming
   
 
Solution :
=========
Use primitive type functional Interface when input or output is primitive

Predicate :
----------
1. interface IntPredicate {
     public boolean test(int i);
   }
2. interface LongPredicate {
     public boolean test(long i);
   }
3. interface DoublePredicate {
    public boolean test(double i);
   }
   
   
Function :
----------
Input is int and return type could be anything you specify (Integer, Double...)
1. interface IntFunction<R> {
	 public R  apply(int i);
   }

   LongFunction<R>, DoubleFuction<R>
   
Suppose you want length of String using Function Still in this case it need to do auto boxing before return result.
Better solution is ToIntFunction   
2. interface ToIntFunction<T> {
      public int applyAsInt(T t);
   }
   ToIntFunction<String> tif = s -> s.length;
   
   ToLongFucntion<T> - applyAsLong(T)
   ToDoubleFucntion<T> - applyAsDouble(T)
   
3. interFace IntToDoubleFunction<> {
     public double applyAsDouble(int t);
   }
   
   IntToLongFunction - applyAsLong(int i)
   LongToIntFunction - applyAsInt(long)
   LongToDoubleFucntion - applyAsDouble(long)
   
   DoubleToIntFunction - applyAsInt(double)
   DoubleToLongFunction - applyAsLong(double)
   
   
4. ToIntBiFunction<T1, T2> {
     public int applyAsInt(T1, T2);
   }
   
   ToLongBiFunction<T1, T2> : applyAsLong(T1, T2)
   ToDoubleBiFunction<T1, T2> : applyAsDouble(T1, T2)



Consumer :
---------
1. interface IntConsumer {
      public void accept(int i);
   }

   IntConsumer c = i -> System.out.println(i * i);
   No internal auto boxing and un-boxing required
   
2. interface LongConsumer {
     public void accept(long i);
   }
   
3. interface DoubleConsumer {
      public void accept(double i);
   }
   
4. interface ObjIntConsumer<T> {
     public void accept(T t, int i);
   }
5. interface ObjLongConsumer<T> {
     public void accept(T t, long i);
   }
6. interface DoubleConsumer<T> {
    public void accept(T t, double d);
   }
   

   
Supplier :
---------
1. interface IntSupplier {
      public int getAsInt();
   }
   
   IntSupplier s = () -> (int) (Math.random() * 10) ;

2. interface LongSupplier {
      public long getAsLong();
   }
   
3. interface DoubleSupplier {
      public double getAsDouble();
   }
4. interface BooleanSupplier {
      public boolean getAsBoolean();
   }
   
   
   
Unary Operator :
===============
if input and return type is same for function then use unary operator
Work same as Function<T, R>

interface UnaryOperator<T> {
   public T apply(T t);
}
// But this require so many auto boxing and unboxing 
// Better to go for Primitive UnaryOperator

interface IntUnaryOperator {
   public int applyAsInt(int i);
}

IntUnaryOperator f= i -> i * i;
// Now no autoboxing and unboxing require
 
 
 
interface LongUnaryOperator {
   public long applyAsLong(long l);
}

interface DoubleUnaryOpertor {
   public double applyAsDouble(double d);
}


Binary Operator :
================
It just similar to BiFunction<T1, T2, R>
and T1 and T2 and R are same type then go for Binary Operator

interface BinaryOperator<T> {
  public T apply(T1, T2);
}

BinaryOperator<Integer> bo = (i, j) -> i * j;
// Lots of auto boxing and unboxing require

1. interface IntBinaryOperator {
    public int applyAsInt(int i, int j)
   }

   IntBinaryOpertor bo1 = (i, j) -> i * j;
   // No Auto boxing and unboxing require

2. interface LongBinaryOpertor {
     public long applyAsLong(long, long)
   }
3  interface DoulbeBinaryOpertor {
     public double applyAsDouble(double, double);
   }
 
 

  */

class Movie {
	String name;
	String actor;
	String actress;
	public Movie(String name, String actor, String actress) {
		super();
		this.name = name;
		this.actor = actor;
		this.actress = actress;
	}
	@Override
	public String toString() {
		return "Movie [name=" + name + ", actor=" + actor + ", actress=" + actress + "]";
	}
	
	
}
public class PreDefindFunctionalInterface {
	public static void main(String[] args) {
		//Predicate examples 
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(100));
		System.out.println(p.test(9));
		//System.out.println(p.test(""));  //Compiler error incompatible type
		
		Predicate<List> p2 = c -> c.isEmpty();
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(p2.test(list));
		
		
		Predicate<String> p3 = s -> s.length() > 5;
		System.out.println(p3.test("abc"));
		
		Predicate<String> p4 = s -> s.length() < 2;
		System.out.println(p3.test("abc"));
		
		
		
		//Predicate joining, These are default method
		p3.negate();// Return negation of predicate
		p3.and(p4); // return true if both are true, Both type must be same
		p3.or(p4); // return true if any 1 is true, Both type must be same
		
		
		// Predicate isEqual method, which is static method.
		Predicate<String> p5 = Predicate.isEqual("Maneesh");
		System.out.println(p5.test("Maneesh")); //True
		
		Movie movie = new Movie("Bahubali", "Prabhas", "Tamanna");
		Predicate<Movie> p6 = m -> m.name.equals("Bahubali");
		System.out.println(p6.test(movie));
		
		// Check sum of 2 int value is even
		BiPredicate<Integer, Integer> p7 = (a, b) -> (a + b) % 2 == 0;
		System.out.println(p7);
		
		
		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("Maneesh"));
		
		//Remove all spaces from string
		Function<String, String> f1 = s -> s.replaceAll(" ", "");
		System.out.println(f1.apply("Maneesh Dhakad"));
		
		//Count all spaces from string
		Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", "").length();
		System.out.println(f2.apply("Maneesh Dhakad"));
		
		Function<Movie, String> f6 = m -> m.name + " and Bahubali 2";
		System.out.println(f6.apply(movie));
		
		//Chaining function, these are default methods
		Function<Integer, Integer> f3 = i -> i + i;
		Function<Integer, Integer> f4 = i -> i * i * i;
		System.out.println(f3.andThen(f4).apply(2)); // First execute f1 and then f2
		System.out.println(f3.compose(f4).apply(2)); // First execute f2 and then f1
		
		
		BiFunction<Integer, Integer, Integer> f5 = (i, j) -> i + j;
		System.out.println(f5.apply(2, 3));
		
		//Consumer 
		Consumer<String> c1 = s -> System.out.println(s);
		c1.accept("Maneesh");
		//forEach take consumer and implement accept method
		list.forEach(a -> System.out.println(a));
		
		//Chaining
		Consumer<Movie> c2 = m -> System.out.println(m + " C2 ");
		Consumer<Movie> c3 = m -> System.out.println(m + " C3 ");
		Consumer<Movie> c4 = m -> System.out.println(m + " C4 ");
		
		Consumer<Movie> chainedC = c2.andThen(c3).andThen(c4);
		chainedC.accept(movie);
		
		BiConsumer<Integer, Integer> c5 = (i, j) -> System.out.println(i+j);
		c5.accept(2, 3);
		
		
		//Supplier
		Supplier<Date> s = () -> new Date();
		System.out.println(s.get());
		//Get random name all the time
		Supplier<String> s1 = () -> {
							    String[] sList= { "maneesh", "bunny", "linni", "chinni" };
							    int x = (int) (Math.random() * 4);
							    //Math.random() :  return 0 < random < 1
							    return sList[x];
		                      };
		System.out.println(s1.get());
		
		//Generate some random 6 digit otp
		Supplier<String> s2 = () -> {
								String otp = "";
								for(int i = 0; i < 6 ;i++) {
									
									otp = otp + (int) (Math.random()*10);
		                        }
								return otp;
		                      };
	    
		System.out.println("6 Digit OTP = " + s2.get());
		
		//generate 8 digit random password
		Supplier<String> s3 = () -> {
			String password = "";
			Supplier<Integer> digit = () -> (int) (Math.random()*10);
			String allChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
			Supplier<Character> ch = () -> {
				int x = (int) (Math.random()*29);
				return allChar.charAt(x);
			};
			for(int i = 0; i < 8 ;i++) {
				if(i % 2 == 0)
					password = password + digit.get();
				else 
					password = password + ch.get();
            }
			return password;
          };
          System.out.println("8 Digit random password : " + s3.get());
          
          
          
          
          
          
          
          
          //Primitive type functional Interface, Always use primitive function interface when lots of calculation required
          IntPredicate  ip = i -> i % 2 == 0;
          System.out.println(ip.test(2));
          
          IntFunction<Integer> ifun = i -> i * i;
          System.out.println(ifun.apply(2));
          
          
          Function<String, Integer> f8 = ss -> ss.length();
          System.out.println(f8.apply(""));
          // Auto boxing before return result
          // Better solution is to use ToIntFunction
          
          ToIntFunction<String> tif = ss -> ss.length();
          System.out.println(tif.applyAsInt(""));
          //Now auto boxing is not required before return
         
          IntToDoubleFunction itd = i -> Math.sqrt(i);
          System.out.println(itd.applyAsDouble(7));
          
          
          
          Supplier<String> s4 = () -> {
  			String password = "";
  			//No Auto boxing required
  			IntSupplier digit = () -> (int) (Math.random()*10);
  			String allChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
  			Supplier<Character> ch = () -> {
  				int x = (int) (Math.random()*29);
  				return allChar.charAt(x);
  			};
  			for(int i = 0; i < 8 ;i++) {
  				if(i % 2 == 0)
  					password = password + digit.getAsInt();
  				else 
  					password = password + ch.get();
              }
  			return password;
            };
           System.out.println(s4);
		
	}

}
