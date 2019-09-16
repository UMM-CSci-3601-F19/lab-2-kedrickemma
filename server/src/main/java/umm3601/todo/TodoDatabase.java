package umm3601.todo;

import com.google.gson.Gson;
//import com.sun.org.apache.xpath.internal.operations.Bool;
//import com.sun.xml.internal.bind.v2.TO-DO;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
   * Get an array of all the Todos satisfying the queries in the params.
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of all the Todos matching the given criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodo = allTodo;

    if (queryParams.containsKey("limit")) {
      int targetLimit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodo = filterTodosByLimit(filteredTodo, targetLimit);
    }

    if (queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status")[0];
      filteredTodo = filterTodosByStatus(filteredTodo, targetStatus);
    }

    if (queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0];
      filteredTodo = filterTodosByOwner(filteredTodo, targetOwner);
    }

    if (queryParams.containsKey("category")) {
      String targetCategory = queryParams.get("category")[0];
      filteredTodo = filterTodosByCategory(filteredTodo, targetCategory);
    }
    // Process other query parameters here...

    return filteredTodo;
  }

  public Todo[] filterTodosByLimit(Todo[] todos, int limit) {
    return Arrays.stream(todos).limit(limit).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByStatus(Todo[] todos, String status){
    return Arrays.stream(todos).filter(x -> x.status == status).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByOwner(Todo[] todos, String owner){
    return Arrays.stream(todos).filter(x -> x.owner == owner).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByCategory(Todo[] todos, String category){
    return Arrays.stream(todos).filter(x -> x.category == category).toArray(Todo[]::new);
  }
}
