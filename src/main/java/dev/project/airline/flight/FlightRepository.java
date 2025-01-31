package dev.project.airline.flight;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {
     @Query("SELECT f FROM Flight f WHERE f.airportOrigin.code = :originCode " +
           "AND f.airportDest.code = :destCode " +
           "AND f.departureDateTime = :departureDate " +
           "AND (f.maxSeats - f.seatsOccupied) >= :numberOfSeats")
            List<Flight> findAvailableFlights(
                @Param("originCode") String originCode,
                @Param("destCode") String destCode,
                @Param("departureDate") LocalDateTime departureDate,
                @Param("numberOfSeats") int numberOfSeats
            );
}
