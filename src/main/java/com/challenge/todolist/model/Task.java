package com.challenge.todolist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Schema(description = "ID task autogenerated")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Description of task", example = "Read the book")
    @Column
    private String description;

    @Schema(description = "indicates whether the task is completed or not", example = "true")
    @Column
    private boolean status;

}
