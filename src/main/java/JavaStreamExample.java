import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import javax.naming.directory.InvalidAttributesException;  

class abc {
	void show() throws InvalidAttributesException{
		System.out.println("ABC");
		try {
			int i = 100 / 0;
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument Exception ......");
		}
	}
}
public class JavaStreamExample{  
	void show() {
		List arr = new ArrayList();
		
		System.out.println("Sub");
		abc obj = new abc();
		try {
			obj.show();
		} catch(Exception e) {
			System.out.println("Error occured" + e);
		}
	}
    public static void main(String[] args){  
    	JavaStreamExample obj1 = new JavaStreamExample();
    	obj1.show();
    }  
}  