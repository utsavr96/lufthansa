package com.lufthansa.flightbookingsystem.repository;

import com.lufthansa.flightbookingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
    Optional<List<Flight>> findByArrivalTime(LocalDateTime arrivalTime);

    @Query("SELECT f FROM flights f " +
            "WHERE f.origin = :origin " +
            "AND f.destination = :destination " +
            "AND f.availableSeats >= :seatsNeeded")
    Optional<List<Flight>> findByAvailableSeatsIsNotNAndOriginAndDestination(int seatsNeeded, String origin, String destination);
}

