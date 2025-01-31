package dev.project.airline.reservation;

import dev.project.airline.airport.Airport;
import dev.project.airline.flight.Flight;

public class ReservationAirportResponse {
    private Long id;
    private String airportName;

    public ReservationAirportResponse(Airport airport) {
        this.id = airport.getId();
        this.airportName = airport.getName();
    }
}
