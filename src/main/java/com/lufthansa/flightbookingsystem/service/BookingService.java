package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDto;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDto;
import com.lufthansa.flightbookingsystem.model.Booking;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookingService {

    BookingResponseDto findById(UUID id);

    List<BookingResponseDto> findAll();

    BookingResponseDto save(BookingRequestDto booking);

    void deleteById(UUID id);

    BookingResponseDto findByFlightDestination(String destination);

    List<BookingResponseDto> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime);
}
