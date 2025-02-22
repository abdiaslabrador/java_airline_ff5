package dev.project.airline.flight;

import java.time.LocalDateTime;

public record FlightRequest(
    LocalDateTime departureDateTime,
    LocalDateTime arrivalDateTime,
    String code,
    boolean state,
    int maxSeats,
    int seatsOccupied,
    String companyName,
    Long  airportOriginId,
    Long  airportDestId
) {

}