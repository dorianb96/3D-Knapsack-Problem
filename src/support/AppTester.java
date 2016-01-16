package support;

import part1ab.Application;
import part1ab.Truck;

public class AppTester {

    public static void main (String[] args) {

        /*
        fills the truck to as much capacity as possible
        in the fillTruck method we first add the truck we want
        and then we add how much time we allow the program to run
        */
        Application app = new Application();
        app.setTimeLimit(5);
        app.fillTruck(new Truck());
        app.finalFill();
        Truck mostFilledTruck = app.getMostFilledTruck();
        System.out.println(mostFilledTruck.truckUsage());
        System.out.println(mostFilledTruck.truckValue());
        //mostFilledTruck.printCargoSpace();


        /*
        fills the truck with as much valuable items as possible
        */
        /*
        Application app2 = new Application();
        app2.setCombinationLimit(1000);
        app2.greedyFillTruck(new Truck());
        Truck mostValuableTruck = app2.getMostValuableTruck();
        System.out.println(mostValuableTruck.truckValue());
        System.out.println(mostValuableTruck.truckUsage());

        //mostValuableTruck.printCargoSpace();
        */


        /*
        fills the board with most valuable pentominos
        and then just does a checks with the fill empty spaces
        to complete the synthesis of algorithms

        */
        /*
        System.out.println();
        part2ab.Application2 app1 = new part2ab.Application2();
        app1.boardGreedyFill(new part2ab.Board());
        app1.setTimeLimit(10);
        part2ab.Board mostValuableBoard = app1.getMostValuableBoard();
        app1.boardFill(mostValuableBoard);
        part2ab.Board mostValuableBoard2 = app1.getMostFilledBoard();
        System.out.println("\n"+"\n"+" the highest board value is" +
                mostValuableBoard2.boardValue());
        mostValuableBoard2.printBoard();
        */
        /*
        tries to completely fill the board with pents
        */
        /*
        System.out.println();
        part2ab.Application2 app2 = new part2ab.Application2();
        app2.boardFill(new part2ab.Board());
        part2ab.Board mostFilledBoard = app2.getMostFilledBoard();
        System.out.println(mostFilledBoard.boardUsage());
        mostFilledBoard.printBoard();
        */
        /*
        part2b.Application3 app3 = new part2b.Application3();
        app3.setTimeLimit(2);
        app3.fillTruck(new part2b.Pento3DTruck());
       // part2b.Pento3DTruck mostFilledTruck = app3.getMostFilledTruck();
        Truck mostValuableTruck = app3.getMostValuableTruck();
        System.out.println();
        System.out.println();
        //System.out.println(mostFilledTruck.truckUsage());
        System.out.println();
        System.out.println();
        //mostFilledTruck.printCargoSpace();
        System.out.println();
        System.out.println();
        System.out.println(mostValuableTruck.truckValue());
        System.out.println();
        System.out.println();
        mostValuableTruck.printCargoSpace();
        System.out.println();
        System.out.println();
        */

    }
}