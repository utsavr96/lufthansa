package com.lufthansa.flightbookingsystem.mapper;

import com.lufthansa.flightbookingsystem.dto.FlightRequestDto;
import com.lufthansa.flightbookingsystem.dto.FlightResponseDto;
import com.lufthansa.flightbookingsystem.model.Flight;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FlightMapper {

    Flight map(FlightRequestDto requestDto);

    FlightResponseDto mapToDto(Flight flight);

    List<FlightResponseDto> mapToDto(List<Flight> flight);
}
