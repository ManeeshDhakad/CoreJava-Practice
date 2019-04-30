package com.test.mockito.todo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import mock.todo.business.TodoBusinessImpl;
import mock.todo.service.TodoService;
import mock.todo.service.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosUsingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}