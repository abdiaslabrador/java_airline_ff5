package dev.project.airline.flight;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.project.airline.reservation.ReservationResumeResponse;
import dev.project.airline.user.UserResponse;
import dev.project.airline.user.UserService;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    // -se le solicita proporcionar el aeropuerto de salida, destino, fecha y número de plazas
    // -se muestra una lista de vuelos disponibles que coinciden con los criterios
    @GetMapping("/search")
    public ResponseEntity<List<FlightResponse>> adminSearchReservation(
         @RequestParam String originCodeAirport,
         @RequestParam String destinationCodeAirport,
         @RequestParam String date,
         @RequestParam Integer enableSeats
    ){

        // Define el formato de la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime;

        try {
            // Convierte la cadena a LocalDateTime
            localDateTime = LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format. Use 'yyyy-MM-dd HH:mm:ss' (e.g., 2026-01-25 16:30:00)");
        }

        List<FlightResponse> userReservations = flightService.search(originCodeAirport, destinationCodeAirport,
                                                                                localDateTime, enableSeats);
        return new ResponseEntity<>(userReservations, HttpStatus.OK);
    }


    // @GetMapping("/search")
    // public ResponseEntity<List<FlightResponseDTO>> searchFlights(
    //         @RequestParam String originCodeAirport,
    //         @RequestParam String destinationCodeAirport,
    //         @RequestParam String date,
    //         @RequestParam Integer seats){

    //     // convert the date to a TimeStamp
    //     Timestamp timestamp;
    //     try {
    //         String formattedDate = date.replace("T", " ").split("\\.")[0];
    //         timestamp = Timestamp.valueOf(formattedDate);
            
    //     } catch (IllegalArgumentException e) {
    //         throw new RuntimeException("Invalid date format. Use 'YYYY-MM-DDTHH:mm:ss' (e.g., 2026-01-25T16:30:00)");
    //     }

    //     List <FlightResponseDTO> flights = flightService.searchFlights(originCodeAirport, destinationCodeAirport, timestamp, seats);
    //     return new ResponseEntity<>(flights, HttpStatus.OK);
    // }

    
}