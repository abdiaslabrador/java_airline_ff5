package dev.project.airline.flight;

import java.time.LocalDateTime;

import dev.project.airline.airport.Airport;
import dev.project.airline.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    private LocalDateTime blockingTime;

    @OneToOne
    @JoinColumn(name = "airport_origin_id")
    private Airport airportOrigin;

    @OneToOne
    @JoinColumn(name = "airport_dest_id")
    private Airport airportDest;

    public Flight() {
    }


    public Flight(Long id, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String code, boolean state, int maxSeats, int seatsOccupied,
            String companyName, LocalDateTime blockingTime, Airport airportOrigin, Airport airportDest) {
        this.id = id;
        this.code = code;
        this.state = state;
        this.maxSeats = maxSeats;
        this.seatsOccupied = seatsOccupied;
        this.blockingTime = blockingTime;
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

    public LocalDateTime getBlockingTime() {
        return blockingTime;
    }

    public void setBlockingTime(LocalDateTime blockingTime) {
        this.blockingTime = blockingTime;
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

}
