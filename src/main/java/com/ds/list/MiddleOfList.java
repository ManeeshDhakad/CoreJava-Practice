package com.ds.list;

import com.ds.list.LoopInLinkedList.Node;

public class MiddleOfList {

	static Node head; 


	void findMiddleNode(Node node) { 
		if (node == null || node.next == null) 
			return; 

		Node slow = node, fast = node;

		// Search for loop using slow and fast pointers 
		while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next; 
		}
		
		System.out.println("Middle Node : " + slow.data);
	} 

	// Driver program to test above functions 
	public static void main(String[] args) { 
		MiddleOfList list = new MiddleOfList(); 
		list.head = new Node(50); 
		list.head.next = new Node(20); 
		list.head.next.next = new Node(15); 
		list.head.next.next.next = new Node(4); 
		list.head.next.next.next.next = new Node(10); 

		list.findMiddleNode(list.head);
	} 
} 