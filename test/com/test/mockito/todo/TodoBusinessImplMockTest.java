package com.test.mockito.todo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;


import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import mock.todo.business.TodoBusinessImpl;
import mock.todo.service.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosUsingAMock1() {
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosUsingAMock2() {
		TodoService todoServiceMock = mock(TodoService.class);
		//when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList("1", "2"));
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, todos.size());
	}
	
	@Test
	public void testRetrieveTodosUsingBDD() {
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		//Then
		assertThat(filteredTodos.size(), is(2));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpringUsingBDD() {
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
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
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgCaptor = ArgumentCaptor.forClass(String.class);
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		
		List<String> todos = Arrays.asList("Learning spring", "Learning spring boot", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should().DeleteToDo(stringArgCaptor.capture());
		
		assertThat(stringArgCaptor.getValue(), is("Learn to Dance"));
		
	}
}