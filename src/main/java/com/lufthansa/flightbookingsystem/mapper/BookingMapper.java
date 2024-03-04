package com.lufthansa.flightbookingsystem.mapper;

import com.lufthansa.flightbookingsystem.dto.BookingRequestDto;
import com.lufthansa.flightbookingsystem.dto.BookingResponseDto;
import com.lufthansa.flightbookingsystem.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    Booking map(BookingRequestDto bookingRequest);

    BookingResponseDto mapToDto(Booking booking);

    List<BookingResponseDto> mapToDto(List<Booking> bookings);

}
