package org.snascimento.todolist.model.requests;

import lombok.Data;

@Data
public class TodoPostRequestBody {
    private String title;
    private String description;
}
