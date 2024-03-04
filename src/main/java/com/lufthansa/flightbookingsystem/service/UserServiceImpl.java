package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;
import com.lufthansa.flightbookingsystem.mapper.UserMapper;
import com.lufthansa.flightbookingsystem.model.User;
import com.lufthansa.flightbookingsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserResponseDto createUser(UserRequestDto request) {
        User user = userMapper.map(request);
        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

}
