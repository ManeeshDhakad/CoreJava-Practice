package com.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList {
	public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        list.add(100);
        list.add("Learning Core Java");
        list.add("Array List"); 
        
        Iterator<Object> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
      
    }

}
