package dev.project.airline.flight;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.project.airline.airport.Airport;
import dev.project.airline.reservation.Reservation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private String code;
    private boolean state;
    private int maxSeats;
    private int seatsOccupied;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "airport_origin_id")
    private Airport airportOrigin;

    @ManyToOne
    @JoinColumn(name = "airport_dest_id")
    private Airport airportDest;

    @JsonIgnore
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Reservation> reservations;

    public Flight() {
    }


    public Flight(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String code, boolean state, int maxSeats, int seatsOccupied,
            String companyName,  Airport airportOrigin, Airport airportDest) {
        this.code = code;
        this.state = state;
        this.maxSeats = maxSeats;
        this.seatsOccupied = seatsOccupied;
        this.airportOrigin = airportOrigin;
        this.airportDest = airportDest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public int getSeatsOccupied() {
        return seatsOccupied;
    }

    public void setSeatsOccupied(int seatsOccupied) {
        this.seatsOccupied = seatsOccupied;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Airport getAirportOrigin() {
        return airportOrigin;
    }

    public void setAirportOrigin(Airport airportOrigin) {
        this.airportOrigin = airportOrigin;
    }

    public Airport getAirportDest() {
        return airportDest;
    }

    public void setAirportDest(Airport airportDest) {
        this.airportDest = airportDest;
    }


    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }


    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }


    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }    
}
