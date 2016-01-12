import java.util.*;

public class Application {

    Truck mostFilledTruck = new Truck(); // the diamond operator
    Truck mostValuableTruck = new Truck(); // the diamond operator
    long startTime;
    long endTime;
    int timeLimit;
    private int solutionCounter;
    Random r = new Random();



    public Truck getMostFilledTruck(){
        return this.mostFilledTruck;
    }
    public Truck getMostValuableTruck(){
        return this.mostValuableTruck;
    }
    /*
    this method just tries to fill the space of truck as much as possible
    but optimizing it's route with placing algorithm and pruning
     */
    public boolean fillTruck(Truck truck, int timeLimit){
        solutionCounter++;
        this.timeLimit = timeLimit*100;
        startTime = System.currentTimeMillis();
        ArrayList<Item> items = new Items().getItems();
        for (Item nextItem : items){
            Truck newTruck = new Truck();
            newTruck.setCargoSpace(truck.getCargoSpace());
            fillTruck(truck,nextItem);
        }
        return false;
    }
    public boolean fillTruck(Truck truck, Item item){
        solutionCounter++;
        if(truck.isFull()) {
            mostFilledTruck.setCargoSpace(truck.getCargoSpace());
            return true;
        }
        else if (System.currentTimeMillis() - startTime > timeLimit){
            return true;
        }
        else if (!truck.doesItemFit(item)) {
            return false;
        }
        else if (truck.pruningCondition()){
            return false;
        }
        else{
            if (truck.truckUsage() > mostFilledTruck.truckUsage() ){
                mostFilledTruck.setCargoSpace(truck.getCargoSpace());
            }
            ArrayList<Item> items = new Items().getItems();
            for (Item nextItem : items){
                Truck truck2 = new Truck();
                truck2.setCargoSpace(truck.getCargoSpace());
                /*
                randomly print just so we can see how the algorithm is proceeding
                if(r.nextInt(20000) < 2){
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    truck.printCargoSpace();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    mostFilledTruck.printCargoSpace();

                }
                */
                truck2.placeItem(item);
                if(fillTruck(truck2,nextItem)){
                    return true;
                }
            }
            return false;
        }
    }
    public int getSolutionCounter(){
        return this.solutionCounter;
    }


    /*
    this is the method for maximizing the value of weight loaded onto the container,

    it also places the items but sorted by their - value per unit of space ie. the most valuable items
    compared to space the take will be placed first.
     */
    public boolean greedyFillTruck(Truck truck, int timeLimit){
        this.timeLimit = timeLimit*1000;
        ArrayList<Item> greedyItems = new Items().getGreedyItems();
        for (Item nextItem : greedyItems){
            Truck newTruck = new Truck();
            newTruck.setCargoSpace(truck.getCargoSpace());
            greedyFillTruck(truck,nextItem);
        }
        return false;
    }
    public boolean greedyFillTruck(Truck truck, Item item){
        if (!truck.doesItemFit(item)) {
            return false;
        }
        else if (truck.pruningCondition()){
            return false;
        }
        else if (System.currentTimeMillis() - startTime > timeLimit){
            return true;
        }
        else{
            if (truck.truckValue() > mostValuableTruck.truckValue() ){
                mostValuableTruck.setCargoSpace(truck.getCargoSpace());
                //System.out.println(mostValuableTruck.truckValue());
            }
            ArrayList<Item> greedyItems = new Items().getGreedyItems();
            for (Item nextItem : greedyItems){
                Truck truck2 = new Truck();
                truck2.setCargoSpace(truck.getCargoSpace());
                /*
                if(r.nextInt(10000) < 10){
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    truck.printCargoSpace();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    mostValuableTruck.printCargoSpace();
                }
                */
                truck2.placeItem(item);
                if(greedyFillTruck(truck2,nextItem)){
                    return true;
                }
            }
            return false;
        }
    }
}
