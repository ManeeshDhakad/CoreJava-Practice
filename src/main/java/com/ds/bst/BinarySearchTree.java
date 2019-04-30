
package com.ds.bst;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Node {
	Node left;
	Node right;
	int data;

	Node(int data) {
		left = null;
		right = null;
		this.data = data;
	}
}

public class BinarySearchTree {

	static Node insert(Node root, int data) {
		if(root == null) {
			return new Node(data);
		} else {
			if(root.data > data) {
				root.left = insert(root.left, data);
			}
			if(root.data < data) {
				root.right = insert(root.right, data);
			}
			return root;
		}

	}

	static boolean searchBST(Node root,int data){
		if(root == null)
			return false;
		else {
			if(root.data == data)
				return true;
			else if(root.data < data)
				return searchBST(root.right, data);
			else 
				return searchBST(root.left, data);

		}
	}

	static void printInOrder(Node root, List<Integer> inorder) {
		if(root == null)
			return;
		printInOrder(root.left, inorder);
		System.out.println(root.data);
		inorder.add(root.data);
		printInOrder(root.right, inorder);

	}

	static boolean doTest() {
		Node root = new Node(30);
		insert(root, 20);
		insert(root, 50);
		insert(root, 40);
		insert(root, 24);

		List<Integer> inorder = new ArrayList<Integer>();
		printInOrder(root, inorder);


		boolean result = Arrays.asList(20,24,30, 40 ,50).equals(inorder) && searchBST(root, 24)  && searchBST(root, 50);
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

