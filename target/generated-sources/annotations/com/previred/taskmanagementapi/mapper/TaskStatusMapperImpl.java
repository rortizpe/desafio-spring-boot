package com.previred.taskmanagementapi.mapper;

import com.previred.taskmanagementapi.model.entity.TaskStatus;
import com.previred.taskmanagementapi.model.response.TaskStatusResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-16T05:01:20-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class TaskStatusMapperImpl implements TaskStatusMapper {

    @Override
    public TaskStatusResponse toResponse(TaskStatus status) {
        if ( status == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = status.getId();
        name = status.getName();

        TaskStatusResponse taskStatusResponse = new TaskStatusResponse( id, name );

        return taskStatusResponse;
    }
}
