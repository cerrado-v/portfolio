package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.TaskDto;
import com.example.portfolio.model.UserTask;

public interface TaskService {

    List<TaskDto> getAllTasksByUserEmail(String userEmail);
    TaskDto addTask(TaskDto taskDto);
    TaskDto updateTask(Long id, TaskDto taskDto);
    void deleteTask(Long id);
    TaskDto getTaskById(String idTask);
    UserTask registerUser(String email);
    // List<TaskDto> updateAllUser(List<TaskDto> taskDtos);
}
