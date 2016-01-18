package part1ab;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Tester {
    @Test
    public void test(){
        Application app = new Application();
        app.setTimeLimit(0.5);
        System.out.println(app.getTotalCombos());
        app.fillTruck(new Truck());
        Truck mostFilledTruck = app.getMostFilledTruck();
        System.out.println(mostFilledTruck.truckUsage());
        System.out.println(mostFilledTruck.truckValue());
    }
    @Test
    public void test2(){
        Application app = new Application();
        app.setTimeLimit(2000);
        app.greedyFillTruck(new Truck());
        Truck mostValuableTruck = app.getMostValuableTruck();
        System.out.println(mostValuableTruck.truckValue());
        System.out.println(mostValuableTruck.truckUsage());
    }
    @Test
    public void test3(){
        Items items = new Items();
        ArrayList<Item> items1 = items.getGreedyItems();
        for (Item item : items1){
            System.out.println(item.getValue()/item.getVolume());
        }
        System.out.println();
        System.out.println();
    }


}
