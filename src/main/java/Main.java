class a {
	int aa;
}

public class Main { 
	
    public static void main(String args[]) { 
    	a a1 = new a();a1.aa = 5;
    	a a2 = new a();a2.aa = 10;
    	swap(a1, a2);
    	System.out.println(a1.aa);
    }
    
    public static void swap(a a1, a a2) {
    	int  temp = a1.aa;
    	a1.aa = a2.aa;
    	a2.aa = temp;
    }
} 