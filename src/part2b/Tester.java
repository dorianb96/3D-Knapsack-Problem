package part2b;

import org.junit.Test;
import part1ab.Truck;

public class Tester {
    @Test
    public void test(){
        Application3 app = new Application3();
        app.setTimeLimit(20000);
        app.fillTruck(new Pento3DTruck());
        Truck mostValuableTruck = app.getMostValuableTruck();
        System.out.println();
        System.out.println(app.getMostValuableTruckValue());
        System.out.println(mostValuableTruck.truckValue("pento"));
        System.out.println(mostValuableTruck.truckUsage());

    }
}
