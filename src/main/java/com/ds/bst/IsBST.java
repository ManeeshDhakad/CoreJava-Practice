package com.ds.bst;

public class IsBST {

	static class Node
	{
		int data;
		Node left, right;
	};

	//Approach 1
	static boolean isBST(Node root, Node l, Node r)
	{
		// Base condition
		if (root == null)
			return true;

		// if left node exist then check it has
		// correct data or not i.e. left node's data
		// should be less than root's data
		if (l != null && root.data <= l.data)
			return false;

		// if right node exist then check it has
		// correct data or not i.e. right node's data
		// should be greater than root's data
		if (r != null && root.data >= r.data)
			return false;

		// check recursively for every node.
		return isBST(root.left, l, root) &&
				isBST(root.right, root, r);
	}
	
	
	//Approach 2
	boolean isBST2(Node root)  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
    

	//Helper function that allocates a new node with the
	//given data && null left && right pointers. /
	static Node newNode(int data)
	{
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return (node);
	}

	//Driver code
	public static void main(String args[])
	{
		Node root = newNode(3);
		root.left = newNode(2);
		root.right = newNode(5);
		root.left.left = newNode(1);
		root.left.right = newNode(4);

		if (isBST(root,null,null))
			System.out.print("Is BST");
		else
			System.out.print("Not a BST");
	}
}
