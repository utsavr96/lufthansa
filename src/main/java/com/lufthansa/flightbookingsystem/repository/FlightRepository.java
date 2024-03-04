package com.lufthansa.flightbookingsystem.repository;

import com.lufthansa.flightbookingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
    Optional<List<Flight>> findByArrivalTime(LocalDateTime arrivalTime);

    //@Query(value = RepositoryQuery.FIND_FLIGHT_FROM_ORIGIN_TO_DESTINATION_WITH_SEATS)
    List<Flight> findByOriginAndDestinationAndAvailableSeatsGreaterThanEqual(String origin, String destination, int availableSeats);
}

