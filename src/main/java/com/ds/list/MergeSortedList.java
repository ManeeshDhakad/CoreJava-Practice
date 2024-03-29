package com.ds.list;

public class MergeSortedList {
	public Node SortedMerge(Node A, Node B)
	{
	
		if(A == null) return B;
		if(B == null) return A;
		
		if(A.data < B.data)
		{
			A.next = SortedMerge(A.next, B);
			return A;
		}
		else
		{
			B.next = SortedMerge(A, B.next);
			return B;
		}
		
	}
}