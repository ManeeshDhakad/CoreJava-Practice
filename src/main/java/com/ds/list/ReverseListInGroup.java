package com.ds.list;

import java.util.Stack;

public class ReverseListInGroup {

	/* Link list node */
	static class Node
	{
		int data;
		Node next;
	}
	static Node head = null;

	/* Reverses the linked list in groups of size k
and returns the pointer to the new head node. */
	static Node reverse1(Node head, int k)
	{
		// Create a stack of Node*
		Stack<Node> mystack = new Stack<Node> ();
		Node current = head;
		Node prev = null;

		while (current != null)
		{

			// Terminate the loop whichever comes first
			// either current == NULL or count >= k
			int count = 0;
			while (current != null && count < k)
			{
				mystack.push(current);
				current = current.next;
				count++;
			}

			// Now pop the elements of stack one by one
			while (mystack.size() > 0)
			{

				// If final list has not been started yet.
				if (prev == null)
				{
					prev = mystack.peek();
					head = prev;
					mystack.pop();
				}
				else
				{
					prev.next = mystack.peek();
					prev = prev.next;
					mystack.pop();
				}
			}
		}

		// Next of last element will point to NULL.
		prev.next = null;

		return head;
	}



	Node reverse2(Node head, int k)
	{
		if(head == null)
			return null;
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		/* next is now a pointer to (k+1)th node
	           Recursively call for the list starting from
	           current. And make rest of the list as next of
	           first node */
		if (next != null)
			head.next = reverse2(next, k);

		// prev is now head of input list
		return prev;
	}

	/* UTILITY FUNCTIONS */
	/* Function to push a node */
	static void push( int new_data)
	{
		/* allocate node */
		Node new_node = new Node();

		/* put in the data */
		new_node.data = new_data;

		/* link the old list off the new node */
		new_node.next = head;

		/* move the head to point to the new node */
		head = new_node;
	}

	/* Function to print linked list */
	static void printList(Node node)
	{
		while (node != null)
		{
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/* Driver code*/
	public static void main(String[] args)
	{
		/* Start with the empty list */
		//Node head = null;

		/* Created Linked list is 1->2->3->
	4->5->6->7->8->9 */
		push( 9);
		push( 8);
		push( 7);
		push( 6);
		push( 5);
		push(4);
		push(3);
		push(2);
		push( 1);

		System.out.println("Given linked list ");
		printList(head);
		head = reverse1(head, 3);
		System.out.println();

		System.out.println("Reversed Linked list ");
		printList(head);
	}
}

//This code is contributed by Prerna Saini
