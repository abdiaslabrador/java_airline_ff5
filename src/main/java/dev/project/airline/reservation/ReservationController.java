package dev.project.airline.reservation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.project.airline.flight.FlightService;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    
    // private final FlightService flightService;
    // private final UserService userService;
    private final ReservationService reservationService;
    
    public ReservationController(FlightService flightService, ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // public ReservationController() {
        
    // }

    @GetMapping("/client")
    public ResponseEntity<List<ReservationResponse>> AuthenticatedClientReservation(){
        List<ReservationResponse> userReservations = reservationService.authenticatedClientReservation();
        return new ResponseEntity<>(userReservations, HttpStatus.OK);
    }

}
