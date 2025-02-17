package com.example.todoapp.service;

import com.example.todoapp.entity.Task;
import com.example.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private  final TaskRepository taskRepository;
    ///private final Task task = new Task();

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
       task.setTitle(title);
       task.setCompleted(false);
       taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
     Task task = taskRepository.findById(id)
             .orElseThrow(() -> new IllegalArgumentException("Invalid id"));
     task.setCompleted(!task.isCompleted());
     taskRepository.save(task);




    }
}
