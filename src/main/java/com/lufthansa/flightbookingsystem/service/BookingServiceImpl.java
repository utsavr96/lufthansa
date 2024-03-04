package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDTO;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDTO;
import com.lufthansa.flightbookingsystem.mapper.BookingMapper;
import com.lufthansa.flightbookingsystem.model.Booking;
import com.lufthansa.flightbookingsystem.repository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public Optional<Booking> findById(UUID id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingResponseDTO save(BookingRequestDTO booking) {
        Booking mappedBooking = bookingMapper.map(booking);
        Booking savedBooking = bookingRepository.save(mappedBooking);
        return bookingMapper.mapToDto(savedBooking);
    }

    @Override
    public void deleteById(UUID id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Optional<Booking> findByFlightDestination(String destination) {
        return bookingRepository.findByFlight_Destination(destination);
    }

    @Override
    public Optional<List<Booking>> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime) {
        return bookingRepository.findBookingBetweenTime(startTime, endTime);
    }
}
