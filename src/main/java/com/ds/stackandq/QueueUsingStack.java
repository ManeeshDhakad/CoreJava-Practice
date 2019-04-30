package com.ds.stackandq;

/*
Enqueue Costly :
==============
enQueue(q, x)
  1) While stack1 is not empty, push everything from stack1 to stack2.
  2) Push x to stack1 (assuming size of stacks is unlimited).
  3) Push everything back to stack1.
Here time complexity will be O(n)

deQueue(q)
  1) If stack1 is empty then error
  2) Pop an item from stack1 and return it
Here time complexity will be O(1)


DeQueue Costly :
===============
enQueue(q,  x)
  1) Push x to stack1 (assuming size of stacks is unlimited). Here time complexity will be O(1)

deQueue(q)
  1) If both stacks are empty then error.
  2) If stack2 is empty While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it. Here time complexity will be O(n)
 */
import java.util.*; 

public class QueueUsingStack { 
	static class Queue 
	{ 
		static Stack<Integer> s1 = new Stack<Integer>(); 
		static Stack<Integer> s2 = new Stack<Integer>(); 

		
		//Costly enQueue() 
		static void enQueue(int x) { 
			// Move all elements from s1 to s2 
			while (!s1.isEmpty()) { 
				s2.push(s1.pop()); 
				//s1.pop(); 
			} 

			// Push item into s1 
			s1.push(x); 

			// Push everything back to s1 
			while (!s2.isEmpty()) { 
				s1.push(s2.pop()); 
				//s2.pop(); 
			} 
		} 

		// Dequeue an item from the queue 
		static int deQueue() { 
			// if first stack is empty 
			if (s1.isEmpty()) { 
				System.out.println("Q is Empty"); 
				System.exit(0); 
			} 

			// Return top of s1 
			int x = s1.pop(); 
			return x; 
		} 
		
		
		
	}; 

	//Driver code 
	public static void main(String[] args) 
	{ 
		Queue q = new Queue(); 
		q.enQueue(1); 
		q.enQueue(2); 
		q.enQueue(3); 

		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue()); 
	} 
} 
