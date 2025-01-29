package dev.project.airline.flight;

import dev.project.airline.airport.Airport;

public class FlightMapper {

     public static Flight toEntity(FlightRequest flightRequest, Airport originAirport, Airport destinationAirport) {
        return new Flight(
            flightRequest.departureDateTime(),
            flightRequest.arrivalDateTime(),
            flightRequest.code(),
            flightRequest.state(),
            flightRequest.maxSeats(),
            flightRequest.seatsOccupied(),
            flightRequest.companyName(),
            originAirport,
            destinationAirport
        );
    }

    public static FlightResponse toResponse(Flight flight) {
        return new FlightResponse(
            flight.getId(),
            flight.getDepartureDateTime(),
            flight.getArrivalDateTime(),
            flight.getCode(),
            flight.isState(),
            flight.getMaxSeats(),
            flight.getSeatsOccupied(),
            flight.getCompanyName(),
            flight.getAirportOrigin(),
            flight.getAirportDest()
        );
    }
}
