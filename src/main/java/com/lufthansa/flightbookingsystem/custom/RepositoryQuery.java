package com.lufthansa.flightbookingsystem.custom;

public interface RepositoryQuery {
    String FIND_FLIGHT_FROM_ORIGIN_TO_DESTINATION_WITH_SEATS = "SELECT f FROM flights f " +
            "WHERE f.origin = :origin " +
            "AND f.destination = :destination " +
            "AND f.availableSeats >= :seatsNeeded";
}
