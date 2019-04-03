package com.java.serialization;


import java.io.*;

/*
 *  1. If don't use serialVersionUID
 *     After serialization if you add new variable or change class structure 
 *     Then try to perform D-Serialization then it will throw "java.io.InvalidClassException"
 *  2. If use serialVersionUID
 *     For above scenario it will recover old serialized object without throwing any exception
 *     It will assign default value to new variable based on data-type 
 *  3. If Parent class is not implementing  Serializable interface than 
 *     Serialization will complete successful
 *     D-Serialization will throw "java.io.InvalidClassException"
 *  4. If using any reference which is not implementing  Serializable interface than 
 *     It will throw "java.io.NotSerializableException" as soon as you try to serialize it.
 *  5. If you super class is implementing Serializable interface and you don't want to 
 *     Serialize your sub class then override readObject() and writeObject() methods in sub class
 *     and throw NotSerializableException 
 * 
 */

class Company {
	private int id;
	private String name;
	
	public Company(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

class Employee /*extends Company*/ implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String address;
	Company company;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	Employee(int id, String name)
	{
		//super(1, "Company");
		this.id = id;
		this.name = name;
		
		company = new Company(1, "Company");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

class Abc extends Employee{

	Abc(int id, String name) {
		super(id, name);
	}
	
	private void readObject(ObjectInputStream aInputStream) throws IOException
    {      
       throw new NotSerializableException("Dont allow this class to serialize");
    }
 
    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
    	throw new NotSerializableException("Dont allow this class to serialize");
    }
	
}
class Serialization
{
	public static void main(String[] args)
	{
		try
		{
			//Serialization 
			ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream("file.txt"));
			out.writeObject(new Employee(1, "Maneesh"));
			out.close();
			System.out.println("Serialization completed");
			
			
			//D-Serialization
	        ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
	        Employee emp = (Employee)in.readObject();
	        System.out.println("D-Serialization completed");
	        System.out.println("Employee Id : " + emp.getId() + " , Name : " + emp.getName() + " , "
	        		+ "Address : " + emp.getAddress() + " , Company : " + emp.company.getName());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}