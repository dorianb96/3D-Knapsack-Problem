import java.util.Scanner;

public class AppTester {

    public static void main (String[] args) {
        System.out.println("please enter which version you want to start");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch(choice){
            /*
            fills the truck to as much capacity as possible
            in the fillTruck method we first add the truck we want
            and then we add how much time we allow the program to run
            */
            case 1: {
                Application app = new Application();
                app.fillTruck(new Truck(), 2);
                Truck mostFilledTruck = app.getMostFilledTruck();
                System.out.println(mostFilledTruck.truckValue());
                System.out.println(mostFilledTruck.truckUsage());
                //mostFilledTruck.printCargoSpace();
            }

            /*
            fills the truck with as much valuable items as possible
            */
            case 2:{
                Application app = new Application();
                app.greedyFillTruck(new Truck(),2);
                Truck mostValuableTruck = app.getMostValuableTruck();
                System.out.println(mostValuableTruck.truckValue());
                System.out.println(mostValuableTruck.truckUsage());
                System.out.println();
                //mostValuableTruck.printCargoSpace();
            }
            /*
            fills the board with most valuable pentominos
            and then just does a checks with the fill empty spaces
            to complete the synthesis of algorithms
            */
            case 3:{
                System.out.println();
                Application2 app1 = new Application2();
                app1.boardGreedyFill(new Board());
                Board mostValuableBoard = app1.getMostValuableBoard();
                app1.boardFill(mostValuableBoard);



                Board mostValuableBoard2 = app1.getMostFilledBoard();
                System.out.println("\n"+"\n"+" the highest board value is" +
                        mostValuableBoard2.boardValue());
                mostValuableBoard2.printBoard();

            }
            /*
            tries to completely fill the board with pents
            */
            case 4: {
                System.out.println();
                Application2 app2 = new Application2();
                app2.boardFill(new Board());
                Board mostFilledBoard = app2.getMostFilledBoard();
                System.out.println(mostFilledBoard.boardUsage());
                mostFilledBoard.printBoard();
            }
            /*
            tries to place the 3D pentomino shapes to maximize the value of
            cargo inside the truck
             */
            case 5: {
                Application3 app3 = new Application3();
                app3.fillTruck(new Pento3DTruck(),200000);
                Pento3DTruck mostFilledTruck = app3.getMostFilledTruck();
                Pento3DTruck mostValuableTruck = app3.getMostValuableTruck();
                System.out.println();
                System.out.println();
                System.out.println(mostFilledTruck.truckUsage());
                System.out.println();
                System.out.println();
                mostFilledTruck.printCargoSpace();
                System.out.println();
                System.out.println();
                System.out.println(mostValuableTruck.truckValue());
                System.out.println();
                System.out.println();
                mostValuableTruck.printCargoSpace();
                System.out.println();
                System.out.println();
            }
        }
    }
}