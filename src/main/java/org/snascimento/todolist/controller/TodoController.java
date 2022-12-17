package org.snascimento.todolist.controller;

import org.snascimento.todolist.mapper.TodoMapper;
import org.snascimento.todolist.model.Todo;
import org.snascimento.todolist.model.requests.TodoPostRequestBody;
import org.snascimento.todolist.model.requests.TodoPutRequestBody;
import org.snascimento.todolist.model.responses.TodoResponseBody;
import org.snascimento.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

  @Autowired private TodoService todoService;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> create(@RequestBody TodoPostRequestBody todoPostRequestBody) {
    Todo todo = TodoMapper.INSTANCE.toTodo(todoPostRequestBody);
    Todo createdTodo = todoService.create(todo);
    TodoResponseBody todoResponseBody = TodoMapper.INSTANCE.toTodoResponseBody(createdTodo);
    return new ResponseEntity<>(todoResponseBody, HttpStatus.CREATED);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> readAll() {
    List<TodoResponseBody> todos = new ArrayList<>();
    todoService.readAll().forEach(todo -> {
      TodoResponseBody todoResponseBody = TodoMapper.INSTANCE.toTodoResponseBody(todo);
      todos.add(todoResponseBody);
    });
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> readById(@PathVariable("id") Long id) {
    Todo todo = todoService.readById(id);
    TodoResponseBody todoResponseBody = TodoMapper.INSTANCE.toTodoResponseBody(todo);
    return new ResponseEntity<>(todoResponseBody, HttpStatus.OK);
  }

  @PutMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> update(@RequestBody TodoPutRequestBody todoPutRequestBody) {
    Todo todo = TodoMapper.INSTANCE.toTodo(todoPutRequestBody);
    todoService.update(todo);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    todoService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
