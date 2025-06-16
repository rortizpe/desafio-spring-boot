package com.previred.taskmanagementapi.mapper;

import com.previred.taskmanagementapi.model.entity.User;
import com.previred.taskmanagementapi.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "username", target = "username")
    UserResponse toResponse(User user);
}
