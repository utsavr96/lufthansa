package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDto;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDto;
import com.lufthansa.flightbookingsystem.exception.BookingNotFoundException;
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
    public BookingResponseDto findById(String uuid) {
        Optional<Booking> optionalBooking = bookingRepository.findById(UUID.fromString(uuid));
        if (optionalBooking.isPresent()) return bookingMapper.mapToDto(optionalBooking.get());
        else throw new BookingNotFoundException("No booking available!");
    }

    @Override
    public List<BookingResponseDto> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        if (!bookings.isEmpty()) return bookingMapper.mapToDto(bookings);
        else throw new BookingNotFoundException("No booking available!");
    }

    @Override
    public BookingResponseDto save(BookingRequestDto request) {
        log.info("finding user with id "+request.getUserId());
        Optional<User> optionalUser = userRepository.findById(UUID.fromString(request.getUserId()));
        log.info("user :"+ optionalUser.get().getEmail());
        log.info("finding flight with id "+request.getFlightId());
        Optional<Flight> optionalFlight = flightRepository.findById(UUID.fromString(request.getFlightId()));
        log.info("flight :"+ optionalFlight.get());
        BookingResponseDto bookingResponseDto = null;
        if (optionalFlight.isPresent() && optionalUser.isPresent()) {
            Flight flight = optionalFlight.get();
            if (flight.getAvailableSeats() >= request.getNumberOfSeats()) {
                log.info(""+flight.getAvailableSeats()+" seats are available.");
                Booking booking = bookingMapper.map(request);
                booking.setUser(optionalUser.get());
                booking.setFlight(optionalFlight.get());
                Booking savedBooking = bookingRepository.save(booking);
                log.info("booking created!");
                flight.setAvailableSeats(flight.getAvailableSeats() - request.getNumberOfSeats());
                flightRepository.save(flight);
                log.info("flight updated!");
                bookingResponseDto = bookingMapper.mapToDto(savedBooking);
            } else throw new NoSeatAvailableException("No seat available.");

        } else throw new NoFlightOrUserFoundException("Check user id or flight id");
        return bookingResponseDto;
    }

    @Override
    public void deleteById(String uuid) {
        bookingRepository.deleteById(UUID.fromString(uuid));
    }

    @Override
    public List<BookingResponseDto> findByFlightDestination(String destination) {
        Optional<List<Booking>> optionalBooking = bookingRepository.findByFlight_Destination(destination);
        if (optionalBooking.isPresent()) return bookingMapper.mapToDto(optionalBooking.get());
        else throw new BookingNotFoundException("No booking available!");
    }

    @Override
    public List<BookingResponseDto> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime) {
        Optional<List<Booking>> bookingBetweenTime = bookingRepository.findBookingBetweenTime(startTime, endTime);
        if (bookingBetweenTime.isPresent() && !bookingBetweenTime.get().isEmpty())
            return bookingMapper.mapToDto(bookingBetweenTime.get());
        else throw new BookingNotFoundException("No booking available!");
    }
}
