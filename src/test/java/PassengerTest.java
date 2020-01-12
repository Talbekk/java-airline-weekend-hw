import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;
    private Flight flight;
    private Plane plane;
    private Date date;
    private Flight testFlight;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
        date = new Date();
        testFlight = new Flight();
        flight = new Flight("FR756", "EDI", "GLA", date, plane);
        passenger = new Passenger("Barry Scott", 2, testFlight);

    }

    @Test
    public void passengerHasName(){
        assertEquals("Barry Scott", passenger.getName());
    }

    @Test
    public void passengerHasBags(){
        assertEquals(2, passenger.getBagCount());
    }

    @Test
    public void checkThePassengersTotalBagWeight(){
        assertEquals(20, passenger.getTotalBagWeight());
    }

    @Test
    public void passengerHasAFlight(){
        assertEquals(testFlight, passenger.getFlight());
    }

    @Test
    public void addPassengerToFLight(){
        passenger.addFlight(flight);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void passengerHasASeatNumber(){
        assertEquals(0, passenger.getSeatNumber());
    }

    @Test
    public void assignPassengerASeatNumber(){
        passenger.addSeatNumber(10);
        assertEquals(10, passenger.getSeatNumber());
    }


}
