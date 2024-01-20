package com.challenge.todolist.service.Impl;

import com.challenge.todolist.exceptions.NotFoundException;
import com.challenge.todolist.model.Task;
import com.challenge.todolist.repository.TaskRepository;
import com.challenge.todolist.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new NotFoundException(id));
        updTask.setId(task.getId());
        return taskRepository.save(updTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        taskRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getTasksCompleted() {
        return taskRepository.findTaskByStatusTrue();
    }

    @Override
    public List<Task> getPendingTasks() {
        return taskRepository.findTaskByStatusFalse();
    }
}
