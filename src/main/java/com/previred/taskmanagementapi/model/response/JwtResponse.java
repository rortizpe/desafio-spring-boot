package com.previred.taskmanagementapi.model.response;

public record JwtResponse(
        String token,
        String username
) {}
