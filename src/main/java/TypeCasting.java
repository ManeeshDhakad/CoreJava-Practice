import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class A {}
class B extends A {}
class C extends B {}

public class TypeCasting extends B {
	public static void main(String[] args) throws IOException {
		Queue<A> q = new LinkedList<A>();
		q.add(null);
		A a = q.remove();
		
	}
	Stack<Integer> e = new Stack<Integer>();
	
}
