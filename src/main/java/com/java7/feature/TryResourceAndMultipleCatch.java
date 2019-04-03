package com.java7.feature;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryResourceAndMultipleCatch {
	public static void main(String args[]) 	{
		try (  FileReader fr = new FileReader("abc.txt");
			   FileWriter fw = new FileWriter("def.txt");
			) {

			// some file copying code
		}            // at this point fr and fw are closed
		catch (IOException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		finally {
		
		}
	}
}
