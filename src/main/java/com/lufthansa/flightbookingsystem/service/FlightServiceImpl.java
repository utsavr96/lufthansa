package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.FlightRequestDto;
import com.lufthansa.flightbookingsystem.dto.FlightResponseDto;
import com.lufthansa.flightbookingsystem.exception.FlightNotFoundException;
import com.lufthansa.flightbookingsystem.mapper.FlightMapper;
import com.lufthansa.flightbookingsystem.model.Flight;
import com.lufthansa.flightbookingsystem.repository.FlightRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Override
    public FlightResponseDto createFlight(FlightRequestDto requestDto) {
        Flight mappedFlight = flightMapper.map(requestDto);
        return flightMapper.mapToDto(flightRepository.save(mappedFlight));
    }

    @Override
    public FlightResponseDto findById(String uuid) {
        UUID id = UUID.fromString(uuid);
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) return flightMapper.mapToDto(flight.get());
        else throw new FlightNotFoundException("Flight not found with id " + uuid);
    }

    @Override
    public List<FlightResponseDto> findAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        if (flights != null && flights.size() > 0) {
            return flightMapper.mapToDto(flights);
        }
        throw new FlightNotFoundException("No flights found.");
    }

    @Override
    public void deleteFlight(String uuid) {
        UUID id = UUID.fromString(uuid);
        flightRepository.deleteById(id);
    }

    @Override
    public FlightResponseDto updateFlight(String uuid, FlightRequestDto requestDto) {
        UUID id = UUID.fromString(uuid);
        Flight flight;
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if (optionalFlight.isPresent()) {
            flight = optionalFlight.get();
            flight.setFlightNumber(requestDto.getFlightNumber());
            flight.setOrigin(requestDto.getOrigin());
            flight.setDestination(requestDto.getDestination());
            flight.setArrivalTime(requestDto.getArrivalTime());
            flight.setDepartureTime(requestDto.getDepartureTime());
            flight.setAvailableSeats(requestDto.getAvailableSeats());
            flightRepository.save(flight);
        } else throw new FlightNotFoundException("No flight found with id " + uuid);
        return flightMapper.mapToDto(flight);
    }

    @Override
    public List<FlightResponseDto> findByOriginAndDestinationAndAvailableSeatsGreaterThanEqual(String origin, String destination, int availableSeats) {
        List<Flight> flights = flightRepository.findByOriginAndDestinationAndAvailableSeatsGreaterThanEqual(origin, destination, availableSeats);
        if (flights != null && flights.size() > 0) {
            return flightMapper.mapToDto(flights);
        }
        throw new FlightNotFoundException("No flights found.");
    }
}
