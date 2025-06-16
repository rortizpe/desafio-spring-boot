package com.previred.taskmanagementapi.model.response;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        String statusName,
        String username,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
