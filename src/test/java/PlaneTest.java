import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void checkPlaneHasAType(){
        assertEquals(PlaneType.BOEING747, plane.getTypeOfPlane());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(200, plane.getCapacityOfPlane());
    }

    @Test
    public void canGetPlaneWeight(){
        assertEquals(6000, plane.getWeightOfPlane());
    }
}
