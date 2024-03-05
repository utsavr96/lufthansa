package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.dto.UserResponseDto;
import com.lufthansa.flightbookingsystem.exception.UserNotFoundException;
import com.lufthansa.flightbookingsystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


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

    @Test
    void returnListOfProductsWhenProductExists() throws Exception {
        List<UserResponseDto> users = new ArrayList<>();
        users.add(UserResponseDto.builder().id(UUID.randomUUID())
                .email("abc@gmail.com")
                .address("Ghaziabad")
                .nationality("Indian")
                .password("pwd123")
                .phoneNumber("+918881886454")
                .build());
        when(userService.findAllUsers()).thenReturn(users);
        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is("abc@gmail.com")))
                .andExpect(jsonPath("$[0].address", is("Ghaziabad")));
    }
}
