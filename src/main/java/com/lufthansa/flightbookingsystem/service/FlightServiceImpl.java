package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.model.Flight;
import com.lufthansa.flightbookingsystem.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Transactional
@AllArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> getFlightById(UUID id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) return flight;
        return Optional.empty();
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public void deleteFlight(UUID id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Optional<List<Flight>> findByArrivalTime(LocalDateTime arrivalTime) {
        return flightRepository.findByArrivalTime(arrivalTime);
    }

    @Override
    public Optional<List<Flight>> findByDestinationAndArrivalIfSeatsAvailable(int seatsNeeded, String origin, String destination) {
        return flightRepository.findByAvailableSeatsIsNotNAndOriginAndDestination(seatsNeeded, origin, destination);
    }
}
