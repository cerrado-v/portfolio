package com.example.portfolio.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private String userEmail;
    
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
    private LocalDateTime completedDate;
    private String idTask;

}
