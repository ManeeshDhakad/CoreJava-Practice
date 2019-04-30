package com.ds.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node1 {
	Node1 next;
	int data;
	Node1(int data) {
		this.data = data;
		next = null;
	}
}

public class ReverseLinkedList { 
	static Node1 insert(Node1 head, int data) {
		Node1 newNode = new Node1(data);
		if(head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	static Node1 reverse(Node1 head) {
		Node1 curr = head;
		Node1 prev = null;
		Node1 next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	static void print(Node1 head, List<Integer> list) {
		Node1 curr = head;
		while(curr != null) {
			list.add(curr.data);
			curr = curr.next;
		}
		System.out.println(list);
	}


	static boolean doTest() {
		Node1 head = insert(null, 10);
		head = insert(head, 20);
		head = insert(head, 30);
		head = insert(head, 40);
		List<Integer> list = new ArrayList<Integer>();
		print(head, list);

		boolean result = Arrays.asList(40, 30, 20, 10).equals(list);                 
		head = reverse(head);
		list = new ArrayList<Integer>();
		print(head, list);
		result = result && Arrays.asList(10, 20, 30, 40).equals(list);
		return result;
	}
	public static void main(String[] args) {
		if(doTest()) {
			System.out.println("All Passed");
		} else {
			System.out.println("Some Failed");
		}
	}
}
