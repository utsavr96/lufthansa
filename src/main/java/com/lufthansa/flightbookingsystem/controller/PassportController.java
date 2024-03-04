package com.lufthansa.flightbookingsystem.controller;

import com.lufthansa.flightbookingsystem.dto.PassportRequestDto;
import com.lufthansa.flightbookingsystem.dto.PassportResponseDto;
import com.lufthansa.flightbookingsystem.service.PassportService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passport")
@AllArgsConstructor
public class PassportController {

    private final PassportService passportService;

    @PostMapping
    public ResponseEntity<PassportResponseDto> savePassport(@Valid  @RequestBody PassportRequestDto passportRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(passportService.savePassport(passportRequestDto));
    }
}
