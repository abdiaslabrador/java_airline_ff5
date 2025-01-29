package dev.project.airline.flight.exceptions;

public class FlightGreaterThanMaxSeats extends RuntimeException{

    public FlightGreaterThanMaxSeats(String message) {
        super(message);
    }

    public FlightGreaterThanMaxSeats(String message, Throwable cause) {
        super(message, cause);
    }
    
}
