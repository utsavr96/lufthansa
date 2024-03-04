package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDto;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDto;
import com.lufthansa.flightbookingsystem.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@AllArgsConstructor
@Slf4j
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponseDto> saveBooking(@RequestBody BookingRequestDto requestDto) {
        BookingResponseDto savedBooking = bookingService.save(requestDto);
        log.info("savedBooking ii " + savedBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookingResponseDto> findById(@PathVariable String id) {
        BookingResponseDto booking = bookingService.findById(id);
        return ResponseEntity.ok().body(booking);
    }

    @GetMapping
    public ResponseEntity<List<BookingResponseDto>> findAll() {
        List<BookingResponseDto> bookings = bookingService.findAll();
        return ResponseEntity.ok().body(bookings);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<List<BookingResponseDto>> findByFlightDestination(@PathVariable String destination) {
        List<BookingResponseDto> byFlightDestination = bookingService.findByFlightDestination(destination);
        return ResponseEntity.ok().body(byFlightDestination);
    }

}
