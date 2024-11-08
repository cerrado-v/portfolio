package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.TaskDto;

public interface TaskService {

    List<TaskDto> getAllTasks();
    TaskDto addTask(TaskDto taskDto);
    TaskDto updateTask(Long Id, TaskDto taskDto);
    void deleteTask(Long id);

}
