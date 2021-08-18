package com.java.collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionExample {
	public void ArrayList() {
		List<Object> list = new ArrayList<Object>();
        list.add(100);
        list.add("Learning Core Java");
        list.add("Array List"); 
        
        Iterator<Object> iterator = list.listIterator();
        while(iterator.hasNext()) {
        
            System.out.println(iterator.next());
        }
	}
	
	public void Vector() {
		Vector<Integer> v = new Vector<Integer>(3, 5); 
	     System.out.println("Initial capacity: " + v.capacity());
	     v.addElement(new Integer(1));
	     v.addElement(new Integer(2)); 
	     v.addElement(new Integer(3));
	     v.addElement(new Integer(4));
	     System.out.println("New Capacity: " + v.capacity());
	     Enumeration<Integer> vEnum = v.elements(); 
	     System.out.println("\nElements in vector:");
	     while(vEnum.hasMoreElements()) {
	        System.out.print(vEnum.nextElement() + " ");
	     } 
	}
	
	public void LinkedList() {
		List<String> names = new LinkedList<>(); 
	      Queue<Integer> ages = new LinkedList<>();
	      names.add("Rams"); 
	      names.add("Posa"); 
	      names.add("Chinni");
	      ages.add(20);
	      ages.add(25);
	      ages.add(30);
	      // Delete first element based on FIFO
	      ages.remove();
	      System.out.println("LinkedList Content: " + names); 
	      System.out.println("Queue Content: " + ages); 
	}
	
	public void ConcurrentHashMap() {
		ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        
        System.out.println("for keySet to iterate which include newly added value in for loop"); 
        for(String a : premiumPhone.keySet() ) {
     	   System.out.println(premiumPhone.get(a));
     	  premiumPhone.put("MI", "Redmi Note 7 Pro");
        }
        
        
        System.out.println("\nFail safe iterator which takes copy of map");
        Iterator iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        
        System.out.println("\nFail safe iterator which takes copy of map, Which now can include ast added record.");
        iterator = premiumPhone.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia M");
        }
	}
	public static void main(String[] args) {
        
      
    }

}
