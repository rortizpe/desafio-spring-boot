package com.previred.taskmanagementapi.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest(
        @NotBlank(message = "Title is required")
        String title,

        String description,

        @NotNull(message = "Status ID is required")
        Long statusId
) {}
