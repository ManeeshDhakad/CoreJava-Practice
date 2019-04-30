package mock.todo.service;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);
	
	public void DeleteToDo(String todo);
}