package com.lufthansa.flightbookingsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "bookings")
public class Booking extends BaseModel{
    private LocalDateTime bookingTime;
    private int numberOfSeats;
    private double totalPrice;
    @OneToMany(mappedBy = "booking", cascade = {CascadeType.PERSIST ,CascadeType.REMOVE})
    private List<Flight> flight;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
