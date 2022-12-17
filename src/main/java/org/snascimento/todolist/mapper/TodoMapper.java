package org.snascimento.todolist.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.snascimento.todolist.model.Todo;
import org.snascimento.todolist.model.requests.TodoPutRequestBody;
import org.snascimento.todolist.model.requests.TodoPostRequestBody;
import org.snascimento.todolist.model.responses.TodoResponseBody;

@Mapper(componentModel = "spring")
public abstract class TodoMapper {
    public static final TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    public abstract Todo toTodo(TodoPostRequestBody todoPostRequestBody);
    public abstract Todo toTodo(TodoPutRequestBody todoPutRequestBody);

    public abstract TodoResponseBody toTodoResponseBody(Todo todo);
}
