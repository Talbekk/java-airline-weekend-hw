import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;
    private Passenger passenger1;
    private Passenger passenger2;
    private ArrayList<Passenger> passengers;

    @Before
    public void before(){
        passenger = new Passenger("Barry Scott", 2);

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


}
