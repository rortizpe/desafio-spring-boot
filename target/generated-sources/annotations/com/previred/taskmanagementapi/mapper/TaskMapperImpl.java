package com.previred.taskmanagementapi.mapper;

import com.previred.taskmanagementapi.model.entity.Task;
import com.previred.taskmanagementapi.model.entity.TaskStatus;
import com.previred.taskmanagementapi.model.entity.User;
import com.previred.taskmanagementapi.model.request.TaskRequest;
import com.previred.taskmanagementapi.model.response.TaskResponse;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-16T05:06:46-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toEntity(TaskRequest request, TaskStatus status, User user) {
        if ( request == null && status == null && user == null ) {
            return null;
        }

        Task task = new Task();

        if ( request != null ) {
            task.setTitle( request.title() );
            task.setDescription( request.description() );
        }
        task.setStatus( status );
        task.setUser( user );
        task.setCreatedAt( LocalDateTime.now() );
        task.setUpdatedAt( LocalDateTime.now() );

        return task;
    }

    @Override
    public TaskResponse toResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        String statusName = null;
        String username = null;
        Long id = null;
        String title = null;
        String description = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        statusName = taskStatusName( task );
        username = taskUserUsername( task );
        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
        createdAt = task.getCreatedAt();
        updatedAt = task.getUpdatedAt();

        TaskResponse taskResponse = new TaskResponse( id, title, description, statusName, username, createdAt, updatedAt );

        return taskResponse;
    }

    @Override
    public void updateEntity(Task task, TaskRequest request, TaskStatus status) {
        if ( request == null && status == null ) {
            return;
        }

        if ( request != null ) {
            if ( request.title() != null ) {
                task.setTitle( request.title() );
            }
            if ( request.description() != null ) {
                task.setDescription( request.description() );
            }
        }
        if ( status != null ) {
            task.setStatus( status );
        }
        task.setUpdatedAt( LocalDateTime.now() );
    }

    private String taskStatusName(Task task) {
        if ( task == null ) {
            return null;
        }
        TaskStatus status = task.getStatus();
        if ( status == null ) {
            return null;
        }
        String name = status.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String taskUserUsername(Task task) {
        if ( task == null ) {
            return null;
        }
        User user = task.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
