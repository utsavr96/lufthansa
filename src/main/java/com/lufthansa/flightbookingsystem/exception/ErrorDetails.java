package com.lufthansa.flightbookingsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    LocalDateTime localDateTime;
    String message;
    String description;
}
