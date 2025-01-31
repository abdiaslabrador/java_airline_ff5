package dev.project.airline.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.project.airline.flight.FlightResponse;
import dev.project.airline.user.User;
import dev.project.airline.user.UserMapper;
import dev.project.airline.user.UserRepository;
import dev.project.airline.user.exceptions.UserNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

@Service
public class ReservationService {
    
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationClientResponse> authenticatedClientReservation(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("user  not found with the username")));
        User userAuthenticated = userOptional.get();

        List<Reservation> reservations = reservationRepository.findByUserId(userAuthenticated.getId());
        
        List<ReservationClientResponse> reservationsResponse = new ArrayList<>();

        for (Reservation reservation : reservations) {
                reservationsResponse.add( 
                                            new ReservationClientResponse(
                                                reservation.getId(),
                                                reservation.getBlockingTime(),
                                                reservation.getQuantitySeats(),
                                                reservation.getFlight()
                                            )
                                        );
        }

        return reservationsResponse;
    }


    public List<ReservationClientResponse> adminSpecificClient(String username){
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("user  not found with the username")));
        User userAuthenticated = userOptional.get();
        List<Reservation> reservations = reservationRepository.findByUserId(userAuthenticated.getId());
        List<ReservationClientResponse> reservationsResponse = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservationsResponse.add( 
                                        new ReservationClientResponse(
                                            reservation.getId(),
                                            reservation.getBlockingTime(),
                                            reservation.getQuantitySeats(),
                                            reservation.getFlight()
                                        )
                                    );
        }
        return reservationsResponse;
    }

    // public List<ReservationResumeResponse> adminResumeReservation(){
    //     List<Reservation> reservations = reservationRepository.findAll();
    //     List<ReservationResumeResponse> reservationsResponse = new ArrayList<>();
    //     for (Reservation reservation : reservations) {

    //         reservationsResponse.add( 
    //                                     new ReservationResumeResponse(
    //                                         reservation.getId(),
    //                                         reservation.getBlockingTime(),
    //                                         reservation.getQuantitySeats(),
    //                                         reservation.getUser().getUsername(),
    //                                         ReservationFlightResume(reservation.getFlight())
    //                                         private ReservationAirportResponse airportOrigin;
    //                                         private ReservationAirportResponse airportDest;
    //                                     )
    //                                 );
    //     }
        
    //     return reservationsResponse;
    // }

    // {
    //     "id": 2,
    //     "blockingTime": "2025-01-30T06:40:00.000+00:00",*
    //     "quantitySeats": 75,*
    //     "username": "jose",*
    //     "flight": {
    //         "id": 1,
    //         "departureDateTime": "2025-01-30T08:00:00", *
    //         "arrivalDateTime": "2025-01-30T12:30:00", *
    //         "code": "AA1234", *
    //         "maxSeats": 200, *
    //         "seatsOccupied": 150, *
    //         "airportOrigin": {
    //             "id": 1,
    //             "code": "DFW"*
    //         },
    //         "airportDest": {
    //             "id": 2,
    //             "code": "JFK"*
    //         }
    //     }
    // },

}