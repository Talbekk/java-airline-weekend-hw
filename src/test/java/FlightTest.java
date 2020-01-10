import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight;
    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight("FR756", "EDI", "GLA", "1030", plane);
    }

    @Test
    public void checkTheFlightStartsWithNoPassengers(){
        assertEquals(0, flight.passengerCount());
    }

    @Test
    public void checkTheFlightHasAFlightNumber(){
        assertEquals("FR756", flight.getFlightNumber());
    }

    @Test
    public void checkTheFlightHasADestination(){
        assertEquals("EDI", flight.getDestination());
    }

    @Test
    public void checksTheFlightDepartureAirport(){
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void checkTheFlightHasADepartureTime(){
        assertEquals("1030", flight.getDepartureTime());
    }

    @Test
    public void checkTheFlightHasAPlane(){
        assertEquals(PlaneType.BOEING747, flight.getFlightPlane());
    }
}
