package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.FlightRequestDto;
import com.lufthansa.flightbookingsystem.dto.FlightResponseDto;

import java.util.List;

public interface FlightService {

    FlightResponseDto createFlight(FlightRequestDto requestDto);

    FlightResponseDto findById(String uuid);

    List<FlightResponseDto> findAllFlights();

    void deleteFlight(String uuid);

    FlightResponseDto updateFlight(String uuid, FlightRequestDto requestDto);

    List<FlightResponseDto> findByOriginAndDestinationAndAvailableSeatsGreaterThanEqual(String origin, String destination, int availableSeats);
}
