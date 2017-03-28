package edu.pitt.battleshipgame.common.board;

import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;

import edu.pitt.battleshipgame.common.ships.Ship;

public class Board implements Serializable {
    public static final int BOARD_DIM = 10;
    // We could track a Ship-Bool pair but it is just as easy to have
    // two arrays. The Ships array will keep track of the ships on the
    // game board. The moves array will be initialized to false and will
    // change to true when that move is made.
    //private ArrayList < ArrayList < Ship > > theShips;
    private Ship [][] theShips;
    private boolean [][] moves;
    private int [][] overlapCheck;
    // Keep a list of all ships on this board for quick searching.
    LinkedList<Ship> shipList;
    private String name;

    public Board (String _name) {
        theShips = new Ship[BOARD_DIM][BOARD_DIM];
        moves = new boolean[BOARD_DIM][BOARD_DIM];
        overlapCheck = new int[BOARD_DIM][BOARD_DIM];
        shipList = new LinkedList<Ship>();
        name = _name;
    }
    
    public String getName() {
        return name;
    }
    
    public void addShip(Ship ship) {
        if (!canShipFit(ship)) {
            throw new IllegalArgumentException("This board already has the maximum amount of: " + ship.getName());
        }
        for (Coordinate coord : ship.getCoordinates()){
            theShips[coord.getRow()][coord.getCol()] = ship;
            overlapCheck[coord.getRow()][coord.getCol()] = 1;
        }
        shipList.add(ship);
    }
    
    public boolean doesShipOverlap(Coordinate start, Coordinate end)
    {
        if (start.getRow() == end.getRow()) {
            for (int i = start.getCol(); i <= end.getCol(); i++) {
                if (overlapCheck[start.getRow()][i] == 1)
                    return true;
            }
        }
        else {
            for (int i = start.getRow(); i <= end.getRow(); i++) {
                if (overlapCheck[i][start.getCol()] == 1)
                    return true;
            }
        }
        return false;
    }
    
    public Ship makeMove(Coordinate move) {
        moves[move.getRow()][move.getCol()] = true;
        Ship ship = theShips[move.getRow()][move.getCol()];
        if(ship != null) {
            ship.registerHit();
        }
        return ship;
    }
    
    public boolean moveCheck(Coordinate move) {
        return !moves[move.getRow()][move.getCol()];
    }
    
    public boolean canShipFit(Ship ship) 
    {
        int shipCount = 0;
        for (Ship s : shipList) 
        {
            if (s.getType() == ship.getType()) 
            {
                shipCount++;
            }
        }
        
        if (shipCount >= ship.maxAllowed()) 
        {
            return false;
        } 
        else 
        {
            return true;
        }
    }
    
    public List<Ship> getShipList() {
        return shipList;
    }
    
    public boolean areAllShipsSunk() 
    {
        for (Ship s : shipList) 
        {   
            if (!s.isSunk()) {
                return false;
            } else if(s.getLength() == 0){
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        return toString(false);
    }
    
    public String toString(boolean showShips) {
        StringBuilder sb = new StringBuilder();
        // Buld an intermediate representation of the board as a character array
        String [][] boardRepresentation = new String[BOARD_DIM+1][BOARD_DIM+1];
        boardRepresentation[0][0] = "-  ";
        for (int row = 1; row < BOARD_DIM+1; row++) {
            // The first column will be filled with the row labels
            if (row != 10)
                boardRepresentation[row][0] = Integer.toString(row) + "  ";
            else
                boardRepresentation[row][0] = Integer.toString(row) + " ";
        }
        for (int col = 1; col < BOARD_DIM+1; col++) {
            boardRepresentation[0][col] = Character.toString(Coordinate.reverseColumnLookup(col-1))+" ";
        }
        for (int row = 0; row < BOARD_DIM; row++) {
            for (int col = 0; col < BOARD_DIM; col++) {
                if (moves[row][col]) {
                    if (theShips[row][col] != null) {
                        boardRepresentation[row+1][col+1] = "X ";
                    } else {
                        boardRepresentation[row+1][col+1] = "O ";
                    }
                }
                if (showShips && theShips[row][col] != null) {
                    boardRepresentation[row+1][col+1] = "S ";
                }
            }
        }
        for (int row = 0; row < BOARD_DIM+1; row++) {
            for (int col = 0; col < BOARD_DIM+1; col++) {
                if (boardRepresentation[row][col] != null)
                    sb.append(boardRepresentation[row][col]);
                else
                    sb.append("+ ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
