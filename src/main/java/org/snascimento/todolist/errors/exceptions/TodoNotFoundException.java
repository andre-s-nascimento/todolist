package org.snascimento.todolist.errors.exceptions;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String mensage) {
      super(mensage);
    }
}
