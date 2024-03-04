package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDto;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDto;
import com.lufthansa.flightbookingsystem.exception.NoFlightOrUserFoundException;
import com.lufthansa.flightbookingsystem.exception.NoSeatAvailableException;
import com.lufthansa.flightbookingsystem.mapper.BookingMapper;
import com.lufthansa.flightbookingsystem.model.Booking;
import com.lufthansa.flightbookingsystem.model.Flight;
import com.lufthansa.flightbookingsystem.model.User;
import com.lufthansa.flightbookingsystem.repository.BookingRepository;
import com.lufthansa.flightbookingsystem.repository.FlightRepository;
import com.lufthansa.flightbookingsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    private final UserRepository userRepository;
    private final BookingMapper bookingMapper;

    @Override
    public BookingResponseDto findById(UUID id) {
        return null;
    }

    @Override
    public List<BookingResponseDto> findAll() {
        return null;
    }

    @Override
    public BookingResponseDto save(BookingRequestDto request) {
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(request.getUserId()));
        Optional<Flight> optionalFlight = flightRepository.findById(UUID.fromString(request.getFlightId()));
        BookingResponseDto bookingResponseDto = null;
        if (optionalFlight.isPresent() && optionalUser.isPresent()){
            Flight flight = optionalFlight.get();
            if(flight.getAvailableSeats() >= request.getNumberOfSeats()){
                Booking booking = bookingMapper.map(request);
                booking.setUser(optionalUser.get());
                booking.setFlight(optionalFlight.get());
                Booking savedBooking = bookingRepository.save(booking);
                flight.setAvailableSeats(flight.getAvailableSeats()-request.getNumberOfSeats());
                flightRepository.save(flight);
                bookingResponseDto = bookingMapper.mapToDto(savedBooking);
            }else throw new NoSeatAvailableException("No seat available.");

        }else throw new NoFlightOrUserFoundException("Check user id or flight id");
        return bookingResponseDto;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public BookingResponseDto findByFlightDestination(String destination) {
        return null;
    }

    @Override
    public List<BookingResponseDto> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime) {
        return null;
    }
}
