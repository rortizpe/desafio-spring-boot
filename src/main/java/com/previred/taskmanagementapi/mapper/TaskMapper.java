package com.previred.taskmanagementapi.mapper;

import com.previred.taskmanagementapi.model.entity.Task;
import com.previred.taskmanagementapi.model.entity.TaskStatus;
import com.previred.taskmanagementapi.model.entity.User;
import com.previred.taskmanagementapi.model.request.TaskRequest;
import com.previred.taskmanagementapi.model.response.TaskResponse;
import org.mapstruct.*;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "user", source = "user")
    Task toEntity(TaskRequest request, TaskStatus status, User user);

    @Mapping(target = "statusName", source = "status.name")
    @Mapping(target = "username", source = "user.username")
    TaskResponse toResponse(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "title", source = "request.title")
    @Mapping(target = "description", source = "request.description")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntity(@MappingTarget Task task, TaskRequest request, TaskStatus status);
}