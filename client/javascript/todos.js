/**
 * Function to get all the Todos!
 */
function getAllTodos() {
  console.log("Getting all the todos.");

  get("/api/todo", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByOwner() {
  console.log("Getting all the todos.");

  get("/api/todo?owner=" + document.getElementById("owner").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByStatus() {
  console.log("Getting all the todos.");

  get("/api/todo?status=" + document.getElementById("status"), function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function getAllTodosByCategory() {
  console.log("Getting all the todos.");

  get("/api/todo?category=" + document.getElementById("category"), function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function limitNumberOfTodos() {
  console.log("Getting all the todos.");

  get("/api/todo?limit=" + document.getElementById("limit"), function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

