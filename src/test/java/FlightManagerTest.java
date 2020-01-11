import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private ArrayList<Passenger> passengers;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight("FR756", "EDI", "GLA", "1030", plane);
        flightManager = new FlightManager(flight);
        passenger1 = new Passenger("Tyrion Lannister", 2);
        passenger2 = new Passenger("Cersei Lannister",1);
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
}
