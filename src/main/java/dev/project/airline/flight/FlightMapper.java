package dev.project.airline.flight;

public class FlightMapper {

     public static Flight toEntity(FlightRequest flightRequest) {
        return new Flight(
            flightRequest.departureDateTime(),
            flightRequest.arrivalDateTime(),
            flightRequest.code(),
            flightRequest.state(),
            flightRequest.maxSeats(),
            flightRequest.seatsOccupied(),
            flightRequest.companyName(),
            flightRequest.blockingTime(),
            flightRequest.airportOrigin(),
            flightRequest.airportDest()
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
            flight.getBlockingTime(),
            flight.getAirportOrigin(),
            flight.getAirportDest()
        );
    }
}
