package dev.project.airline.flight;

public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // public Flight create(FlightRequest flightRequest) {
    // }
}
