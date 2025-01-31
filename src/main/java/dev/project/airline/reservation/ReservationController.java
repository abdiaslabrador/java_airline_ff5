package dev.project.airline.reservation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    
    private final ReservationService reservationService;
    
    public ReservationController( ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // -Los clientes deberán poder obtener el listado de sus reservas con información de los vuelos (sus reservas)
    @GetMapping("/client")
    public ResponseEntity<List<ReservationClientResponse>> authenticatedClientReservation(){
        List<ReservationClientResponse> userReservations = reservationService.authenticatedClientReservation();
        return new ResponseEntity<>(userReservations, HttpStatus.OK);
    }

    // -Debemos poder obtener la lista del historial de reservas por cada usuario (ROLE_USER) *
    @GetMapping("/admin/client/{username}")
    public ResponseEntity<List<ReservationClientResponse>> adminSpecificClient(@PathVariable String username){
        List<ReservationClientResponse>  userReservations = reservationService.adminSpecificClient(username);
        return new ResponseEntity<>(userReservations, HttpStatus.OK);
    }

    // -Listado **resumido** de las reservas efectuadas por parte los clientes.
    @GetMapping("/admin/resumeclient")
    public ResponseEntity<List<ReservationResumeResponse>> adminResumeReservation(){
        List<ReservationResumeResponse> userReservations = reservationService.adminResumeReservation();
        return new ResponseEntity<>(userReservations, HttpStatus.OK);
    }
}
