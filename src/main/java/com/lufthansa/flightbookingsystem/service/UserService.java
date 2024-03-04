package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto user);

    UserResponseDto findById(String uuid);

    List<UserResponseDto> findAllUsers();

    void deleteUser(String uuid);

    UserResponseDto updateUserById(String uuid, UserRequestDto requestDto);
}
