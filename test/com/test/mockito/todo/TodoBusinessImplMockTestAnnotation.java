package com.test.mockito.todo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import mock.todo.business.TodoBusinessImpl;
import mock.todo.service.TodoService;

//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTestAnnotation {

	//Instead of MockitoJUnnit Runner we can use rule
	// Rule must public 
	// Since we can have only 1 Runner in class so rules come to picture.
	// We can have multiple rule in class
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> stringArgCaptor;
	
	@Test
	public void testRetrieveTodosUsingAMock1() {
		
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosUsingAMock2() {
		
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, todos.size());
	}
	
	@Test
	public void testRetrieveTodosUsingBDD() {
		//Given
		
		
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		//When
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		//Then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpringUsingBDD() {
		//Given
				
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		// THis can be called only once
		verify(todoServiceMock, times(1)).DeleteToDo("Learn to Dance");
		
		// This check for negative test
		verify(todoServiceMock, never()).DeleteToDo("Learning spring");
		
		// This check for negative test
		verify(todoServiceMock, never()).DeleteToDo("Learning spring boot");
		
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpringUsingBDD_ArgumentCapture() {
		
		//Given
				
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should().DeleteToDo(stringArgCaptor.capture());
		
		assertThat(stringArgCaptor.getValue(), is("Learn to Dance"));
		
	}
}