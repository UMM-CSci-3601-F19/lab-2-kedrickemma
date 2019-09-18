package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * A fake "database" of To-do info
 * <p>
 * Since we don't want to complicate this lab with a real database,
 * we're going to instead just read a bunch of To-do data from a
 * specified JSON file, and then provide various database-like
 * methods that allow the `TodoController` to "query" the "database".
 */
public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single To-do specified by the given ID. Return
   * `null` if there is no To-do with that ID.
   *
   * @param id the ID of the desired To-do
   * @return the To-do with the given ID, or null if there is no To-do
   * with that ID
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all the Todos satisfying the queries in the params.
   *
   * @param queryParams map of required key-value pairs for the query
   * @return an array of all the Todos matching the given criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    if (queryParams.containsKey("limit")) {
      int targetLimit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodos = filterTodosByLimit(filteredTodos, targetLimit);
    }

    if (queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status")[0];
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    if (queryParams.containsKey("owner")) {
      String targetOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    if (queryParams.containsKey("category")) {
      String targetCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }

    if (queryParams.containsKey("body")) {
      String targetBody = queryParams.get("body")[0];
      filteredTodos = filterTodosByBody(filteredTodos, targetBody);
    }
    // Process other query parameters here...

    return filteredTodos;
  }

  public Todo[] filterTodosByLimit(Todo[] todos, int targetLimit) {
    return Arrays.stream(todos).limit(targetLimit).toArray(Todo[]::new);
  }


  public Todo[] filterTodosByStatus(Todo[] todos, String stat) {
    if (stat.equals("true"))
      return Arrays.stream(todos).filter(x -> x.status).toArray(Todo[]::new);
    if (stat.equals("false"))
      return Arrays.stream(todos).filter(x -> !x.status).toArray(Todo[]::new);
    return Arrays.copyOf(todos, 0);
  }

  public Todo[] filterTodosByOwner(Todo[] todos, String owner) {
    return Arrays.stream(todos).filter(x -> x.owner.equals(owner)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByCategory(Todo[] todos, String category) {
    return Arrays.stream(todos).filter(x -> x.category.equals(category)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByBody(Todo[] todos, String body) {
    return Arrays.stream(todos).filter(x -> x.body.contains(body)).toArray(Todo[]::new);
  }
}

