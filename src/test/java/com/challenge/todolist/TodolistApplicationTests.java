package com.challenge.todolist;

import com.challenge.todolist.model.Task;
import com.challenge.todolist.repository.TaskRepository;
import com.challenge.todolist.service.Impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class TodolistApplicationTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task taskTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(TodolistApplicationTests.class);
        taskTest = Task.builder()
                .description("New Test Task")
                .status(false)
                .build();
    }

	@Test
	void createTask() {
		when(taskRepository.save(taskTest)).thenReturn(taskTest);
		Task savedTask = taskService.createTask(taskTest);
		assertEquals("New Test Task", savedTask.getDescription());
		verify(taskRepository, times(1)).save(taskTest);
	}

    @Test
    void getAllTasks(){
        Task taskTest2 = Task.builder()
                .description("Second Test Task")
                .status(true)
                .build();

        Task taskTest3 = Task.builder()
                .description("third Test Task")
                .status(false)
                .build();

        when(taskRepository.findAll()).thenReturn(Arrays.asList(taskTest, taskTest2,taskTest3));

        List<Task> tasks = taskService.getAllTask();

        assertEquals(3,tasks.size());
        assertEquals("New Test Task", tasks.get(0).getDescription());
        assertEquals("Second Test Task", tasks.get(1).getDescription());
        assertEquals("third Test Task", tasks.get(2).getDescription());
    }

    @Test
    void getTaskById(){
        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskTest));
        Optional<Task> optionalTask = taskService.getTaskById(1L);
        assertTrue(optionalTask.isPresent());
        assertEquals("New Test Task", optionalTask.get().getDescription());
    }
    
}
