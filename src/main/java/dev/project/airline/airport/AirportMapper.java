package dev.project.airline.airport;

public class AirportMapper {

    public static Airport toEntity(AirportRequest airportRequest) {
        return new Airport(
                airportRequest.name(),
                airportRequest.code(),
                airportRequest.city()
        );
    }

    public static AirportResponse toResponse(Airport airport) {
        return new AirportResponse(
                airport.getId(),
                airport.getCode(),
                airport.getName(),
                airport.getCity()
        );
    }
}
