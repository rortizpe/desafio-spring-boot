package com.previred.taskmanagementapi.mapper;

import com.previred.taskmanagementapi.model.entity.TaskStatus;
import com.previred.taskmanagementapi.model.response.TaskStatusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskStatusMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    TaskStatusResponse toResponse(TaskStatus status);
}
