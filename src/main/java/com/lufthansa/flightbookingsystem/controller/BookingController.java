package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDTO;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDTO;
import com.lufthansa.flightbookingsystem.model.Booking;
import com.lufthansa.flightbookingsystem.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable UUID id) {
        Optional<Booking> booking = bookingService.findById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.findAll();
        return ResponseEntity.ok(bookings);
    }

    @PostMapping
    public ResponseEntity<BookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequest) {
        BookingResponseDTO createdBooking = bookingService.save(bookingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable UUID id) {
        bookingService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/destination/{destination}")
    public ResponseEntity<Booking> getBookingByDestination(@PathVariable String destination) {
        Optional<Booking> booking = bookingService.findByFlightDestination(destination);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/time")
    public ResponseEntity<List<Booking>> getBookingsBetweenTime(@RequestParam LocalDateTime startTime,
                                                                @RequestParam LocalDateTime endTime) {
        Optional<List<Booking>> bookings = bookingService.findBookingBetweenTime(startTime, endTime);
        return bookings.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
