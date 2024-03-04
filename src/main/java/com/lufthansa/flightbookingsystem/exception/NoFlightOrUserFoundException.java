package com.lufthansa.flightbookingsystem.exception;

public class NoFlightOrUserFoundException extends RuntimeException{
    public NoFlightOrUserFoundException(String message){
        super(message);
    }
}
