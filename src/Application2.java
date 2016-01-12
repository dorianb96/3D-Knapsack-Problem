import java.util.ArrayList;
import java.util.Random;

public class Application2 {
    Board mostFilledBoard = new Board(); // the diamond operator
    Board mostValuableBoard = new Board(); // the diamond operator
    Random r = new Random();

    public Board getMostFilledBoard() {
        return this.mostFilledBoard;
    }

    public Board getMostValuableBoard() {
        return this.mostValuableBoard;
    }

    public boolean boardFill(Board board) {
        ArrayList<double[][]> pents = new Pentos2D().getPentos();
        for (double[][] nextItem : pents) {
            Board newBoard = new Board();
            newBoard.setBoard(board.getBoard());
            boardFill(newBoard, nextItem);
        }
        return false;
    }

    public boolean boardFill(Board board, double[][] pento) {
        if (board.isFull()) {
            mostFilledBoard.setBoard(board.getBoard());
            return true;
        } else if (!board.doesItemFit(pento)) {
            return false;
        } else {
            if (board.boardUsage() > mostFilledBoard.boardUsage()) {
                mostFilledBoard.setBoard(board.getBoard());
                System.out.println(mostFilledBoard.boardUsage());
                mostFilledBoard.printBoard();
            }
            ArrayList<double[][]> pents = new Pentos2D().getPentos();
            for (double[][] nextItem : pents) {
                Board newBoard = new Board();
                newBoard.setBoard(board.getBoard());
                if (r.nextInt(10000) < 1000) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    mostValuableBoard.boardUsage();
                    mostValuableBoard.boardValue();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
                newBoard.placeItem(pento);
                if (boardFill(newBoard, nextItem)) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
    the greedy fill method for 2D pento board
     */
    public boolean boardGreedyFill(Board board) {
        ArrayList<double[][]> pents = new Pentos2D().getGreedyPents();
        for (double[][] nextItem : pents) {
            Board newBoard = new Board();
            newBoard.setBoard(board.getBoard());
            boardGreedyFill(newBoard, nextItem);
        }
        return false;
    }

    public boolean boardGreedyFill(Board board, double[][] pento) {
        System.out.println(board.boardValue());
        if (!board.doesItemFit(pento)) {
            return false;
        }
        else {
            if (board.boardValue() > mostValuableBoard.boardValue()) {
                mostValuableBoard.setBoard(board.getBoard());

                System.out.println(mostValuableBoard.boardValue());
                mostValuableBoard.printBoard();

            }
            ArrayList<double[][]> pents = new Pentos2D().getGreedyPents();
            for (double[][] nextItem : pents) {
                Board newBoard = new Board();
                newBoard.setBoard(board.getBoard());
                /*
                if (r.nextInt(10000) < 1000) {
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    board.printBoard();
                    mostValuableBoard.boardValue();
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
                */
                newBoard.placeItem(pento);
                if (boardGreedyFill(newBoard, nextItem)) {
                    return true;
                }
            }
            return false;
        }
    }
}
