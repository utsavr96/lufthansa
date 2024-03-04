package com.lufthansa.flightbookingsystem.repository;

import com.lufthansa.flightbookingsystem.model.Booking;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {

    Optional<Booking> findByFlight_Destination(String destination);

    @Query("select bookings from bookings where bookingTime between :startTime and :endTime")
    Optional<List<Booking>> findBookingBetweenTime(LocalDateTime startTime, LocalDateTime endTime);

}
