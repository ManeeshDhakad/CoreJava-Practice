import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;



public class Main { 
	
    public static void main(String args[]) { 
    	List<Integer> list = Arrays.asList(4, 1, 6, 5, 8, 3);
    	Collections.sort(list, (o1, o2) -> o2-o1);
    	
        for(Integer a : list) System.out.println(a);
    }
} 