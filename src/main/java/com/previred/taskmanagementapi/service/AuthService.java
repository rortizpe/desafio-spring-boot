package com.previred.taskmanagementapi.service;

import com.previred.taskmanagementapi.model.request.LoginRequest;
import com.previred.taskmanagementapi.model.response.JwtResponse;

public interface AuthService {
    JwtResponse login(LoginRequest request);
}