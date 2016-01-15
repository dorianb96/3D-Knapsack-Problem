package part2ab;

public class Board  {
    public Board() {
        this.board = new double[heightY][widthX];
    }

    /** goes through the whole board and return false
     if there isn't a empty space it returns true,
     if there is it returns false
     @return boolean true or false*/
    public boolean isFull(){
        for (int i = 0; i < board.length; i++)
            for (int j = 0;j<board[0].length; j++)
                    if (this.board[i][j] == 0.0d)
                        return false;
        return true;
    }
    /**
    this basically means the algorithm fills in order (based on priority)
    1) width - x dimension
    2) height  - y dimension

    this makes sure that we don't have any gaps and also optimizes the program at later
    stages when there is only a small unfilled space
     @return array with x,y coordinates of next free cell

     */
    public int[] findNextFreeCell() {
        for (int i =0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 0) {
                    this.nextFreeCell[0] = i;
                    this.nextFreeCell[1] = j;
                    return nextFreeCell;
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
     @param pento
     @return boolean
     */
    public boolean doesItemFit(double[][] pento) throws ArrayIndexOutOfBoundsException {
        int[] nextFreeCell = this.findNextFreeCell();
        int x = pento.length-1;
        for (int i = nextFreeCell[0] + pento.length-1; i >= nextFreeCell[0]; i--) {
            int y = 0;
            for (int j = nextFreeCell[1]; j < nextFreeCell[1] + pento[0].length; j++) {
                try {
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
                    return (false);
                }
                y++;
            }
            x--;
        }
        return true;
    }

    /**
    print the board as a 2D array
     */
    public void printBoard(){
        for (int i = 0; i < this.board.length; i++){
            System.out.println();
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(this.board[i][j] + " ");
            }
        }
    }
    /**
     places the pento onto the nextFreeCell, this method is synced with checkIfFits method
     because the application always first checks whether item fits and only then places it
     @param pento
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
    /**
     used for retrieval of board
     @return array[][][]
     */
    public double[][] getBoard(){
        return this.board;
    }

    /**
     this makes sure we make a deep copy of the board
     @param inBoard 3d array
     */
    public void setBoard(double[][] inBoard){
        for (int i = 0; i < inBoard.length; i++) {
            for (int j = 0; j < inBoard[0].length; j++) {
                this.board[i][j] = inBoard[i][j];
            }
        }
    }
    /**
     returns the percentage of board used by items
     @return board usage
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
    /**
     this returns the value of all items in the cargo space
     @return board value
     */
    public int boardValue(){
        float counter = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (this.board[i][j] < 3.99){
                    counter += this.board[i][j]/5;
                }
                else if (this.board[i][j] < 4.99){
                    counter += this.board[i][j]/5;
                }
                else if (this.board[i][j] < 5.99){
                    counter += this.board[i][j]/5;
                }
            }
        }
        return (int)counter;
    }


    private int[] nextFreeCell = new int[2];
    private int widthX = 5;
    private int heightY = 8;
    private int lengthZ = 33;
    private double board[][];
}
