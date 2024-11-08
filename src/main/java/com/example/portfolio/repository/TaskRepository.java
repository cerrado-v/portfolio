package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
