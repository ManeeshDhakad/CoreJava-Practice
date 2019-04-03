package com.java.core;

public class ObjectCloneing implements Cloneable
{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    String name = "GeeksForGeeks";
 
    public static void main(String[] args) {
    	ObjectCloneing obj1 = new ObjectCloneing();
        try {
        	ObjectCloneing obj2 = (ObjectCloneing) obj1.clone();
            System.out.println(obj2.name);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}