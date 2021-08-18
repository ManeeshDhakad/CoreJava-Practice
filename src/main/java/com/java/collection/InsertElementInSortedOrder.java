package com.java.collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
 
class Book1 {  
	int id;  
	String name,author,publisher;  
	int quantity;  
	public Book1(int id, String name, String author, String publisher, int quantity) {  
		this.id = id;  
		this.name = name;  
		this.author = author;  
		this.publisher = publisher;  
		this.quantity = quantity;  
	}
	@Override
	public String toString() {
		return "Book1 [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", quantity="
				+ quantity + "]";
	}
}  
public class InsertElementInSortedOrder {  
	public static void main(String[] args) {  
		//Insert in ascending order of id
		Set<Book1> set=new TreeSet<Book1>((o1, o2) -> o1.id - o2.id);    
		Book1 b1=new Book1(121,"Let us C","Yashwant Kanetkar","BPB",8);  
		Book1 b2=new Book1(233,"Operating System","Galvin","Wiley",6);  
		Book1 b3=new Book1(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
		set.add(b1);  
		set.add(b2);  
		set.add(b3);   
		for(Book1 b:set){  
			System.out.println(b);  
		}
		
		//Insert descending order of key
		Map<Integer,Book1> map=new TreeMap<Integer,Book1>((o1, o2) -> o2.intValue() - o1.intValue());    
		
		map.put(4, b1);  
		map.put(5, b2);  
		map.put(6, b3);   
		for(Integer i:map.keySet()){  
			System.out.println(i + " " + map.get(i));  
		}
	}  
}  