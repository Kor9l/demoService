package com.example.demo.service.impl;

import com.example.demo.domain.User;
import com.example.demo.dto.request.CreateClientRequest;
import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.UpdateUserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.mapper.UserDtoToEntityMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final UserDtoToEntityMapper userDtoToEntityMapper;

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User with id " + id + " not found"));
        return userDtoToEntityMapper.userEntityToDto(user);
    }

    @Override
    public void deleteById(Long id) { userRepository.deleteById(id);

    }

    @Override
    public void create(CreateUserRequest createUserRequest){
        User newUser= userDtoToEntityMapper.userToEntity(createUserRequest);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        userRepository.save(newUser);
    }

    @Override
    public UserResponse update(UpdateUserRequest updateUserRequest) {
        User user = userDtoToEntityMapper.userToEntity(updateUserRequest);
        userRepository.findById(user.getId())
                .orElseThrow(()->new EntityNotFoundException("User with id:"+user.getId()+"not found."));
        userRepository.save(user);

        return userDtoToEntityMapper.userEntityToDto(user);
    }
}
