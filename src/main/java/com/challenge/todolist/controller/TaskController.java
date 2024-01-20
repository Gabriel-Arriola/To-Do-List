package com.challenge.todolist.controller;

import com.challenge.todolist.model.Task;
import com.challenge.todolist.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "To-Do List", description = "Endpoints to control app")
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final Logger log = LoggerFactory.getLogger(TaskController.class);

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Creates new task")
    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        log.info("Create Task");
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @Operation(summary = "Updates existing task")
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Long id) {
        log.info("Update Task");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id, task));
    }

    @Operation(summary = "Deletes existing task")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        log.info("Delete Task");
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Operation(summary = "Find all task")
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTask() {
        log.info("Find all Task");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTask());
    }

    @Operation(summary = "Find task by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id) {
        log.info("Find Task by id");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTaskById(id));
    }

    @Operation(summary = "Find all completed tasks")
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getTasksCompleted() {
        log.info("Find all completed Task");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasksCompleted());
    }

    @Operation(summary = "Find all pending tasks")
    @GetMapping("/pending")
    public ResponseEntity<List<Task>> getPendingTasks() {
        log.info("Find all pending Task");
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getPendingTasks());
    }
}
