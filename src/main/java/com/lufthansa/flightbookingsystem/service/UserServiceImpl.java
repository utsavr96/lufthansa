package com.lufthansa.flightbookingsystem.service;

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

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(UUID id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            user.setAddress(user.getAddress());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }
}
