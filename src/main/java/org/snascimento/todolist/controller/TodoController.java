package org.snascimento.todolist.controller;

import org.snascimento.todolist.model.Todo;
import org.snascimento.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

  @Autowired private TodoService todoService;

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> create(@RequestBody Todo todo) {
    Todo createdTodo = todoService.create(todo);
    return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> readAll() {
    List<Todo> todos = todoService.readAll();
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> readById(@PathVariable("id") Long id) {
    Todo todo = todoService.readById(id);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }

  @PutMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> update(@RequestBody Todo todo) {
    todoService.update(todo);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    todoService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
