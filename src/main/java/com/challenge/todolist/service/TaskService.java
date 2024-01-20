package com.challenge.todolist.service;

import com.challenge.todolist.model.Task;
import java.util.List;
import java.util.Optional;


public interface TaskService {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    List<Task> getAllTask();
    Optional<Task> getTaskById(Long id);
    List<Task> getTasksCompleted();
    List<Task> getPendingTasks();
}
