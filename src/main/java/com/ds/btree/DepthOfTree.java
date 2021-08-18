package com.ds.btree;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfTree {
	Node root;

	//Max height
	int maxDepth(Node node)
	{
		if (node == null)
			return 0;
		else
		{
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
	
	//Min height
	int minDepth(Node node)
	{
		if (node == null)
			return 0;
		else
		{
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			/* use the larger one */
			if (lDepth < rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
	
	//Max height without recursion
	void levelOrderMaxHight(Node node) {
		Queue<Node> q = new LinkedList<>();

		q.add(node);
		q.add(null);
        int maxHeight = 0;
        
		while (!q.isEmpty()) {

			Node curr = q.poll();

			if (curr == null) {
				maxHeight++;
				if (!q.isEmpty()) {
					q.add(null);
		
				}
			} else {
				// Pushing left child current node
				if (curr.left != null)
					q.add(curr.left);

				// Pushing right child current node
				if (curr.right != null)
					q.add(curr.right);
			}
			

		}
		
		System.out.println("Max height level order : " + maxHeight);
	}
	
	//Min height without recursion
	void levelOrderMinHight(Node node) {
			Queue<Node> q = new LinkedList<>();

			q.add(node);
			q.add(null);
	        int minHeight = 1;
	        
			while (!q.isEmpty()) {

				Node curr = q.poll();

				if (curr == null) {
					minHeight++;
					if (!q.isEmpty()) {
						q.add(null);
					}
				} else {
					// Pushing left child current node
					if (curr.left != null)
						q.add(curr.left);

					// Pushing right child current node
					if (curr.right != null)
						q.add(curr.right);
				}
				
				if(curr != null && curr.left == null && curr.right == null) {
					break;
				}
				

			}
			
			System.out.println("Min height level order : " + minHeight);
	}
	
	
	/* Driver program to test above functions */
	public static void main(String[] args)
	{
		DepthOfTree tree = new DepthOfTree();

		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);
		tree.root.right.right = new Node(9);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.right = new Node(7);
		tree.root.left.left.left.left = new Node(10);
		tree.root.left.left.left.right = new Node(11);

		System.out.println("Max Height of tree is : " +
									tree.maxDepth(tree.root));
		
		System.out.println("Min Height of tree is : " +
				tree.minDepth(tree.root));
		
		tree.levelOrderMaxHight(tree.root);
		
		tree.levelOrderMinHight(tree.root);
	}
}

//This code has been contributed by Mayank Jaiswal(mayank_24)
