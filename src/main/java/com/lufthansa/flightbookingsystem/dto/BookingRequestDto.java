package com.lufthansa.flightbookingsystem.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingRequestDto {

    @NotNull
    private LocalDateTime bookingTime;

    @NotNull
    private int numberOfSeats;

    @NotNull
    private double totalPrice;

    @NotBlank
    private String flightId;

    @NotBlank
    private String userId;

}
