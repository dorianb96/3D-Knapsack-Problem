package part2ab;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import part1ab.Truck;

public class Tester {
    @Test  // the usual method for finding the usage
    public void test(){
        Application2 app = new Application2();
        app.setTimeLimit(5);
        app.boardFill(new Board());

        Truck mostFilledTruck = app.createMostFilledTruck();
        System.out.println(mostFilledTruck.truckUsage());
    }
    @Test //greedy method for finding the maximal value
    public void test2(){
        Application2 app1 = new Application2();
        app1.boardGreedyFill(new Board());
        app1.setTimeLimit(10);
        Board mostValuableBoard = app1.getMostValuableBoard();
        mostValuableBoard.printBoard();
        mostValuableBoard.boardValue();
        app1.boardFill(mostValuableBoard);

        Board mostValuableBoard2 = app1.getMostFilledBoard();
        Truck mostValuableTruck = app1.createMostFilledTruck();
        mostValuableTruck.printCargoSpace();
        System.out.println(mostValuableTruck.truckUsage());
        System.out.println(mostValuableTruck.truckValue("pento"));
    }

}
