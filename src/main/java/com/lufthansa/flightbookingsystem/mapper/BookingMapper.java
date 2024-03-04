package com.lufthansa.flightbookingsystem.mapper;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDTO;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDTO;
import com.lufthansa.flightbookingsystem.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(target = "flight.id", source = "bookingRequest.flightId", qualifiedByName = "stringToUUID")
    @Mapping(target = "user.id", source = "bookingRequest.userId", qualifiedByName = "stringToUUID")
    Booking map(BookingRequestDTO bookingRequest);

    BookingResponseDTO mapToDto(Booking booking);

    @Named("stringToUUID")
    default UUID stringToUUID(String value) {
        return UUID.fromString(value);
    }
}
