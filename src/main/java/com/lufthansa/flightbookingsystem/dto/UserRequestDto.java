package com.lufthansa.flightbookingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String password;
    private String nationality;
    private String address;
    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;
}
