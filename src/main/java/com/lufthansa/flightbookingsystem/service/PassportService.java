package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.PassportRequestDto;
import com.lufthansa.flightbookingsystem.dto.PassportResponseDto;

public interface PassportService {

    PassportResponseDto savePassport(PassportRequestDto passportRequestDto);
}
