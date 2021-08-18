package com.ds.array;

import java.util.Arrays;

public class CountPairDiff {

	static int countPairsWithDiffK(int arr[], int n,
			int k)
	{
		int count = 0;
		Arrays.sort(arr); // Sort array elements

		int l = 0;
		int r = 0;
		while(r < n)
		{
			if(arr[r] + arr[l] == k)
			{
				System.out.println(arr[r] + " " + arr[l]);
				count++;
				l++;
				r++;
			}
			else if(arr[r] + arr[l] > k)
				l++;
			else // arr[r] + arr[l] < sum
				r++;
		}
		return count;
	}

	//Driver program to test above function
	public static void main(String[] args)
	{
		int arr[] = {1, 5, 3, 4, 2};
		int n = arr.length;
		int k = 3;
		System.out.println("Count of pairs with given diff is " +
				countPairsWithDiffK(arr, n, k));
	}
}
