package org.snascimento.todolist.services;

import org.snascimento.todolist.model.Todo;
import org.snascimento.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo create(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> readAll() {

        return todoRepository.findAll();
    }

    public Todo readById(Long id) {
        return todoRepository.findById(id).get();
    }

    public void update(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(Todo todo) {
        todoRepository.delete(todo);
    }
}
