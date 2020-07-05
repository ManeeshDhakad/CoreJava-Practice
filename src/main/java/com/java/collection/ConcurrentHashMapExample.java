package com.java.collection;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample
{
    public static void main(String[] args)
    {
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
    
    
}


