public class Board {
    public Board() {
        this.board = new double[widthX][heightY];
    }

    /* goes through the whole cargo space and return false
    if there isn't a empty space it returns true,
    if there is it returns false */
    public boolean isFull(){
        for (int i = 0; i < widthX; i++)
            for (int j = 0;j<heightY; j++)
                    if (this.board[i][j] == 0.0d)
                        return false;
        return true;
    }
    /*
    we used a special algorithm that combined with pruning conditions makes sure that
    after we place an item we don't get an item with lesser x,y,z coordinates

    this basically means the algorithm fills in order (based on priority)
    1) width - x dimension
    2) height  - y dimension
    3) length - z dimension

    this makes sure that we don't have any gaps and also optimizes the program at later
    stages when there is only a small unfilled space
     */
    public int[] findNextFreeCell() {
        for (int i =0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 0) {
                    this.nextFreeCell[0] = i;
                    this.nextFreeCell[1] = j;
                    ///System.out.print("Found next free cell  ");
                    //System.out.println(nextFreeCell[0]+" " +nextFreeCell[1]+" ");
                    return nextFreeCell;
                }
            }
        }
        return nextFreeCell;
    }
    /*
    this method is used for checking whether the item fits into the nextFreeCell,
    we used 2 filers
    1) the space isn't already filled
    2) the item fits into cargo space dimensions
     */
    public boolean doesItemFit(double[][] pento) throws ArrayIndexOutOfBoundsException {
        int[] nextFreeCell = this.findNextFreeCell();
        int x = pento.length-1;
        for (int i = nextFreeCell[0] + pento.length-1; i >= nextFreeCell[0]; i--) {
            int y = 0;
            for (int j = nextFreeCell[1]; j < nextFreeCell[1] + pento[0].length; j++) {
                try {
                    /*
                    System.out.println("trying to put item " + pento[0][0] + " "
                             + " at position " + nextFreeCell[0] + " " + nextFreeCell[1]);
                      System.out.println("at position " + i + " " + j + " " + k);
                      System.out.println("the area used for this will be in x " +
                    */
                    /*
                    make sure the program isn't overwriting anything,
                    we are only alarmed by the case when cell isn't empty and the according pento
                    isn't zero.
                    if the according position in pento is 0, then we don't really care,
                    and if the board is empty we also don't care
                     */

                    if (this.board[i][j] != 0 && pento[x][y] != 0) {
                        //System.out.println("space already filled");
                        return false;
                    }
                }
                /* make sure we are staying in bounds of the array */
                catch (ArrayIndexOutOfBoundsException e) {
                    //System.out.println("array out of bounds exception");
                    return (false);
                }
                y++;
            }
            x--;
        }
        return true;
    }

    /*
    print the cargo space in a special manner,
    there are 5 tabs, each representing a slice in x dimension (width),
    33 columns each representing a slice in z dimension (length)
    and 8 rows each representing a slice in y dimension (height)
     */
    public void printBoard(){
        for (int i = 0; i < this.board.length; i++){
            System.out.println();
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(this.board[i][j] + " ");
            }
        }
    }
    /*
    used for retrieval of cargo space
     */
    public double[][] getBoard(){
        return this.board;
    }
    /*
    places the item onto the nextFreeCell, this method is synced with checkIfFits method
    because the application always first checks whether item fits and only then places it

    and the nextFreeCell always returns the same for both methods
    */
    public void placeItem(double[][] pento) {
        int[] nextFreeCell = this.findNextFreeCell();
        int x = pento.length-1;
        for (int i = nextFreeCell[0] + pento.length -1; i >= nextFreeCell[0]; i--) {
            int y = 0;
            for (int j = nextFreeCell[1]; j < nextFreeCell[1] + pento[0].length; j++) {
                if (pento[i - nextFreeCell[0]][j-nextFreeCell[1]] != 0){
                //    System.out.println("placing item at " + i + " " + j);
                //    System.out.println("the value placed at cell is" + pento[i - nextFreeCell[0]][j-nextFreeCell[1]]);
                    this.board[i][j] = pento[x][y];
                }
                y++;
            }
            x--;
        }
    }

    /*
    this makes sure we make a deep copy of the most
    important part of truck
     */
    public void setBoard(double[][] inBoard){
        for (int i = 0; i < inBoard.length; i++) {
            for (int j = 0; j < inBoard[0].length; j++) {
                this.board[i][j] = inBoard[i][j];
            }
        }
    }
    /*
    returns the percentage of truck used by items
    */
    public double boardUsage(){
        double counter = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if(this.board[i][j] >= 1){
                    counter++;
                }
            }
        }
        // just want to round it down to 5 decimal places
        return Math.round(100000.d* (counter/board.length*board[0].length))/100000.d;
    }
    /*
    this returns the value of all items in the cargo space
     */
    public int boardValue(){
        int counter = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                counter+= (int) this.board[i][j];
            }
        }
        return counter;
    }




    private int[] nextFreeCell = new int[2];
    private int widthX = 5;
    private int heightY = 8;
    private int lengthZ = 33;
    private double board[][];
}
