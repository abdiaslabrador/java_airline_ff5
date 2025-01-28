package dev.project.airline.flight;

import java.time.LocalDateTime;

import dev.project.airline.airport.Airport;

public record  FlightResponse(
    Long id,
    LocalDateTime departureDateTime,
    LocalDateTime arrivalDateTime,
    String code,
    boolean state,
    int maxSeats,
    int seatsOccupied,
    String companyName,
    LocalDateTime blockingTime,
    Airport airportOrigin,
    Airport airportest
) {
    
}
