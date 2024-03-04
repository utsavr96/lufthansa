package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDTO;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDTO;
import com.lufthansa.flightbookingsystem.model.Booking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingService {

    Optional<Booking> findById(UUID id);

    List<Booking> findAll();

    BookingResponseDTO save(BookingRequestDTO booking);

    void deleteById(UUID id);

    Optional<Booking> findByFlightDestination(String destination);

    Optional<List<Booking>> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime);
}
