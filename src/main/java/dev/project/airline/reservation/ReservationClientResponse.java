package dev.project.airline.reservation;

import java.sql.Timestamp;

import dev.project.airline.flight.Flight;

public record ReservationClientResponse(
        Long id,
        Timestamp blockingTime,
        int quantitySeats,
        Flight flight
) {
    
}