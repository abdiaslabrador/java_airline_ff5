package dev.project.airline.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.project.airline.user.User;
import dev.project.airline.user.UserRepository;
import dev.project.airline.user.exceptions.UserNotFoundException;

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

    public List<ReservationResumeResponse> adminResumeReservation(){
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResumeResponse> reservationsResponse = new ArrayList<>();
        ReservationAirportResponse airportOrigin;
        ReservationAirportResponse airportDest;
        ReservationFlightResume flightResume;

        for (Reservation reservation : reservations) {

            airportOrigin = new ReservationAirportResponse(reservation.getFlight().getAirportOrigin());
            airportDest = new ReservationAirportResponse(reservation.getFlight().getAirportDest());
            flightResume = new ReservationFlightResume(reservation.getFlight(), airportOrigin, airportDest);

            reservationsResponse.add( 
                                        new ReservationResumeResponse(
                                            reservation.getId(),
                                            reservation.getBlockingTime(),
                                            reservation.getQuantitySeats(),
                                            reservation.getUser().getUsername(),
                                            flightResume
                                        )
                                    );
        }
        
        return reservationsResponse;
    }

}