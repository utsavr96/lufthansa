package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;
import com.lufthansa.flightbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user) {
        UserResponseDto createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/id/{uuid}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable String uuid) {
        UserResponseDto createdUser = userService.findById(uuid);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){
        List<UserResponseDto> allUsers = userService.findAllUsers();
        return new ResponseEntity<List<UserResponseDto>>(allUsers, HttpStatus.OK);
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteUserById(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable String id, @RequestBody UserRequestDto userRequestDto){
        UserResponseDto responseDto = userService.updateUserById(id, userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

}
