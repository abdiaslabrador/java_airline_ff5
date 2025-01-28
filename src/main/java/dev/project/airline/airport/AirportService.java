package dev.project.airline.airport;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.project.airline.airport.AirportRepository;
import dev.project.airline.airport.exceptions.AirportDoNotMatch;
import dev.project.airline.airport.exceptions.AirportNotFoundException;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportResponse> findAll() {
        List<AirportResponse> airports = new ArrayList<>();
        for (Airport  airport : airportRepository.findAll()) {
            airports.add( AirportMapper.toResponse(airport));
        }
        return airports;
    }

    public AirportResponse save(AirportRequest airportRequest) {
        isInvalidAirport(airportRequest);
        Airport airport = airportRepository.save(AirportMapper.toEntity(airportRequest));
        return  AirportMapper.toResponse(airport);
    }

    public ResponseEntity<AirportResponse>deleteById(Long id) {
       airportRepository.deleteById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    public AirportResponse updateAirport(Long id, AirportRequest airportRequest) {
        Airport airportExist = airportRepository.findById(id)
                .orElseThrow(() -> new AirportNotFoundException("Airport not found with id: " + id));

        if(!airportExist.getCode().equals(airportRequest.code())) {
            throw new AirportDoNotMatch("Airport to update doesn't match with the code");
        }

        airportExist.setName(airportRequest.name());
        airportExist.setCity(airportRequest.city());
        Airport updatedAirport = airportRepository.save(airportExist);
        return AirportMapper.toResponse(updatedAirport);
    }

    private boolean isInvalidAirport(AirportRequest airportRequest) {
        return airportRequest.name()  == null || 
               airportRequest.city() == null || 
               airportRequest.code() == null;
    }
}
