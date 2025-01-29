package dev.project.airline.flight;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.project.airline.airport.AirportRequest;
import dev.project.airline.airport.AirportResponse;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("")
    public List<FlightResponse>getFlights() {
        return flightService.findAll();
    }

    // @PostMapping("")
    // public  AirportResponse saveFlight(@RequestBody AirportRequest airportRequest) {
    //     return flightService.save(airportRequest);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<AirportResponse> updateFlight(
    //         @PathVariable Long id,
    //         @RequestBody AirportRequest airportRequest) {
    //     AirportResponse updatedAirport = flightService.updateFlight(id, airportRequest);
    //     return ResponseEntity.ok(updatedAirport);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<AirportResponse> deleteFlight(@PathVariable Long id){
    //     return flightService.deleteById(id);
    // }

}