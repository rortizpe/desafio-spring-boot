package com.previred.taskmanagementapi.service;

import com.previred.taskmanagementapi.model.request.TaskRequest;
import com.previred.taskmanagementapi.model.response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> findAllByUser(String username);

    TaskResponse findByIdAndUser(Long id, String username);

    TaskResponse create(String username, TaskRequest request);

    TaskResponse update(Long id, String username, TaskRequest request);

    void delete(Long id, String username);
}