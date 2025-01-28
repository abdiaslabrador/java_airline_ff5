package dev.project.airline.airport.exceptions;


public class AirportDoNotMatch extends RuntimeException{

    public AirportDoNotMatch(String message) {
        super(message);
    }

    public AirportDoNotMatch(String message, Throwable cause) {
        super(message, cause);
    }
    
}
