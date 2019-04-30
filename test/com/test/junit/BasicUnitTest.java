package com.test.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
Test method should be public and void

@BeforeClass and @AfterClass method must be static because these are class methods not instance methods

*/

public class BasicUnitTest {
	static Logger logger = Logger.getLogger(BasicUnitTest.class);
	
	@Test
	public void testAsserts() {
		assertEquals("AB", "AB");
		assertNotEquals("AB", "BA");
		assertNull(null);
		assertNotNull(new Object());
		assertTrue(true);
		assertFalse(false);
		
		int a[] = {1, 2, 3};
		int b[] = {1, 2, 3};
		assertArrayEquals(a, b);

		logger.info("Test Asserts 1");
	}
	
	@Test
	public void testArraysSort() {
		
		int[] numbers = {4, 2, 1, 5, 7, 6};
		int[] expected = {1, 2, 4, 5, 6, 7};
		
		Arrays.sort(numbers);
		assertArrayEquals(expected, numbers);
		logger.info("Test Arrays Sort");
		
	}
	
	@Test(expected=NullPointerException.class)
    public void testArrayNull() {
		int numbers[] = null;
		Arrays.sort(numbers);
		
		logger.info("Test Arrays Null");
	}

	//Keep changing time out check the performance
	@Test(timeout=100)
	public void testSortPerformance() {
		int array[] = {12, 23, 4};
		for(int i = 1; i <= 1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}
	
	
	@Before
	public void beforeEveryTest() {
		logger.info("Before every test");
	}
	
	@After
	public void afterEveryTest() {
		logger.info("After every test");
	}
	
	@BeforeClass
	public static void beforeClass() {
		logger.info("before class");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("after class");
	}
}
