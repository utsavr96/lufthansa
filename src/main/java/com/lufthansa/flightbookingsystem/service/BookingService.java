package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDto;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    BookingResponseDto findById(String uuid);

    List<BookingResponseDto> findAll();

    BookingResponseDto save(BookingRequestDto booking);

    void deleteById(String uuid);

    List<BookingResponseDto> findByFlightDestination(String destination);

    List<BookingResponseDto> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime);
}
