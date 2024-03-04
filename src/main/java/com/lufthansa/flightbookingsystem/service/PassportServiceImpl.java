package com.lufthansa.flightbookingsystem.service;

import com.lufthansa.flightbookingsystem.dto.PassportRequestDto;
import com.lufthansa.flightbookingsystem.dto.PassportResponseDto;
import com.lufthansa.flightbookingsystem.mapper.PassportMapper;
import com.lufthansa.flightbookingsystem.model.Passport;
import com.lufthansa.flightbookingsystem.repository.PassportRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class PassportServiceImpl implements PassportService{

    private final PassportRepository passportRepository;

    private final PassportMapper passportMapper;


    @Override
    public PassportResponseDto savePassport(PassportRequestDto passportRequestDto) {
        Passport passport = passportMapper.map(passportRequestDto);
        Passport savedPassport = passportRepository.save(passport);
        return passportMapper.mapToDto(savedPassport);
    }
}
