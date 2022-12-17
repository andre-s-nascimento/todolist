package org.snascimento.todolist.model.responses;

import lombok.Data;

@Data
public class TodoResponseBody {
    private Long id;
    private String title;
    private String description;
}
