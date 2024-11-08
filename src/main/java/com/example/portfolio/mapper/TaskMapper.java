package com.example.portfolio.mapper;

import com.example.portfolio.dto.TaskDto;
import com.example.portfolio.model.Task;
import com.example.portfolio.model.UserTask;

public class TaskMapper {

    public static Task mapToTask(TaskDto taskDto, UserTask userTask) {
        return Task.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .startDate(taskDto.getStartDate())
                .endDate(taskDto.getEndDate())
                .status(taskDto.getStatus())
                .user(userTask)
                .completedDate(taskDto.getCompletedDate())
                .build();
    }

    public static TaskDto mapToTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .startDate(task.getStartDate())
                .endDate(task.getEndDate())
                .status(task.getStatus())
                .userEmail(task.getUser().getEmail())
                .completedDate(task.getCompletedDate())
                .build();
    }
}
