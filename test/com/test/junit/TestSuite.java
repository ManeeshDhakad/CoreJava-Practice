package com.test.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BasicUnitTest.class, ParameterizedTest.class})
public class TestSuite {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
