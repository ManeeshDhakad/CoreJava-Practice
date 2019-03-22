package com.java.collection;

import java.util.LinkedList; 
import java.util.List;
import java.util.Queue; 
public class LinkedListDemo { 
   public static void main(String[] args) { 
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
} 
