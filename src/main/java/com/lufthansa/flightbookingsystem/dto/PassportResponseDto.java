package com.lufthansa.flightbookingsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PassportResponseDto {
    private UUID id;
    private String passportNumber;
    private String issuingCountry;
    private String expirationDate;
}
