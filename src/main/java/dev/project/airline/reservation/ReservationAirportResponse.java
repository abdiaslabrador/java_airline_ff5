package dev.project.airline.reservation;

import dev.project.airline.airport.Airport;

public class ReservationAirportResponse {
    private Long id;
    private String airportName;

    public ReservationAirportResponse(Airport airport) {
        this.id = airport.getId();
        this.airportName = airport.getName();
    }

    public Long getId() {
        return id;
    }

    public String getAirportName() {
        return airportName;
    }
    
}
