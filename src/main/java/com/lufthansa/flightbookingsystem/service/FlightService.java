package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightService {
    Flight saveFlight(Flight flight);

    Optional<Flight> getFlightById(UUID id);

    List<Flight> getAllFlights();

    void deleteFlight(UUID id);

    Optional<List<Flight>> findByArrivalTime(LocalDateTime arrivalTime);

    Optional<List<Flight>> findByDestinationAndArrivalIfSeatsAvailable(int seatsNeeded, String origin, String destination);
}
