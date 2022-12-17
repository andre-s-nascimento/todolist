package org.snascimento.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "todo")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "title", nullable = false, length = 100, columnDefinition = "VARCHAR(100)")
  private String title;
  @Column(name = "descrption", nullable = false, columnDefinition = "VARCHAR(255)")
  private String description;
}
