package com.lufthansa.flightbookingsystem.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private UUID id;
    private String email;
    private String password;
    private String nationality;
    private String address;
    private String phoneNumber;
}
