package com.java.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/*

1. If the superclass method does not declare an exception, subclass overridden method cannot declare the 
   checked exception but it can declare unchecked exception.
2. If the superclass method declares an exception, subclass overridden method can declare same, 
   subclass exception or no exception but cannot declare parent exception.
 */

public class ExceptionTest1 {

	public void noExp()  {}
	
	public void checkedEXP() throws IOException{		
	}
	
	public void unCheckEXP() throws NullPointerException{
		
	}
	
	
}

class ExceptionTest2 extends ExceptionTest1{
	public void noExp() {}
	//public void noExp() throws NullPointerException {}
	//Can not throw checked exception //public void noExp() throws IOException {}
	
	
	//public void checkedEXP() {}	
	//public void checkedEXP() throws IOException{}	
	public void checkedEXP() throws FileNotFoundException{}	
	//Can not throw parent exception //public void checkedEXP() throws Exception{}	
	
	
	//public void unCheckEXP() {}
	public void unCheckEXP() throws NullPointerException{}
	//Can not throw parent exception //public void unCheckEXP() throws Exception{}
}