package com.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class SpyTest {

	@Test
	public void testLinkedListSpyWrong() {
	    // Lets mock a LinkedList
	    List<String> list = new LinkedList<>();//list.add("Maneesh");
	    List<String> spy = spy(list);

	    // this does not work
	    // real method is called so spy.get(0)
	    // throws IndexOutOfBoundsException (list is still empty)
	    System.out.println(when(spy.get(0)).thenReturn("foo"));

	    assertEquals("foo", spy.get(0));
	    System.out.println(list.get(0));
	}

	@Test
	public void testLinkedListSpyCorrect() {
	    // Lets mock a LinkedList
	    List<String> list = new LinkedList<>();
	    List<String> spy = spy(list);

	    // You have to use doReturn() for stubbing
	    doReturn("foo").when(spy).get(0);

	    assertEquals("foo", spy.get(0));
	}

}
