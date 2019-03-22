package com.java.collection;

import java.util.Enumeration;
import java.util.Vector; 
public class VectorDemo { 
   public static void main(String args[]) { 
     Vector<Integer> v = new Vector<Integer>(3, 2); 
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
} 
