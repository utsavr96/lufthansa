package com.lufthansa.flightbookingsystem.config;

import com.lufthansa.flightbookingsystem.mapper.BookingMapper;
import com.lufthansa.flightbookingsystem.mapper.FlightMapper;
import com.lufthansa.flightbookingsystem.mapper.UserMapper;
import com.lufthansa.flightbookingsystem.model.Flight;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {
    @Bean
    public BookingMapper bookingMapper() {
        return Mappers.getMapper(BookingMapper.class);
    }

    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }

    @Bean
    public FlightMapper flightMapper() { return Mappers.getMapper(FlightMapper.class);
    }
}
