package dev.project.airline.flight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import dev.project.airline.airport.Airport;
import dev.project.airline.airport.AirportMapper;
import dev.project.airline.airport.AirportRepository;
import dev.project.airline.airport.AirportRequest;
import dev.project.airline.airport.AirportResponse;
import dev.project.airline.flight.exceptions.FlightNotFoundException;

@Service
public class FlightService {
    private FlightRepository flightRepository;
    private AirportRepository airportRepository;


    public FlightService(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public List<FlightResponse>findAll(){
        List<FlightResponse> flights  = new ArrayList<>();
        for (Flight flight : flightRepository.findAll()) {
            flights.add(FlightMapper.toResponse(flight));
        }
        return flights;
    }

    public FlightResponse saveFlight(FlightRequest airportRequest) {
        // validFlight here
        Airport destAirport = airportRepository.findById(airportRequest.airportDestId()).orElseThrow(() -> new FlightNotFoundException("Airport not found with id: " + airportRequest.airportDestId()));
        Airport originAirport = airportRepository.findById(airportRequest.airportOriginId()).orElseThrow(() -> new FlightNotFoundException("Airport not found with id: " + airportRequest.airportOriginId()));
        Flight flight = flightRepository.save(FlightMapper.toEntity(airportRequest, originAirport, destAirport));
        return  FlightMapper.toResponse(flight);
    }

    public FlightResponse updateFlight(Long id, FlightRequest airportRequest) {
        // validFlight here
        Airport destAirport = airportRepository.findById(airportRequest.airportDestId()).orElseThrow(() -> new FlightNotFoundException("Airport not found with id: " + airportRequest.airportDestId()));
        Airport originAirport = airportRepository.findById(airportRequest.airportOriginId()).orElseThrow(() -> new FlightNotFoundException("Airport not found with id: " + airportRequest.airportOriginId()));

        Flight flight = flightRepository.findById(id).orElseThrow(() -> new FlightNotFoundException("Flight not found with id: " + id));
        flight.setArrivalDateTime(airportRequest.arrivalDateTime());
        flight.setBlockingTime(airportRequest.blockingTime());
        flight.setCode(airportRequest.code());
        flight.setCompanyName(airportRequest.companyName());
        flight.setDepartureDateTime(null);
        flight.setMaxSeats(airportRequest.maxSeats());
        flight.setSeatsOccupied(airportRequest.seatsOccupied());
        flight.setState(airportRequest.state());
        flight.setAirportDest(destAirport);
        flight.setAirportOrigin(originAirport);
        
        flightRepository.save(flight);
        return  FlightMapper.toResponse(flight);
    }

    public ResponseEntity<FlightResponse>deleteById(Long id) {
       flightRepository.deleteById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    // private boolean isInvalidAirport(AirportRequest airportRequest) {
    //     return airportRequest.name()  == null || 
    //            airportRequest.city() == null || 
    //            airportRequest.code() == null;
    // }
}
