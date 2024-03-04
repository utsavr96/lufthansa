package com.lufthansa.flightbookingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Passport extends BaseModel {
    private String passportNumber;
    private String issuingCountry;
    private String expirationDate;
}
