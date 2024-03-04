package com.lufthansa.flightbookingsystem.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookingResponseDTO {
    private UUID id;
    private LocalDateTime bookingTime;
    private Integer numberOfSeats;
    private Double totalPrice;
    private UUID flightId;
    private UUID userId;
}
