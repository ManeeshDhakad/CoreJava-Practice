package com.ds.array;

public class FindMinInRotateAndSortedArray {

	public static int FindMin(int a[]) {
		if (a == null)
			throw new IllegalArgumentException("Invalid input");

		if (a.length == 0)
			throw new IllegalArgumentException("Array is empty");
		
		return FindMinInArray(a, 0, a.length - 1);
	}

	private static int FindMinInArray(int a[], int left, int right) {

		// If there is only one element left 
		if (left == right)
			return a[left];

		// This condition is needed to handle the case when array 
        // is not rotated at all 
		if (left > right)
			return a[0];

		// Find mid 
        int mid = left + (right - left)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider 
        // the cases like {3, 4, 5, 1, 2} 
		if (mid < right && a[mid] > a[mid + 1])
			return a[mid + 1];
		
		// Check if mid itself is minimum element 
		if (mid > left && a[mid - 1] > a[mid])
			return a[mid];

		if (a[right] > a[mid])
			return FindMinInArray(a, left, mid - 1);

		return FindMinInArray(a, mid + 1, right);
	}

	public static void main(String args[]) {
		boolean result = true;
		result = result && FindMin(new int[] { 3, 4, 5, 6, 1, 2 }) == 1;
		result = result && FindMin(new int[] { 2, 1 }) == 1;
		result = result && FindMin(new int[] { 1 }) == 1;

		try {
			FindMin(null);
			result = false;
		} catch (Exception e) {
			result = result && true;
		}

		if (result) {
			System.out.println("All tests pass");
		} else {
			System.out.println("There are test failures");
		}
	}
}