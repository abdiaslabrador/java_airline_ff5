package dev.project.airline.reservation;

import java.sql.Timestamp;

import dev.project.airline.flight.Flight;
import dev.project.airline.user.User;

public record ReservationResponse(
        Long id,
        Timestamp blockingTime,
        int quantitySeats,
        Flight flight
) {
}
