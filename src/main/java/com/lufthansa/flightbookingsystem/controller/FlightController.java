package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.dto.FlightRequestDto;
import com.lufthansa.flightbookingsystem.dto.FlightResponseDto;
import com.lufthansa.flightbookingsystem.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@AllArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponseDto> createFlight(@RequestBody FlightRequestDto requestDto) {
        FlightResponseDto createdFlight = flightService.createFlight(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<FlightResponseDto> findById(@PathVariable String uuid) {
        FlightResponseDto flight = flightService.findById(uuid);
        return ResponseEntity.ok(flight);
    }

    @GetMapping
    public ResponseEntity<List<FlightResponseDto>> findAllFlights() {
        List<FlightResponseDto> flights = flightService.findAllFlights();
        return ResponseEntity.ok(flights);
    }

    @DeleteMapping("/uuid/{uuid}")
    public ResponseEntity<Void> deleteFlight(@PathVariable String uuid) {
        flightService.deleteFlight(uuid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/uuid/{uuid}")
    public ResponseEntity<FlightResponseDto> updateFlight(@PathVariable String uuid, @RequestBody FlightRequestDto requestDto) {
        FlightResponseDto updatedFlight = flightService.updateFlight(uuid, requestDto);
        return ResponseEntity.ok(updatedFlight);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightResponseDto>> searchFlights(@RequestParam String origin, @RequestParam String destination, @RequestParam int availableSeats) {
        List<FlightResponseDto> flights = flightService.findByOriginAndDestinationAndAvailableSeatsGreaterThanEqual(origin, destination, availableSeats);
        return ResponseEntity.ok(flights);
    }

}
