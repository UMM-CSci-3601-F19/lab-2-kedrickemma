package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;
import umm3601.todo.Todo;
import umm3601.todo.TodoDatabase;

import java.io.IOException;

import static umm3601.Util.*;

/**
 * Controller that manages requests for info about Todos.
 */
public class TodoController {

  private final Gson gson;
  private TodoDatabase database;

  /**
   * Construct a controller for Todos.
   * <p>
   * This loads the "database" of todos info from a JSON file and
   * stores that internally so that (subsets of) Todos can be returned
   * in response to requests.
   *
   * @param database the database containing Todos data
   */
  public TodoController(TodoDatabase database) {
    gson = new Gson();
    this.database = database;
  }

  /**
   * Get the single Todos specified by the `id` parameter in the request.
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a success JSON object if the Todos with that ID is found, a fail
   * JSON object if no Todos with that ID is found
   */
  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo Todo = database.getTodo(id);
    if (Todo != null) {
      return buildSuccessJsonResponse("Todo", gson.toJsonTree(Todo));
    } else {
      String message = "Todo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }

  /**
   * Get a JSON response with a list of all the Todos in the "database".
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a success JSON object containing all the Todos
   */
  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] Todos = database.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("Todos", gson.toJsonTree(Todos));
  }

}
