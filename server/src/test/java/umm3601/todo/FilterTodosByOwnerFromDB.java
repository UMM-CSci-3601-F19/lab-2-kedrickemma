package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterTodosByOwnerFromDB {
  @Test
  public void filterTodosByOwner() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoBarry = db.filterTodosByOwner(allTodos, "Barry");
    assertEquals("Incorrect total number of Todos", 51, todoBarry.length);

    Todo[] todoBlanche = db.filterTodosByOwner(allTodos, "Blanche");
    assertEquals("Incorrect total number of Todos", 43, todoBlanche.length);

    Todo[] todoDawn = db.filterTodosByOwner(allTodos, "Dawn");
    assertEquals("Incorrect total number of Todos", 50, todoDawn.length);

    Todo[] todoFry = db.filterTodosByOwner(allTodos, "Fry");
    assertEquals("Incorrect total number of Todos", 61, todoFry.length);

    Todo[] todoRoberta = db.filterTodosByOwner(allTodos, "Roberta");
    assertEquals("Incorrect total number of Todos", 46, todoRoberta.length);

    Todo[] todoWorkman = db.filterTodosByOwner(allTodos, "Workman");
    assertEquals("Incorrect total number of Todos", 49, todoWorkman.length);
  }
}
