package com.example.portfolio.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
    private LocalDateTime endDate;

    private String status;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy, hh:mm:ss a")
    private LocalDateTime completedDate;
    private String email;
    private String idTask;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private UserTask user;
}
