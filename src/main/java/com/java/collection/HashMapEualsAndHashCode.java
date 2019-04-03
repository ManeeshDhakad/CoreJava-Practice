package com.java.collection;

import java.util.HashMap;
import java.util.Map;

/*
Equals() and hashCode() contract:
1. Should get same int value class hashCode on same object at any number of times
2. When two objects are equal then they should have same hash value
3. When two objects having same hash code then they may or may not equal.

If you will not implement equals and hashCode methods correctly then emp1.equals(emp2) will be false
Because it calls Objects equals method which check reference not contents.
   
And not implementing hashCode will give different hashCode for both object.
And you are end up storing Duplicate elements into map
   
So always give implementation of hashCode and equals method when you are storing your
object on collection specially with Map.
   
Note : Strings equals methods check content 
 
 * 
 */
class Employee {
	private String name;
	private String address;
	
	public Employee(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int hashCode() {
		int hash = name.hashCode() + 10;
		System.out.println("Hash Code = " + hash);
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Employee) {
			Employee emp = (Employee) obj;
			if(this.name.equals(emp.getName()) && this.address.equals(emp.getAddress()))
				return true;
		}
		
		return false;
	}
	
}

class Project {
	private int pid;
	Project() {
		this.pid = (int) ((Math.random()) + 1);
	}
}
public class HashMapEualsAndHashCode {
	public static void main(String args[])
	{
		Map<Employee, Project> map = new HashMap<>();
		Employee emp1 = new Employee("N4", "A4");
		Employee emp2 = new Employee("N4", "A4");
		map.put(emp1, new Project());
		map.put(emp2, new Project());
		
		System.out.println("Compare emp1 and emp2 = " + emp1.equals(emp2));
		
		System.out.println("Size of map = " + map.size());
	}
}

