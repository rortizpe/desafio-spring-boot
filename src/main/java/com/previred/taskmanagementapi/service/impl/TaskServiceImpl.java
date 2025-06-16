package com.previred.taskmanagementapi.service.impl;

import com.previred.taskmanagementapi.mapper.TaskMapper;
import com.previred.taskmanagementapi.model.entity.TaskStatus;
import com.previred.taskmanagementapi.model.entity.User;
import com.previred.taskmanagementapi.model.request.TaskRequest;
import com.previred.taskmanagementapi.model.response.TaskResponse;
import com.previred.taskmanagementapi.repository.TaskRepository;
import com.previred.taskmanagementapi.repository.TaskStatusRepository;
import com.previred.taskmanagementapi.repository.UserRepository;
import com.previred.taskmanagementapi.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskStatusRepository statusRepository;
    private final TaskMapper mapper;

    public TaskServiceImpl(TaskRepository taskRepository,
                           UserRepository userRepository,
                           TaskStatusRepository statusRepository,
                           TaskMapper mapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
        this.mapper = mapper;
    }

    @Override
    public List<TaskResponse> findAllByUser(String username) {
        var user = getUser(username);
        return taskRepository.findByUser(user)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponse findByIdAndUser(Long id, String username) {
        var user = getUser(username);
        return taskRepository.findById(id)
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Task not found or access denied"));
    }

    @Override
    @Transactional
    public TaskResponse create(String username, TaskRequest request) {
        var user = getUser(username);
        var status = getStatus(request.statusId());
        var task = mapper.toEntity(request, status, user);
        return mapper.toResponse(taskRepository.save(task));
    }

    @Override
    @Transactional
    public TaskResponse update(Long id, String username, TaskRequest request) {
        var user = getUser(username);
        var task = taskRepository.findById(id)
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .orElseThrow(() -> new IllegalArgumentException("Task not found or access denied"));
        var status = getStatus(request.statusId());
        mapper.updateEntity(task, request, status);
        return mapper.toResponse(taskRepository.save(task));
    }

    @Override
    public void delete(Long id, String username) {
        var user = getUser(username);
        var task = taskRepository.findById(id)
                .filter(t -> t.getUser().getId().equals(user.getId()))
                .orElseThrow(() -> new IllegalArgumentException("Task not found or access denied"));
        taskRepository.delete(task);
    }

    private User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    private TaskStatus getStatus(Long id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Status not found"));
    }
}