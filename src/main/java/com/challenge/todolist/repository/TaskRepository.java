package com.challenge.todolist.repository;

import com.challenge.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findTaskByStatusTrue();
    public List<Task> findTaskByStatusFalse();
}
