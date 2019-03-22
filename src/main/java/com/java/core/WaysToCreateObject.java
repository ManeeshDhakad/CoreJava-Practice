package com.java.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WaysToCreateObject implements Cloneable{

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) {
		try( 
				ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream("file.txt"));	
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));

				) {
			// 1. New Keyword
			WaysToCreateObject object1 = new WaysToCreateObject();

			// 2. Object Cloning
			WaysToCreateObject object2 = (WaysToCreateObject)object1.clone();

			// 3. Reflection 
			WaysToCreateObject object4 = (WaysToCreateObject) 
					Class.forName("WaysToCreateObject").newInstance();

			// 4. D-Serialization
			out.writeObject(object1);
			WaysToCreateObject emp = (WaysToCreateObject)in.readObject();
			
		}
		catch(Exception ex) {

		}

	}

}
