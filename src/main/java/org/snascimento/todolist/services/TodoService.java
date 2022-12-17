package org.snascimento.todolist.services;

import org.snascimento.todolist.errors.exceptions.TodoNotFoundException;
import org.snascimento.todolist.model.Todo;
import org.snascimento.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

  @Autowired private TodoRepository todoRepository;

  public Todo create(Todo todo) {
    return todoRepository.save(todo);
  }

  public List<Todo> readAll() {

    return todoRepository.findAll();
  }

  public Todo readById(Long id) {
    Optional<Todo> todo = todoRepository.findById(id);
    return todo.orElseThrow(()-> new TodoNotFoundException("Tarefa não encontrada"));
  }

  public void update(Todo todo) {
    Todo existingTodo = this.readById(todo.getId());
    Todo updatedTodo = Todo.builder()
            .id(existingTodo.getId())
            .title(todo.getTitle())
            .description(todo.getDescription())
            .build();
    todoRepository.save(updatedTodo);
  }

  public void delete(Long id) {
    Todo existingTodo = this.readById(id);
    todoRepository.delete(existingTodo);
  }
}
