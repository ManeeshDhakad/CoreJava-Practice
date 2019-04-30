package mock.todo.service;

import java.util.Arrays;
import java.util.List;

import mock.todo.service.TodoService;

public class TodoServiceStub implements TodoService {
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}

	@Override
	public void DeleteToDo(String todo) {
		// TODO Auto-generated method stub
		
	}
}