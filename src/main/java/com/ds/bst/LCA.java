package com.ds.bst;

public class LCA {
	Node root;

	static Node lca(Node root, int n1, int n2)
	{
		while (root != null)
		{
			// If both n1 and n2 are smaller
			// than root, then LCA lies in left
			if (root.data > n1 &&
					root.data > n2)
				root = root.left;

			// If both n1 and n2 are greater
			// than root, then LCA lies in right
			else if (root.data < n1 &&
					root.data < n2)
				root = root.right;

			else break;
		}
		return root;
	}


	/* Driver program to test lca() */
	public static void main(String args[])
	{
		// Let us construct the BST shown in the above figure
		LCA tree = new LCA();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

	}
}
//This code is contributed by SHUBHAMSINGH10
