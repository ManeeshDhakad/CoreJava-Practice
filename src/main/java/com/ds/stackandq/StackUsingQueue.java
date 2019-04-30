package com.ds.stackandq;

/*
Push operation costly :
=====================
push(s, x) // x is the element to be pushed and s is stack
  1) Enqueue x to q2
  2) One by one dequeue everything from q1 and enqueue to q2.
  3) Swap the names of q1 and q2 
// Swapping of names is done to avoid one more movement of all elements 
// from q2 to q1. 

pop(s)
  1) Dequeue an item from q1 and return it.


Pop operation costly:
====================
push(s,  x)
  1) Enqueue x to q1 (assuming size of q1 is unlimited).

pop(s)  
  1) One by one dequeue everything except the last element from q1 and enqueue to q2.
  2) Dequeue the last item of q1, the dequeued item is result, store it.
  3) Swap the names of q1 and q2
  4) Return the item stored in step 2.
// Swapping of names is done to avoid one more movement of all elements 
// from q2 to q1.

 */

import java.util.*; 

public class StackUsingQueue  { 

	static class Stack  
	{  
		// Two inbuilt queues  
		static Queue<Integer> q1 = new LinkedList<Integer>(); 
		static Queue<Integer> q2 = new LinkedList<Integer>();  


		static void push(int x)  {    

			// Push x first in empty q2  
			q2.add(x);  

			// Push all the remaining  
			// elements in q1 to q2.  
			while (!q1.isEmpty()) {  
				q2.add(q1.peek());  
				q1.remove();  
			}  

			// swap the names of two queues  
			Queue<Integer> q = q1;  
			q1 = q2;  
			q2 = q;  
		}  

		static void pop(){  

			// if no elements are there in q1  
			if (q1.isEmpty())  
				return ;  
			q1.remove();  
		}  

		static int top()  
		{  
			if (q1.isEmpty())  
				return -1;  
			return q1.peek();  
		}  

	  
	};  

	// driver code  
	public static void main(String[] args)  
	{  
		Stack s = new Stack();  
		s.push(1);  
		s.push(2);  
		s.push(3);  


		System.out.println(s.top());  
		s.pop();  
		System.out.println(s.top());  
		s.pop();  
		System.out.println(s.top());  

	} 
}  
