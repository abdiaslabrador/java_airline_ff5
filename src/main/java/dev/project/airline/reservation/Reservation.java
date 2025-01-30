package dev.project.airline.reservation;

import java.sql.Timestamp;

import dev.project.airline.flight.Flight;
import dev.project.airline.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private int quantitySeats;
    private Timestamp blockingTime;

    

    public Reservation() {
    }

    public Reservation(Long id, User user, Flight flight, Timestamp blockingTime, int quantitySeats) {
        this.id = id;
        this.user = user;
        this.flight = flight;
        this.blockingTime = blockingTime;
        this.quantitySeats = quantitySeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Timestamp getBlockingTime() {
        return blockingTime;
    }

    public void setBlockingTime(Timestamp blockingTime) {
        this.blockingTime = blockingTime;
    }

    public int getQuantitySeats() {
        return quantitySeats;
    }

    public void setQuantitySeats(int quantitySeats) {
        this.quantitySeats = quantitySeats;
    }
    
}
