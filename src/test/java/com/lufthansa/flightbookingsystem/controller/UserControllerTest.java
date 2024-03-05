package com.lufthansa.flightbookingsystem.controller;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;
import com.lufthansa.flightbookingsystem.exception.UserNotFoundException;
import com.lufthansa.flightbookingsystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

@SpringBootTest
public class UserControllerTest {


    private UserController userController;
    private UserService userService;

    @BeforeEach
    public void setup() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    public void testFindUserById_ExistingId() {
        String uuid = UUID.randomUUID().toString();
        UserResponseDto responseDto = new UserResponseDto();
        when(userService.findById(any(String.class))).thenReturn(responseDto);

        ResponseEntity<UserResponseDto> response = userController.findUserById(uuid);

        verify(userService).findById(uuid);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

    @Test
    public void testFindUserById_NonExistingId() {
        String uuid = UUID.randomUUID().toString();
        when(userService.findById(any(String.class))).thenThrow(UserNotFoundException.class);

        assertThrows(UserNotFoundException.class, () -> {
            userController.findUserById(uuid);
        });

        verify(userService).findById(uuid);
    }

    @Test
    public void testCreateUser_Success() {
        UserRequestDto requestDto = new UserRequestDto();
        UserResponseDto responseDto = new UserResponseDto();
        when(userService.createUser(any(UserRequestDto.class))).thenReturn(responseDto);

        ResponseEntity<UserResponseDto> response = userController.createUser(requestDto);

        verify(userService).createUser(requestDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

    @Test
    public void testFindAllUsers_Success() {
        List<UserResponseDto> responseDtoList = Arrays.asList(new UserResponseDto(), new UserResponseDto());
        when(userService.findAllUsers()).thenReturn(responseDtoList);

        ResponseEntity<List<UserResponseDto>> response = userController.findAllUsers();

        verify(userService).findAllUsers();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(responseDtoList);
    }

    @Test
    public void testFindAllUsers_NoUsers() {
        when(userService.findAllUsers()).thenReturn(Collections.emptyList());

        ResponseEntity<List<UserResponseDto>> response = userController.findAllUsers();

        verify(userService).findAllUsers();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEmpty();
    }

}
