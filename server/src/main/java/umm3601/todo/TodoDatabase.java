package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * A fake "database" of Todo info
 * <p>
 * Since we don't want to complicate this lab with a real database,
 * we're going to instead just read a bunch of Todo data from a
 * specified JSON file, and then provide various database-like
 * methods that allow the `TodoController` to "query" the "database".
 */
public class TodoDatabase {

  private Todo[] allTodo;

  public TodoDatabase(String TodoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(TodoDataFile);
    allTodo = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single Todo specified by the given ID. Return
   * `null` if there is no Todo with that ID.
   *
   * @param id the ID of the desired Todo
   * @return the Todo with the given ID, or null if there is no Todo
   * with that ID
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodo).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all the Todo satisfying the queries in the params.
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of all the Todo matching the given criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodo = allTodo;


    // Process other query parameters here...

    return filteredTodo;
  }



}
