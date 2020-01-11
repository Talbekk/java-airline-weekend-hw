import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class FlightTest {

    private Flight flight;
    private Plane plane;
    private Plane testPlane;
    private Passenger passenger1;
    private Passenger passenger2;
    private ArrayList<Passenger> passengers;
    private Date date;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        date = new Date();
        flight = new Flight("FR756", "EDI", "GLA", date, plane);
        passenger1 = new Passenger("Jon Snow", 1);
        passenger2 = new Passenger("Ned Stark", 1);
        passengers = new ArrayList<Passenger>();
        passengers.add(passenger1);
        passengers.add(passenger2);
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
        assertEquals(date, flight.getDepartureTime());
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
        flight = new Flight("FR756", "EDI", "GLA", date, testPlane);
        flight.addPassenger(passenger1);
        assertFalse(flight.flightHasSeatsAvailable());
    }

    @Test
    public void canAddPassengerToFlight(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void willAddPassengerIfThereIsSpaceOnFlight(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void willNotAddPassengerIfFlightIsFull(){
        testPlane = new Plane(PlaneType.TESTPLANE);
        flight = new Flight("FR756", "EDI", "GLA", date, testPlane);
        flight.addGroupOfPassengers(passengers);
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void canGetPassengerDetailsFromFlight(){
        flight.addPassenger(passenger1);
        assertEquals(passenger1, flight.getPassenger(passenger1));
    }

    @Test
    public void canGetAListOfPassengers(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getPassengers().size());
    }

    @Test
    public void canAddAGroupOfPassengers(){
        flight.addGroupOfPassengers(passengers);
        assertEquals(2, flight.passengerCount());
    }

}
