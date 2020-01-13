import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private ArrayList<Passenger> passengers;
    private Date date;
    private Passenger passenger3;
    private Passenger passenger4;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight("FR756", "EDI", "GLA", date, plane);
        flightManager = new FlightManager(flight);
        passenger1 = new Passenger("Tyrion Lannister", 2, flight);
        passenger2 = new Passenger("Cersei Lannister",1, flight);
        passengers = new ArrayList<Passenger>();
        passengers.add(passenger1);
        passengers.add(passenger2);
    }

    @Test
    public void checkTheFlightManagerHasAFlight(){
        assertTrue(flightManager.getFlight() == flight);
    }

    @Test
    public void checkThatFlightManagerCanGetTotalBaggageAllowanceForAFlight(){
        assertEquals(3000, flightManager.getTotalBaggageAllowance());
    }

    @Test
    public void checkTheFlightManagerCanGetBaggageAllowanceForOnePassenger(){
        assertEquals(15, flightManager.getPassengerBaggageAllowance());
    }

    @Test
    public void checkTheFlightManagerCanGetTheBaggageWeightBookedByAPassenger(){
        flight.addPassenger(passenger1);
        assertEquals(20, flightManager.getPassengerTotalBaggageWeight());
    }

    @Test
    public void checkTheFlightManagerCanGetAListOfAllPassengerAmounts(){
        flight.addGroupOfPassengers(passengers);
        assertEquals(2, flightManager.getListOfPassengerBaggageWeights().size());
    }

    @Test
    public void checkTheFlightManagerCanGetATotalPassengerBaggageWeight(){
        flight.addGroupOfPassengers(passengers);
        assertEquals(30, flightManager.getTotalBaggageWeight());
    }

    @Test
    public void checkTheFlightManagerCanGetARemainingWeightTotalForAFlight(){
      flight.addGroupOfPassengers(passengers);
        assertEquals(2970, flightManager.getRemainingBaggageCapacity());
    }

    @Test
    public void canGetAListOfSeatNumbers(){
        flight.addGroupOfPassengers(passengers);
        assertEquals(2, flightManager.getSeatNumbers().length);
    }

    @Test
    public void canGetASortedListOfSeats(){
        passenger3 = new Passenger("Jamie Lannister", 2, flight);
        passenger4 = new Passenger("Tywin Lannister", 1, flight);
        passengers.add(passenger3);
        passengers.add(passenger4);
        flight.addGroupOfPassengers(passengers);
        assertEquals(4, flightManager.getSortedListOfSeats().length);
    }

    @Test
    public void checkTheFlightManagerCanGetAnOrderedListOfPassengersBySeat(){
        passenger3 = new Passenger("Jamie Lannister", 2, flight);
        passenger4 = new Passenger("Tywin Lannister", 1, flight);
        passengers.add(passenger3);
        passengers.add(passenger4);
        flight.addGroupOfPassengers(passengers);
        assertEquals(4, flight.passengerCount());
        assertEquals(passengers, flight.getPassengers());
        assertTrue(passengers != flightManager.getPassengersOrderedBySeatNumber());
    }
}
