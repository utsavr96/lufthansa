package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;

public interface UserService {
    UserResponseDto createUser(UserRequestDto user);
}
