package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterTodosByLimitFromDB {

  @Test
  public void filterTodosByLimit() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoLimit5 = db.filterTodosByLimit(allTodos, 5);
    assertEquals("Incorrect total number of Todos", 5, todoLimit5.length);

    Todo[] todoLimit8 = db.filterTodosByLimit(allTodos, 8);
    assertEquals("Incorrect total number of Todos", 8, todoLimit8.length);

    Todo[] todoLimit20 = db.filterTodosByLimit(allTodos, 20);
    assertEquals("Incorrect total number of Todos", 20, todoLimit20.length);

    Todo[] todoLimit1 = db.filterTodosByLimit(allTodos, 1);
    assertEquals("Incorrect total number of Todos", 1, todoLimit1.length);

  }
}
