package dev.project.airline.flight;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.project.airline.airport.AirportRequest;
import dev.project.airline.airport.AirportResponse;
import dev.project.airline.user.User;
import dev.project.airline.user.UserResponse;
import dev.project.airline.user.UserService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final FlightService flightService;
    private final UserService userService;

    public FlightController(FlightService flightService, UserService userService) {
        this.flightService = flightService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<FlightResponse>getFlights() {
        return flightService.findAll();
    }

    @GetMapping("users")
    public UserResponse  users() {
        return userService.findAll();
    }

    @PostMapping("")
    public  FlightResponse  saveFlight(@RequestBody FlightRequest flightRequest) {
        return flightService.saveFlight(flightRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightResponse>updateFlight(
        @PathVariable Long id,
        @RequestBody FlightRequest flightRequest) {
        FlightResponse updatedAirport = flightService.updateFlight(id, flightRequest);
        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FlightResponse> deleteFlight(@PathVariable Long id){
        return flightService.deleteById(id);
    }

}