package dev.project.airline.reservation;

import java.sql.Timestamp;

public record  ReservationResumeResponse(
        Long id,
        Timestamp blockingTime,
        int quantitySeats,
        String username,
        ReservationFlightResume flight
){
    
}
