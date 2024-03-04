package com.lufthansa.flightbookingsystem.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponseDto {
    private UUID id;
    private LocalDateTime bookingTime;
    private int numberOfSeats;
    private double totalPrice;
}
