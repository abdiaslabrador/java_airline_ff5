package dev.project.airline.reservation;

import java.sql.Timestamp;

import dev.project.airline.user.UserResponse;

public record ReservationResumeAdminResponse(
        Long id,
        Timestamp blockingTime,
        int quantitySeats,
        UserResponse user,
        ReservationFlightResume flight
) {
}

