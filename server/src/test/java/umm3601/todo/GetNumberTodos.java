package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests umm3601.todo.TodoDatabase getNumberTodos and listUsers with _age_ query
 * parameters
 */
public class GetNumberTodos {
	@Test
	public void totalTodoCount() throws IOException {
		TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
		Todo[] allTodos = db.getNumberTodos(new HashMap<>(), 12);
		assertEquals("Incorrect total number of Todos", 12, allTodos.length);
	}
	
	@Test
	public void totalTodoCount() throws IOException {
		TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
		Todo[] allTodos = db.getNumberTodos(new HashMap<>(), 0);
		assertEquals("Incorrect total number of Todos", 0, allTodos.length);
	}
}
