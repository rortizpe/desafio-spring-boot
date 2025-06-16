package com.previred.taskmanagementapi.repository;

import com.previred.taskmanagementapi.model.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}