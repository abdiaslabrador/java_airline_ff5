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
    private LocalDateTime date;
    private String code;
    private boolean state;
    private int max_seats;
    private int seats_ocupped;
    private String company_name;
    private LocalDateTime blocking_time;

    // @OneToOne
    // @JoinColumn(name = "airport_origin_id")
    // private Airport airport_origin;

    // @OneToOne
    // @JoinColumn(name = "airport_dest_id")
    // private Airport airport_dest;


    public Flight() {

    }

    

}
