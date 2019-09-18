package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterTodosByCategoryFromDB {
  @Test
  public void filterTodosByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todoHomework = db.filterTodosByCategory(allTodos, "homework");
    assertEquals("Incorrect total number of Todos", 79, todoHomework.length);

    Todo[] todoSoftwareDesign = db.filterTodosByCategory(allTodos, "software design");
    assertEquals("Incorrect total number of Todos", 74, todoSoftwareDesign.length);

    Todo[] todoGroceries = db.filterTodosByCategory(allTodos, "groceries");
    assertEquals("Incorrect total number of Todos", 76, todoGroceries.length);

    Todo[] todoVideoGames = db.filterTodosByCategory(allTodos, "video games");
    assertEquals("Incorrect total number of Todos", 71, todoVideoGames.length);
  }
}
