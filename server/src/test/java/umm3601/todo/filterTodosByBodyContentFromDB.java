package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class filterTodosByBodyContentFromDB {
  @Test
  public void filterTodosByBodyContent() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoLorem = db.filterTodosByBody(allTodos, "Lorem");
    assertEquals("Incorrect total number of Todos", 84, todoLorem.length);

    Todo[] todoEnim = db.filterTodosByBody(allTodos, "enim");
    assertEquals("Incorrect total number of Todos", 73, todoEnim.length);

    Todo[] todoExcepteur = db.filterTodosByBody(allTodos, "excepteur");
    assertEquals("Incorrect total number of Todos", 70, todoExcepteur.length);

    Todo[] todoBanana = db.filterTodosByBody(allTodos, "banana");
    assertEquals("Incorrect total number of Todos", 0, todoBanana.length);
  }
}
