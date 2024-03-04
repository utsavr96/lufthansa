package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.UserRequestDto;
import com.lufthansa.flightbookingsystem.dto.UserResponseDto;
import com.lufthansa.flightbookingsystem.exception.UserNotFoundException;
import com.lufthansa.flightbookingsystem.mapper.UserMapper;
import com.lufthansa.flightbookingsystem.model.User;
import com.lufthansa.flightbookingsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public UserResponseDto findById(String uuid) {
        UUID id = UUID.fromString(uuid);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User user1 = user.get();
            return userMapper.mapToDto(user1);
        } else throw new UserNotFoundException("No user found with id " + uuid);
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.mapListToDto(users);
    }

    @Override
    public void deleteUser(String uuid) {
        UUID id = UUID.fromString(uuid);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else throw new UserNotFoundException("No user found with id " + id);
    }

    @Override
    public UserResponseDto updateUserById(String uuid, UserRequestDto requestDto) {
        UUID id = UUID.fromString(uuid);
        Optional<User> userOptional = userRepository.findById(id);
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user.setAddress(requestDto.getAddress());
            user.setEmail(requestDto.getEmail());
            user.setNationality(requestDto.getNationality());
            user.setPhoneNumber(requestDto.getPhoneNumber());
            user.setPassword(requestDto.getPassword());
            userRepository.save(user);
        } else throw new UserNotFoundException("No user found with id " + id);
        return userMapper.mapToDto(user);
    }


}
