package dev.project.airline.reservation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.project.airline.flight.exceptions.FlightNotFoundException;
import dev.project.airline.user.User;
import dev.project.airline.user.UserRepository;
import dev.project.airline.user.exceptions.UserNotFoundException;

import org.springframework.security.core.Authentication;

@Service
public class ReservationService {
    
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public List<ReservationResponse> authenticatedClientReservation(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        //Search the authenticated user in the DB
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("user  not found with the username")));
        User userAuthenticated = userOptional.get();

        //Search the users related reservations
        List<Reservation> userReservations = reservationRepository.findByUserId(userAuthenticated.getId());
        
        return null;
    }
}
