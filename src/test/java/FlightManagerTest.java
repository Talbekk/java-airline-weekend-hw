import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight("FR756", "EDI", "GLA", "1030", plane);
        flightManager = new FlightManager(flight);
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
}
