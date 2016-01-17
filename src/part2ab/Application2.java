package part2ab;

import java.util.ArrayList;
import java.util.Random;

import part1ab.Truck;
import support.TimeLimit;


public class Application2 extends TimeLimit {
    /**
    handles the 2a and 2b problem
    the boardFill method returns a completely filled board which can be used
    as a single layer in the 3D truck problem
     */
    Board mostFilledBoard = new Board();
    Board mostValuableBoard = new Board();
    Random r = new Random();
    public Board getMostFilledBoard(){
        return this.mostFilledBoard;
    }
    public Board getMostValuableBoard(){
        return this.mostValuableBoard;
    }
    public Truck createMostFilledTruck(){
        Truck mostFilledTruck = new Truck();
        double[][][] cargoSpace = new double[5][8][33];
        if (mostFilledBoard.getBoard().length == 5 && mostFilledBoard.getBoard()[0].length ==8 ){
            for (int z = 0; z < 33; z++){
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 8; j++) {
                        cargoSpace[i][j][z] = mostFilledBoard.getBoard()[i][j];
                    }
                }
            }
            mostFilledTruck.setCargoSpace(cargoSpace);
        }
        else if (mostFilledBoard.getBoard().length == 8 && mostFilledBoard.getBoard()[0].length ==5 ){
            for (int z = 0; z < 33; z++){
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 8; j++) {
                        cargoSpace[i][j][z] = mostFilledBoard.getBoard()[j][i];
                    }
                }
            }
            mostFilledTruck.setCargoSpace(cargoSpace);
        }
        return (mostFilledTruck);
    }
    public Truck createValuableTruck(){
        Truck mostValuableTruck = new Truck();
        double[][][] cargoSpace = new double[5][8][33];
        if (mostValuableBoard.getBoard().length == 5 && mostValuableBoard.getBoard()[0].length ==8 ){
            System.out.println("here");
            for (int z = 0; z < 33; z++){
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 8; j++) {
                        cargoSpace[i][j][z] = mostValuableBoard.getBoard()[i][j];
                    }
                }
            }
            mostValuableTruck.setCargoSpace(cargoSpace);
        }
        else if (mostValuableBoard.getBoard().length == 8 && mostValuableBoard.getBoard()[0].length ==5 ){
            for (int z = 0; z < 33; z++){
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 8; j++) {
                        cargoSpace[i][j][z] = mostValuableBoard.getBoard()[j][i];
                    }
                }
            }
            mostValuableTruck.setCargoSpace(cargoSpace);
        }
        return (mostValuableTruck);
    }

    public boolean boardFill(Board board) {
        startTime = System.currentTimeMillis();
        ArrayList<double[][]> pents = new Pentos2D().getPentos();
        for (double[][] nextItem : pents) {
            totalCombinations++;
            Board newBoard = new Board();
            newBoard.setBoard(board.getBoard());
            boardFill(newBoard, nextItem);
        }
        return false;
    }

    /**
     * @param board
     * @param pento
     * @return 2D board with determined pento shapes
     */
    public boolean boardFill(Board board, double[][] pento) {
        if (board.isFull()) {
            mostFilledBoard.setBoard(board.getBoard());
            return true;
        }
        else if (!board.doesItemFit(pento)) {
            return false;
        }
        else if (checkLimits()){
            return true;
        }
        else {
            ArrayList<double[][]> pents = new Pentos2D().getPentos();
            for (double[][] nextItem : pents) {
                Board newBoard = new Board();
                newBoard.setBoard(board.getBoard());
                newBoard.placeItem(pento);
                if (board.boardUsage() > mostFilledBoard.boardUsage()) {
                    mostFilledBoard.setBoard(board.getBoard());
                }
                if (boardFill(newBoard, nextItem)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
    the greedy fill method for 2D pento board which seeks
     to maximize the value of a 2D layer of truck by first placing
     the most valuable pentominoes
     @param board
     @return recursive call with board value as parameter
     */
    public boolean boardGreedyFill(Board board) {
        startTime = System.currentTimeMillis();
        ArrayList<double[][]> pents = new Pentos2D().getGreedyPents();
        for (double[][] nextItem : pents) {
            Board newBoard = new Board();
            newBoard.setBoard(board.getBoard());
            boardGreedyFill(newBoard, nextItem);
        }
        return false;
    }

    /**
     *
     * @param board
     * @param pento
     * @return board with pentominoes placed to maximize value
     */
    public boolean boardGreedyFill(Board board, double[][] pento) {
        totalCombinations++;
        if (!board.doesItemFit(pento)) {
            return false;
        }
        else if (checkLimits()){
            return true;
        }
        else {
            ArrayList<double[][]> pents = new Pentos2D().getGreedyPents();
            for (double[][] nextItem : pents) {
                Board newBoard = new Board();
                newBoard.setBoard(board.getBoard());
                newBoard.placeItem(pento);
                if (board.boardValue() > mostValuableBoard.boardValue()) {
                    mostValuableBoard.setBoard(board.getBoard());
                }
                if (boardGreedyFill(newBoard, nextItem)) {
                    return true;
                }
            }
            return false;
        }
    }
}
