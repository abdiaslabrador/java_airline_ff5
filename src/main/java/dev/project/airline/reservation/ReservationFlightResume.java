package dev.project.airline.reservation;

import java.time.LocalDateTime;

import dev.project.airline.flight.Flight;

public class ReservationFlightResume {
    private Long id;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String code;
    private int maxSeats;
    private int seatsOccupied;
    private ReservationAirportResponse airportOrigin;
    private ReservationAirportResponse airportDest;

    public ReservationFlightResume(Flight flight, ReservationAirportResponse airportOrigin, ReservationAirportResponse airportDest) {
        this.id = flight.getId();
        this.departureDateTime = flight.getDepartureDateTime();
        this.arrivalDateTime = flight.getArrivalDateTime();
        this.code = flight.getCode();
        this.maxSeats = flight.getMaxSeats();
        this.seatsOccupied = flight.getSeatsOccupied();
        this.airportOrigin = airportOrigin;
        this.airportDest = airportDest;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getCode() {
        return code;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getSeatsOccupied() {
        return seatsOccupied;
    }

    public ReservationAirportResponse getAirportOrigin() {
        return airportOrigin;
    }

    public ReservationAirportResponse getAirportDest() {
        return airportDest;
    }

}
