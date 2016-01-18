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
    fills the space of truck as much as possible
    but optimizing it's route with placing algorithm and pruning
     @param truck input which is then received to fill
     */
    public boolean fillTruck(Truck truck){
        totalCombinations++;
        startTime = System.currentTimeMillis();
        // you can choose to get items sorted as
        // 1 - getRandomItems() -- random selection
        // 2 - getItems() -- sorted by descending/ascending volume
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
     * @param truck gets the reference of truck
     * @param item item which needs to be tried to put in
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
            ArrayList<Item> items = new Items().getItems();
            for (Item nextItem : items){
                Truck truck2 = new Truck();
                truck2.setCargoSpace(truck.getCargoSpace());
                truck2.placeItem(item);
                if (truck2.truckUsage() > mostFilledTruck.truckUsage() ){
                    mostFilledTruck.setCargoSpace(truck2.getCargoSpace());
                }
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
     @param truck input truck
     @return recursive call
     */
    public boolean greedyFillTruck(Truck truck){
        totalCombinations++;
        startTime = System.currentTimeMillis();
        ArrayList<Item> greedyItems = new Items().getRandomItems();
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
     @param truck an reference for current truck state
     @param item current item which needs to be tried
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
            ArrayList<Item> greedyItems = new Items().getRandomItems();
            for (Item nextItem : greedyItems){
                Truck truck2 = new Truck();
                truck2.setCargoSpace(truck.getCargoSpace());
                truck2.placeItem(item);
                if (truck.truckValue() > mostValuableTruck.truckValue() ){
                    mostValuableTruck.setCargoSpace(truck.getCargoSpace());
                }
                if(greedyFillTruck(truck2,nextItem)){
                    return true;
                }
            }
            return false;
        }
    }
}
