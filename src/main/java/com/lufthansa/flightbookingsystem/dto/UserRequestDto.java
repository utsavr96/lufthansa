package com.lufthansa.flightbookingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    private String password;
    private String nationality;
    private String address;
    @NotBlank
    private String phoneNumber;
}
