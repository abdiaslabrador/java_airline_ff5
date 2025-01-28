package dev.project.airline.airport;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.airline.user.User;
import dev.project.airline.user.UserService;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {

    private final AirportService  airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("")
    public List<AirportResponse>getAirport() {
        return airportService.findAll();
    }

    @PostMapping("")
    public  AirportResponse saveAirport(@RequestBody AirportRequest airportRequest) {
        return airportService.save(airportRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportResponse> updateAirport(
            @PathVariable Long id,
            @RequestBody AirportRequest airportRequest) {
        AirportResponse updatedAirport = airportService.updateAirport(id, airportRequest);
        return ResponseEntity.ok(updatedAirport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AirportResponse> deleteAirport(@PathVariable Long id){
        return airportService.deleteById(id);
    }
    
}
