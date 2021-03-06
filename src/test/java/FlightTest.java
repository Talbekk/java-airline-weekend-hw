import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
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
    private Date testDate;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        date = new Date();
        testDate = new Date(2020, 04, 17, 10, 30);
        flight = new Flight("FR756", "EDI", "GLA", testDate, plane);
        passenger1 = new Passenger("Jon Snow", 1, flight);
        passenger2 = new Passenger("Ned Stark", 1, flight);
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
        assertEquals(testDate, flight.getDepartureTime());
    }

    @Test
    public void canGetTheFlightTime(){
        assertEquals("Mon May 17 10:30:00 BST 3920", testDate.toString());
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
        flight = new Flight("FR756", "EDI", "GLA", testDate, testPlane);
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
        flight = new Flight("FR756", "EDI", "GLA", testDate, testPlane);
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


    @Test
    public void getAListOfSeatsForAPlane(){
        assertEquals(plane.getCapacityOfPlane(), flight.getAllSeats().size());
    }

    @Test
    public void canGetARandomSeatFromThePlane(){
        assertTrue(flight.checkIfFunctionReturnsAValidSeat());
    }

    @Test public void canBookASeatForAPassenger(){
        int startingCapacity = flight.getAllSeats().size();
        flight.addPassenger(passenger1);
        assertTrue( startingCapacity != flight.getRemainingSeats().size());
    }

    @Test public void canBookMultiplePassengers(){
        flight.addGroupOfPassengers(passengers);
        assertEquals(2, flight.passengerCount());
    }

    @Test
    public void cantBookPassengersOnTheSameSeat(){
        flight.testToAddPassengerOnSameSeat(passenger1, 1);
        flight.testToAddPassengerOnSameSeat(passenger1, 1);
        assertEquals(1, flight.passengerCount());
    }

}
