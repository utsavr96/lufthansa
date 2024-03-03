package com.lufthansa.flightbookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FlightbookingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightbookingsystemApplication.class, args);
    }

}
