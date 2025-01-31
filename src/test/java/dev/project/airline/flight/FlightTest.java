package dev.project.airline.flight;
import org.junit.jupiter.api.BeforeEach;
import dev.project.airline.airport.Airport;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class FlightTest {

    private Flight flight;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Airport airportOrigin;
    private Airport airportDest;

    @BeforeEach
    public void setUp() {
        departureDateTime = LocalDateTime.of(2023, 10, 1, 10, 0);
        arrivalDateTime = LocalDateTime.of(2023, 10, 1, 14, 0);
        airportOrigin = new Airport();
        airportDest = new Airport();
        flight = new Flight(departureDateTime, arrivalDateTime, "FL123", true, 150, 50, "AirlineCompany", airportOrigin, airportDest);
    }

    @Test
    public void testFlightConstructor() {
        assertNotNull(flight);
        assertEquals("FL123", flight.getCode());
        assertEquals(true, flight.isState());
        assertEquals(150, flight.getMaxSeats());
        assertEquals(50, flight.getSeatsOccupied());
        assertEquals(airportOrigin, flight.getAirportOrigin());
        assertEquals(airportDest, flight.getAirportDest());
    }

    @Test
    public void testSetAndGetId() {
        flight.setId(1L);
        assertEquals(1L, flight.getId());
    }

    @Test
    public void testSetAndGetCode() {
        flight.setCode("FL456");
        assertEquals("FL456", flight.getCode());
    }

    @Test
    public void testSetAndGetState() {
        flight.setState(false);
        assertEquals(false, flight.isState());
    }

    @Test
    public void testSetAndGetMaxSeats() {
        flight.setMaxSeats(200);
        assertEquals(200, flight.getMaxSeats());
    }

    @Test
    public void testSetAndGetSeatsOccupied() {
        flight.setSeatsOccupied(100);
        assertEquals(100, flight.getSeatsOccupied());
    }

    @Test
    public void testSetAndGetCompanyName() {
        flight.setCompanyName("NewAirline");
        assertEquals("NewAirline", flight.getCompanyName());
    }

    @Test
    public void testSetAndGetAirportOrigin() {
        Airport newAirportOrigin = new Airport();
        flight.setAirportOrigin(newAirportOrigin);
        assertEquals(newAirportOrigin, flight.getAirportOrigin());
    }

    @Test
    public void testSetAndGetAirportDest() {
        Airport newAirportDest = new Airport();
        flight.setAirportDest(newAirportDest);
        assertEquals(newAirportDest, flight.getAirportDest());
    }

    @Test
    public void testSetAndGetDepartureDateTime() {
        LocalDateTime newDepartureDateTime = LocalDateTime.of(2023, 10, 2, 10, 0);
        flight.setDepartureDateTime(newDepartureDateTime);
        assertEquals(newDepartureDateTime, flight.getDepartureDateTime());
    }

    @Test
    public void testSetAndGetArrivalDateTime() {
        LocalDateTime newArrivalDateTime = LocalDateTime.of(2023, 10, 2, 14, 0);
        flight.setArrivalDateTime(newArrivalDateTime);
        assertEquals(newArrivalDateTime, flight.getArrivalDateTime());
    }

}
