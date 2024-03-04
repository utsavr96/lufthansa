package com.lufthansa.flightbookingsystem.mapper;

import com.lufthansa.flightbookingsystem.dto.PassportRequestDto;
import com.lufthansa.flightbookingsystem.dto.PassportResponseDto;
import com.lufthansa.flightbookingsystem.model.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportMapper {
    PassportMapper INSTANCE =Mappers.getMapper(PassportMapper.class);

    Passport map(PassportRequestDto passportRequestDto);

    PassportResponseDto mapToDto(Passport passport);
}
