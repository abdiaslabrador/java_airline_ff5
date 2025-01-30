package dev.project.airline.reservation;

import java.sql.Timestamp;

import dev.project.airline.flight.Flight;
import dev.project.airline.flight.FlightResponse;
import dev.project.airline.user.User;
import dev.project.airline.user.UserResponse;

public record ReservationResumeAdminResponse(
        Long id,
        Timestamp blockingTime,
        int quantitySeats,
        UserResponse user,
        FlightResponse flight
) {
}

