package com.lufthansa.flightbookingsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassportRequestDto {
    @NotBlank
    private String passportNumber;
    @NotBlank
    private String issuingCountry;
    @NotBlank
    private String expirationDate;
}
