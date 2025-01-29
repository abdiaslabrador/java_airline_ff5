package dev.project.airline.flight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class FlightService {
    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightResponse>findAll(){
        List<FlightResponse> flights  = new ArrayList<>();
        for (Flight flight : flightRepository.findAll()) {
            flights.add(FlightMapper.toResponse(flight));
        }
        return flights;
    }

    // public AirportResponse saveFlight(@RequestBody AirportRequest airportRequest) {
    //     return flightService.save(airportRequest);
    // }

    // public ResponseEntity<AirportResponse> updateFlight(
    //         @PathVariable Long id,
    //         @RequestBody AirportRequest airportRequest) {
    //     AirportResponse updatedAirport = flightService.updateFlight(id, airportRequest);
    //     return ResponseEntity.ok(updatedAirport);
    // }

    // public ResponseEntity<AirportResponse> deleteFlight(@PathVariable Long id){
    //     return flightService.deleteById(id);
    // }
}
