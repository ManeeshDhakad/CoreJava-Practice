package com.test.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;


import java.util.List;

import org.junit.Test;

public class MockList {

	@Test
	public void mockListSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void mockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void mockListGet_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("0").thenReturn("1");
		
		assertEquals("0", listMock.get(0));
		assertEquals("1", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test(expected=RuntimeException.class)
	public void mockList_ThrowException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException(""));
		
		listMock.get(0);
	}
	
	
	@Test
	public void mockListGet_ReturnMultipleValuesBDD() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("0");
		
		//When 
		String firstElement =  listMock.get(0);
		
		//Then
		assertThat(firstElement, is("0"));
	}
	
}
