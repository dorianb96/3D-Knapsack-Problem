import java.util.*;

public class Application3 {

    Pento3DTruck mostFilledTruck = new Pento3DTruck(); // the diamond operator
    Pento3DTruck mostValuableTruck = new Pento3DTruck(); // the diamond operator
    long startTime;
    long endTime;
    int timeLimit;

    Random r = new Random();

    public Pento3DTruck getMostFilledTruck(){
        return this.mostFilledTruck;
    }
    public Pento3DTruck getMostValuableTruck(){
        return this.mostValuableTruck;
    }
    /*
    this method just tries to fill the space of truck as much as possible
    but optimizing it's route with placing algorithm and pruning
     */
    public boolean fillTruck(Pento3DTruck truck, int timeLimit){
        this.timeLimit = timeLimit*1000;
        startTime = System.currentTimeMillis();
        ArrayList<double[][][]> items = new Pento3D().getGreedyPents3D();
        for (double[][][] nextItem : items){
            Pento3DTruck newTruck = new Pento3DTruck();
            newTruck.setCargoSpace(truck.getCargoSpace());
            fillTruck(truck,nextItem);
        }
        return false;
    }
    public boolean fillTruck(Pento3DTruck truck, double[][][] item){
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
        else{
            if (truck.truckValue() > mostValuableTruck.truckValue() ){
                mostValuableTruck.setCargoSpace(truck.getCargoSpace());
            }
            if (truck.truckUsage() > mostFilledTruck.truckUsage()){
                mostFilledTruck.setCargoSpace(truck.getCargoSpace());
            }
            ArrayList<double[][][]> items = new Pento3D().getGreedyPents3D();
            for (double[][][] nextItem : items) {
                Pento3DTruck truck2 = new Pento3DTruck();
                truck2.setCargoSpace(truck.getCargoSpace());
                /*
                randomly print just so we can see how the algorithm is proceeding
                */


                if(r.nextInt(2000000) < 2){
                    /*
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    truck.printCargoSpace();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    mostValuableTruck.printCargoSpace();
                    */
                    System.out.println(mostValuableTruck.truckValue());
                    System.out.println(mostValuableTruck.truckUsage());

                }

                truck2.placeItem(item);
                if(fillTruck(truck2,nextItem)){
                    return true;
                }
            }
            return false;
        }
    }
}
