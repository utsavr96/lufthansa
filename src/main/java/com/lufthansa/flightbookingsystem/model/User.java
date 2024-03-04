package com.lufthansa.flightbookingsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    List<Booking> bookings;
    private String username;
    private String email;
    private String password;
    private String nationality;
    private String address;
    private String phoneNumber;
}
