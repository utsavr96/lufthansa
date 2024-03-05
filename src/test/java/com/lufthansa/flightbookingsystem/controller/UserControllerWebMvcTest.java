package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.exception.UserNotFoundException;
import com.lufthansa.flightbookingsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUsersReturnsUserNotFoundExceptionWhenNoUsers() throws Exception {
        when(userService.findAllUsers()).thenThrow(UserNotFoundException.class);
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().is(404));
    }
}
