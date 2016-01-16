package part1ab;
import org.junit.Assert;
import org.junit.Test;

public class Tester {
    @Test
    public void test(){
        Application app = new Application();
        app.setTimeLimit(5);
        app.fillTruck(new Truck());
        Truck mostFilledTruck = app.getMostFilledTruck();
        System.out.println(mostFilledTruck.truckUsage());
    }

}
