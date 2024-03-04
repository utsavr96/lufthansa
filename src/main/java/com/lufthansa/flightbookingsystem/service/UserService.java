package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(UUID id);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByPassportNumber(String passportNumber);

    List<User> getAllUsers();

    User updateUser(UUID id, User user);

    void deleteUser(UUID id);
}
