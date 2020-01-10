import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Plane testPlane;
    private Passenger passenger1;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight("FR756", "EDI", "GLA", "1030", plane);
        passenger1 = new Passenger("Jon Snow", 1);
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

    @Test public void canCheckNumberOfSeatsAvailable(){
        assertEquals(plane.getCapacityOfPlane(), flight.getNumberOfSeatsAvailable());
    }

    @Test
    public void checkTheFlightHasSeatsAvailable(){
        assertTrue(flight.flightHasSeatsAvailable());
    }

    @Test
    public void checkTheFlightIsFull(){
        testPlane = new Plane(PlaneType.TESTPLANE);
        flight = new Flight("FR756", "EDI", "GLA", "1030", testPlane);
        flight.addPassenger(passenger1);
        assertFalse(flight.flightHasSeatsAvailable());
    }

    @Test
    public void canAddPassengerToFlight(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.passengerCount());
    }
}
