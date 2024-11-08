package com.example.portfolio.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.dto.TaskDto;
import com.example.portfolio.service.TaskService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ToDoList")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks() { 
        return taskService.getAllTasks();
    }

    @PostMapping 
    public TaskDto addTask(@RequestBody TaskDto taskDto) { 
        return taskService.addTask(taskDto); 
    } 
    
    @PutMapping("/{id}") 
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) { 
        return taskService.updateTask(id, taskDto); 
    } 
    
    @DeleteMapping("/{id}") 
    public void deleteTask(@PathVariable Long id) { 
        taskService.deleteTask(id); 
    } 
    

}
