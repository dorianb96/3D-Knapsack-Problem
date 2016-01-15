package part1ab;

import part1ab.Item;

public class Truck  {
    public Truck(){
        this.widthX = 5;
        this.heightY = 8;
        this.lengthZ = 33;
        this.cargoSpace
                = new double[widthX][heightY][lengthZ];
    }

    /** goes through the whole cargo space and return false
    if there isn't a empty space it returns true,
    if there is it returns false
     @return boolean true or false*/
    public boolean isFull(){
        for (int i = 0; i < widthX; i++)
            for (int j = 0;j<heightY; j++)
                for (int z = 0; z < lengthZ; z++)
                    if (this.cargoSpace[i][j][z] == 0.0d)
                        return false;
        return true;
    }

    /**
    we used a special algorithm that combined with pruning conditions makes sure that
    after we place an item we don't get an item with lesser x,y,z coordinates

    this basically means the algorithm fills in order (based on priority)
    1) width - x dimension
    2) height  - y dimension
    3) length - z dimension

    this makes sure that we don't have any gaps and also optimizes the program at later
    stages when there is only a small unfilled space

    and also the solver first check whether the board is full, if not only then we
    search for the next free cell
     @return array with x,y,z coordinates of next free cell
     */
    public int[] findNextFreeCell() {
        for (int i =0; i < lengthZ; i++){
            for (int j = 0; j < heightY; j++){
                for (int k = 0; k < widthX; k++){
                    if (cargoSpace[k][j][i] == 0) {
                        this.nextFreeCell[0] = k;
                        this.nextFreeCell[1] = j;
                        this.nextFreeCell[2] = i;
                      //  System.out.print("Found next free cell  ");
                      //  System.out.println(nextFreeCell[0]+" " +nextFreeCell[1]+" "+nextFreeCell[2]);
                        return nextFreeCell;
                    }
                }
            }
        }
        return nextFreeCell;
    }


    /**
    this method is used for checking whether the item fits into the nextFreeCell,
    we used 2 conditions to decide if it can be placed:
    1) the space isn't already filled
    2) the item fits into cargo space dimensions
    @param item
     @return boolean
     */
    public boolean doesItemFit(Item item) {
        int[] nextFreeCell = this.findNextFreeCell();
        for (int i = nextFreeCell[0]; i < nextFreeCell[0] + item.getWidthX(); i++) {
            for (int j = nextFreeCell[1]; j < nextFreeCell[1] + item.getHeightY(); j++) {
                for (int k = nextFreeCell[2]; k < nextFreeCell[2] + item.getLengthZ(); k++) {
                    try {
                        /* make sure the program isn't overwriting anything */
                        if (this.cargoSpace[i][j][k] != 0.0d) {
                      //      System.out.println("space already filled");
                            return false;
                        }
                    }
                    /* make sure we are staying in bounds of the array */
                    catch (ArrayIndexOutOfBoundsException e) {
                     //   System.out.println("array out of bounds exception");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     this method is used for checking whether the item fits into the nextFreeCell,
     we used 2 conditions to decide if it can be placed:
     1) the space isn't already filled
     2) the item fits into cargo space dimensions
     @param item
     @return boolean
     */
    public boolean doesItemFit(Item item, int[] freeCell,double[][][] cargoSpace) {
        for (int i = freeCell[0] + item.getWidthX(); i > freeCell[0]; i--) {
            for (int j = freeCell[1] + item.getHeightY(); j > freeCell[1]; j--) {
                for (int k = freeCell[2] + item.getLengthZ(); k > freeCell[2]; k--) {
                    try {
                        /* make sure the program isn't overwriting anything */
                        if (cargoSpace[i][j][k] != 0.0d) {
                            throw new RuntimeException();
                        }
                    }
                    /* make sure we are staying in bounds of the array */
                    catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("array out of bounds exception");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
    places the item onto the nextFreeCell, this method is synced with checkIfFits method
    because the application always first checks whether item fits and only then places it
     @param item
     */
    public void placeItem(Item item) {
        int[] nextFreeCell = this.findNextFreeCell();
        for (int i = nextFreeCell[0]; i < nextFreeCell[0] + item.getWidthX(); i++) {
            for (int j = nextFreeCell[1]; j < nextFreeCell[1] + item.getHeightY(); j++) {
                for (int k = nextFreeCell[2]; k < nextFreeCell[2] + item.getLengthZ(); k++) {
                        this.cargoSpace[i][j][k] = item.getType();
                }
            }
        }
    }
    /**
     places the item onto the nextFreeCell, this method is synced with checkIfFits method
     because the application always first checks whether item fits and only then places it
     @param item
     */
    public void placeItem(Item item, int[] freeCell) {
        for (int i = freeCell[0]; i < freeCell[0] + item.getWidthX(); i++) {
            for (int j = freeCell[1]; j < freeCell[1] + item.getHeightY(); j++) {
                for (int k = freeCell[2]; k < freeCell[2] + item.getLengthZ(); k++) {
                    this.cargoSpace[i][j][k] = item.getType();
                }
            }
        }
    }

    /**
    in the part 1a and 1b we know the minimal dimension of each item is 2, that means
    if we filled 7 rows in y dimension(height) and there are 8 rows in the y dimension (height)
    we can't get a solid solution from that formation and thus we prune it

    this method basically checks for this condition in all dimensions (x,y,z - width, height, length)
     @return boolean
    */
    public boolean pruningCondition(){
        for (int i = 0; i < widthX; i++){
            for(int j = 0; j < heightY; j++){
                int counter = 0;
                for (int k = 0; k < lengthZ-1; k++){
                    if (this.cargoSpace[i][j][k] != 0){
                        counter++;
                    }
                }
                if (counter == lengthZ-1 && cargoSpace[i][j][lengthZ-1] == 0){
                    return true;
                }
            }
        }
        for (int i = 0; i < widthX; i++){
            for(int j = 0; j < lengthZ; j++){
                int counter = 0;
                for (int k = 0; k < heightY-1; k++){
                    if (this.cargoSpace[i][k][j] != 0){
                        counter++;
                    }
                }
                if (counter == heightY-1 && cargoSpace[i][heightY-1][j] == 0){
                    return true;
                }
            }
        }
        for (int i = 0; i < lengthZ; i++){
            for(int j = 0; j < heightY; j++){
                int counter = 0;
                for (int k = 0; k < widthX-1; k++){
                    if (this.cargoSpace[k][j][i] != 0){
                        counter++;
                    }
                }
                if (counter == widthX-1 && cargoSpace[widthX-1][j][i] == 0){
                    return true;
                }
            }
        }
        return false;
    }
    /**
    returns the percentage of truck used by items
     @return truck usage
     */
    public double truckUsage(){
        double counter = 0;
        for (int i = 0; i < widthX; i++){
            for (int j = 0; j < heightY; j++) {
                for (int k = 0; k < lengthZ; k++) {
                    if(this.cargoSpace[i][j][k] >= 1){
                        counter++;
                    }
                }
            }
        }
        // just want to round it down to 5 decimal places
        return Math.round(100000.d* (counter/(this.widthX*this.lengthZ*this.heightY)))/100000.d;
    }
    /**
    this returns the value of all items in the cargo space
     @return total truck value
     */
    public int truckValue(){
        float counter = 0;
        for (int i = 0; i < widthX; i++){
            for (int j = 0; j < heightY; j++) {
                for (int k = 0; k < lengthZ; k++) {
                    if (this.cargoSpace[i][j][k] < 3.99){
                        counter += this.cargoSpace[i][j][k]/16;
                    }
                    else if (this.cargoSpace[i][j][k] < 4.99){
                        counter += this.cargoSpace[i][j][k]/24;
                    }
                    else if (this.cargoSpace[i][j][k] < 5.99){
                        counter += this.cargoSpace[i][j][k]/27;
                    }
                }
            }
        }
        return (int)counter;
    }
    public int truckValue(String pento2D){
        float counter = 0;
        for (int i = 0; i < widthX; i++){
            for (int j = 0; j < heightY; j++) {
                for (int k = 0; k < lengthZ; k++) {
                    if (this.cargoSpace[i][j][k] < 3.99){
                        counter += this.cargoSpace[i][j][k]/5;
                    }
                    else if (this.cargoSpace[i][j][k] < 4.99){
                        counter += this.cargoSpace[i][j][k]/5;
                    }
                    else if (this.cargoSpace[i][j][k] < 5.99){
                        counter += this.cargoSpace[i][j][k]/5;
                    }
                }
            }
        }
        return (int)counter;
    }
    /**
    print the cargo space in a special manner,
    there are 5 tabs, each representing a slice in x dimension (width),
    33 columns each representing a slice in z dimension (length)
    and 8 rows each representing a slice in y dimension (height)
     */
    public void printCargoSpace(){
        for (int i = 0; i < widthX; i++){
            System.out.println();
            for (int j = 0; j < heightY; j++) {
                System.out.println();
                for (int k = 0; k < lengthZ; k++) {
                    System.out.print(this.cargoSpace[i][j][k] + " ");
                }
            }
        }
    }
    /**
    used for retrieval of cargo space
     @return array[][][]
     */
    public double[][][] getCargoSpace(){
        return this.cargoSpace;
    }
    /**
    this makes sure we make a deep copy of the most
    important part of truck
     @param inCargoSpace 3d array
     */
    public void setCargoSpace(double[][][] inCargoSpace){
        for (int i = 0; i < widthX; i++) {
            for (int j = 0; j < heightY; j++) {
                for (int k = 0; k < lengthZ; k++) {
                    this.cargoSpace[i][j][k] = inCargoSpace[i][j][k];
                }
            }
        }
    }

    private int[] nextFreeCell = new int[3];
    private int widthX;
    private int heightY;
    private int lengthZ;
    private double[][][] cargoSpace;
}


