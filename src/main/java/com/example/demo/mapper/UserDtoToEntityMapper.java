package com.example.demo.mapper;

import com.example.demo.domain.User;
import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoToEntityMapper {
    UserResponse userEntityToDto(User user);
    User userToEntity(CreateUserRequest createUserRequest);
}
