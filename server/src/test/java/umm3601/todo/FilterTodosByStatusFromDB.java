package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterTodosByStatusFromDB {
  @Test
  public void filterTodosByStatus() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoTrue = db.filterTodosByStatus(allTodos, "true");
    assertEquals("Incorrect total number of Todos", 143, todoTrue.length);

    Todo[] todoFalse = db.filterTodosByStatus(allTodos, "false");
    assertEquals("Incorrect total number of Todos", 157, todoFalse.length);
  }
}
