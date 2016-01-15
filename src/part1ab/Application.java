package part1ab;

import java.util.*;
import support.TimeLimit;

public class Application extends TimeLimit {
    /**
     * solves the problem of 1a and 1b
     * the boardFill method tries to fill up the whole truck
     * the greedyBoardFill method maximizes the value of cargo inside truck
     */

    private Truck mostFilledTruck = new Truck(); // the diamond operator
    private Truck mostValuableTruck = new Truck(); // the diamond operator

    /**
     *
     * @return reference to the most filled truck found during execution
     */
    public Truck getMostFilledTruck(){
        return this.mostFilledTruck;
    }

    /**
     *
     * @return reference to the most valuable truck found during execution
     */
    public Truck getMostValuableTruck(){
        return this.mostValuableTruck;
    }

    /**
     * this method first collects free coordinates and then tries to place
     * all remaining items into them
     */
    public void finalFill(){
        double[][][] cargoSpace = this.mostFilledTruck.getCargoSpace();
        ArrayList<int[]> freeCoordinates = new ArrayList<>();
        System.out.println(freeCoordinates.size());

        for (int i = 0; i < cargoSpace.length; i++){
            for (int j = 0; j < cargoSpace[0].length; j++){
                for (int k = 0; k < cargoSpace[0][0].length; k++){
                    if (cargoSpace[i][j][k] == 0){
                        int[] array = new int[3];
                        freeCoordinates.add(array);
                    }
                }
            }
        }
        int i =0;
        for (int[] freeCoordinate : freeCoordinates){
            ArrayList<Item> items = new Items().getItems();
            for (Item item : items){
                i++;
                System.out.println(i);

                Truck localMostFilledTruck = new Truck();
                localMostFilledTruck.setCargoSpace(cargoSpace);
                if (localMostFilledTruck.doesItemFit(item,freeCoordinate)){
                    System.out.println("WOWOWOWOWOWOWOW");
                    localMostFilledTruck.placeItem(item,freeCoordinate);
                    if (localMostFilledTruck.truckUsage() > this.mostFilledTruck.truckUsage()){
                        mostFilledTruck.setCargoSpace(localMostFilledTruck.getCargoSpace());
                    }
                }
            }
        }
    }
    /**
    fills the space of truck as much as possible
    but optimizing it's route with placing algorithm and pruning
     @param truck
     */
    public boolean fillTruck(Truck truck){
        totalCombinations++;
        startTime = System.currentTimeMillis();
        ArrayList<Item> items = new Items().getItems();
        for (Item nextItem : items){
            totalCombinations++;
            Truck newTruck = new Truck();
            newTruck.setCargoSpace(truck.getCargoSpace());
            fillTruck(truck,nextItem);
        }
        return false;
    }

    /**
     * continues the recursion
     * @param truck
     * @param item
     * @return recursive call with next item
     */
    public boolean fillTruck(Truck truck, Item item){
        totalCombinations++;
        if(truck.isFull()) {
            mostFilledTruck.setCargoSpace(truck.getCargoSpace());
            return true;
        }
        else if (checkLimits()){
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
                truck2.placeItem(item);
                if(fillTruck(truck2,nextItem)){
                    return true;
                }
            }
            return false;
        }
    }


    /**
    this is the method for maximizing the value of weight loaded onto the container,

    it also places the items but sorted by their - value per unit of space ie. the most valuable items
    compared to space the take will be placed first.
     @param truck
     @return recursive call
     */
    public boolean greedyFillTruck(Truck truck){
        totalCombinations++;
        startTime = System.currentTimeMillis();
        ArrayList<Item> greedyItems = new Items().getGreedyItems();
        for (Item nextItem : greedyItems){
            Truck newTruck = new Truck();
            newTruck.setCargoSpace(truck.getCargoSpace());
            greedyFillTruck(truck,nextItem);
        }
        return false;
    }
    /**
     this is the method for maximizing the value of weight loaded onto the container,

     it also places the items but sorted by their - value per unit of space ie. the most valuable items
     compared to space the take will be placed first.
     @param truck
     @param item
     @return recursive call
     */
    public boolean greedyFillTruck(Truck truck, Item item){
        totalCombinations++;
        if (!truck.doesItemFit(item)) {
            return false;
        }
        else if (truck.pruningCondition()){
            return false;
        }
        else if (checkLimits()){
            return true;
        }
        else{
            if (truck.truckValue() > mostValuableTruck.truckValue() ){
                mostValuableTruck.setCargoSpace(truck.getCargoSpace());
            }
            ArrayList<Item> greedyItems = new Items().getGreedyItems();
            for (Item nextItem : greedyItems){
                Truck truck2 = new Truck();
                truck2.setCargoSpace(truck.getCargoSpace());
                truck2.placeItem(item);
                if(greedyFillTruck(truck2,nextItem)){
                    return true;
                }
            }
            return false;
        }
    }
}
