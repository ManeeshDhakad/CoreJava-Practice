package com.java.collection;

import java.util.Iterator;


// Option 1
interface MyIterator<T> {
	boolean hasNext();
	T next();
	void remove();
}

class MyItems<T> implements MyIterator<T> {
	private T[] arrayList;
	private int currentSize;

	public MyItems(T[] newArray) {
		this.arrayList = newArray;
		this.currentSize = arrayList.length;
	}

	private int currentIndex = 0;

	@Override
	public boolean hasNext() {
		return currentIndex < currentSize && arrayList[currentIndex] != null;
	}

	@Override
	public T next() {
		return arrayList[currentIndex++];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}

public class CustomIterator {
	public static void main(String[] args) {
		String[] names = {"Apple","Banana", "Orange"};
		MyItems<String> productNames = new MyItems<String>(names);
		
		Integer[] quantities = {4, 12, 6};
		MyItems<Integer> productQuantities = new MyItems<Integer>(quantities);
		
		while(productNames.hasNext())
			System.out.println(productNames.next());
		
		while(productQuantities.hasNext())
			System.out.println(productQuantities.next());
	}
}


// Option 2 
class CustomIterator2<Type> implements Iterable<Type> {

	private Type[] arrayList;
	private int currentSize;

	public CustomIterator2(Type[] newArray) {
		this.arrayList = newArray;
		this.currentSize = arrayList.length;
	}

	@Override
	public Iterator<Type> iterator() {
		Iterator<Type> it = new Iterator<Type>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < currentSize && arrayList[currentIndex] != null;
			}

			@Override
			public Type next() {
				return arrayList[currentIndex++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}
}
