package com.java.collection;


interface MyEnumerator<T> {
	boolean hasMoreElement();
	T nextElement();
	void remove();
}

class MyItems1<T> implements MyEnumerator<T> {
	private T[] arrayList;
	private int currentSize;

	public MyItems1(T[] newArray) {
		this.arrayList = newArray;
		this.currentSize = arrayList.length;
	}

	private int currentIndex = 0;

	@Override
	public boolean hasMoreElement() {
		return currentIndex < currentSize && arrayList[currentIndex] != null;
	}

	@Override
	public T nextElement() {
		return arrayList[currentIndex++];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}

public class CustomEnumerator {
	public static void main(String[] args) {
		String[] names = {"Apple","Banana", "Orange"};
		MyItems1<String> productNames = new MyItems1<String>(names);
		
		Integer[] quantities = {4, 12, 6};
		MyItems1<Integer> productQuantities = new MyItems1<Integer>(quantities);
		
		while(productNames.hasMoreElement())
			System.out.println(productNames.nextElement());
		
		while(productQuantities.hasMoreElement())
			System.out.println(productQuantities.nextElement());
	}
}
