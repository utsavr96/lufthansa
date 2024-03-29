package com.lufthansa.flightbookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel {
    private LocalDateTime bookingTime;
    private int numberOfSeats;
    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
