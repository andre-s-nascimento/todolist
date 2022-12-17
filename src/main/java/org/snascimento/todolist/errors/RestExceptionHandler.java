package org.snascimento.todolist.errors;

import org.hibernate.sql.ast.tree.expression.Over;
import org.snascimento.todolist.errors.exceptions.TodoNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<?> handleTodoNotFoundException(TodoNotFoundException todoNotFoundException) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .message(todoNotFoundException.getMessage())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorDetails errorDetails  = ErrorDetails.builder().message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

}
