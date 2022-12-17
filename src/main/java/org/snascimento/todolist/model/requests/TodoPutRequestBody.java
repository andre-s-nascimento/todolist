package org.snascimento.todolist.model.requests;

import lombok.Data;

@Data
public class TodoPutRequestBody {
    private Long id;
    private String title;
    private String description;
}
