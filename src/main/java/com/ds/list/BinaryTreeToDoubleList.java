package com.ds.list;

public class BinaryTreeToDoubleList {
	// root --> Root of Binary Tree
	TNode root;

	// head --> Pointer to head TNode of created doubly linked list
	TNode head;

	// A simple recursive function to convert a given
	// Binary tree to Doubly Linked List
	void BToDLL(TNode root)
	{
		// Base cases
		if (root == null)
			return;

		// Recursively convert right subtree
		BToDLL(root.right);

		// insert root into DLL
		root.right = head;

		// Change left pointer of previous head
		if (head != null)
			head.left = root;

		// Change head of Doubly linked list
		head = root;

		// Recursively convert left subtree
		BToDLL(root.left);
	}

	// Utility function for printing double linked list.
	void printList(TNode head)
	{
		System.out.println("Extracted Double Linked List is : ");
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	// Driver program to test the above functions
	public static void main(String[] args)
	{
		/* Constructing below tree
			5
			/ \
			3	 6
		/ \	 \
		1 4	 8
		/ \	 / \
		0 2	 7 9 */

		BinaryTreeToDoubleList tree = new BinaryTreeToDoubleList();
		tree.root = new TNode(5);
		tree.root.left = new TNode(3);
		tree.root.right = new TNode(6);
		tree.root.left.right = new TNode(4);
		tree.root.left.left = new TNode(1);
		tree.root.right.right = new TNode(8);
		tree.root.left.left.right = new TNode(2);
		tree.root.left.left.left = new TNode(0);
		tree.root.right.right.left = new TNode(7);
		tree.root.right.right.right = new TNode(9);

		tree.BToDLL(tree.root);
		tree.printList(tree.head);
	}
}

//This code has been contributed by Mayank Jaiswal(mayank_24)
