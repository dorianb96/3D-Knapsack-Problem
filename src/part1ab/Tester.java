package part1ab;
import org.junit.Assert;
import org.junit.Test;

public class Tester {
    @Test
    public void test(){
        Application app = new Application();
        app.setTimeLimit(10000);
        app.fillTruck(new Truck());
        Truck mostFilledTruck = app.getMostFilledTruck();
        System.out.println(mostFilledTruck.truckUsage());
    }
    @Test
    public void test2(){
        Application app = new Application();
        app.setTimeLimit(20000);
        app.greedyFillTruck(new Truck());
        Truck mostValuableTruck = app.getMostValuableTruck();
        System.out.println(mostValuableTruck.truckValue());
        System.out.println(mostValuableTruck.truckUsage());
    }

}
