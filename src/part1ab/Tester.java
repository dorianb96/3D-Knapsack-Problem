package part1ab;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Dorian on 16-Jan-16.
 */
public class Tester {
    @Test
    public void test(){
        Application app = new Application();
        app.setTimeLimit(4);
        app.fillTruck(new Truck());
        Truck mostFilledTruck = app.getMostFilledTruck();
        System.out.println(mostFilledTruck.truckUsage());
        Assert.assertEquals(0.96818,mostFilledTruck.truckUsage(),1E-6);
    }

}
