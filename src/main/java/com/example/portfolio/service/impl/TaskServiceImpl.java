package com.example.portfolio.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.dto.TaskDto;
import com.example.portfolio.mapper.TaskMapper;
import com.example.portfolio.model.Task;
import com.example.portfolio.model.UserTask;
import com.example.portfolio.repository.TaskRepository;
import com.example.portfolio.repository.UserTaskRepository;
import com.example.portfolio.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserTaskRepository userTaskRepository;

    @Override
    public TaskDto addTask(TaskDto taskDto) {
        UserTask userTask = userTaskRepository.findByEmail(taskDto.getUserEmail());
        if (userTask == null) {
            throw new RuntimeException("User not found with email: " + taskDto.getUserEmail());
        }

        Task task = TaskMapper.mapToTask(taskDto, userTask);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(savedTask);
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found."));

        task.setTitle(taskDto.getTitle());
        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        task.setCompletedDate(taskDto.getCompletedDate());
        task.setStatus(taskDto.getStatus());

        Task updatedTask = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(TaskMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }
}
