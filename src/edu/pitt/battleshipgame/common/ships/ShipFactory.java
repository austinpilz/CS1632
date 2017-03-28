package edu.pitt.battleshipgame.common.ships;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import edu.pitt.battleshipgame.common.ships.*;
import edu.pitt.battleshipgame.common.board.*;
import java.util.ArrayList;

public abstract class ShipFactory {
    public static Ship newShipFromType(Ship.ShipType type, Coordinate start, Coordinate end, Board board) 
    {
        switch (type) 
        {
            case BATTLESHIP:
                return new Battleship(start, end, board);
            case CARRIER:
                return new Carrier(start, end, board);
            case CRUISER:
                return new Cruiser(start, end, board);
            case SUBMARINE:
                return new Submarine(start, end, board);
            case DESTROYER:
                return new Destroyer(start, end, board);
            default:
                throw new IllegalArgumentException(type + " does not identify a valid ShipType.");
        }
    }

    public static int maxAllowedFromType(Ship.ShipType type) {
        switch (type) {
            case BATTLESHIP:
                return Battleship.MAX_ALLOWED;
            case CARRIER:
                return Carrier.MAX_ALLOWED;
            case CRUISER:
                return Cruiser.MAX_ALLOWED;
            case SUBMARINE:
                return Submarine.MAX_ALLOWED;
            case DESTROYER:
                return Destroyer.MAX_ALLOWED;
            default:
                throw new IllegalArgumentException(type + " does not identify a valid ShipType.");
        }
    }
    
    public static String getNameFromType(Ship.ShipType type) {
        switch (type) {
            case BATTLESHIP:
                return Battleship.NAME;
            case CARRIER:
                return Carrier.NAME;
            case CRUISER:
                return Cruiser.NAME;
            case SUBMARINE:
                return Submarine.NAME;
            case DESTROYER:
                return Destroyer.NAME;
            default:
                throw new IllegalArgumentException(type + " does not identify a valid ShipType.");
        }
    }

    public static ArrayList isPlacementAppropriate(Ship.ShipType type, Coordinate start, Coordinate end, Board board)
    {
        ArrayList errors = new ArrayList();
        
        if (isPlacedDiagonially(start, end))
        {
            errors.add("The ship cannot be placed diagonally.");
        }
        else if (getShipPlacementSize(start, end) != getShipLength(type))
        {
            errors.add("The entered ship is " + getShipPlacementSize(start, end) + " unit(s) long but the ship must be " + getShipLength(type) + " unit(s) long");
        }
        else if (board.doesShipOverlap(start, end))
        {
            errors.add("Ship placement overlaps an existing ship.");
        }
        
        return errors;
        
    }
    
    private static boolean isPlacedHorizontally(Coordinate start, Coordinate end)
    {
        if (start.getRow() == end.getRow())
        {
            if (start.getCol() > end.getCol())
                Swap(start, end);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private static boolean isPlacedVertically(Coordinate start, Coordinate end)
    {
        if (start.getCol() == end.getCol())
        {
            if (start.getRow() > end.getRow())
                Swap(start, end);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private static boolean isPlacedDiagonially(Coordinate start, Coordinate end)
    {
        if (isPlacedHorizontally(start, end) || isPlacedVertically(start, end))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    private static int getShipPlacementSize(Coordinate start, Coordinate end)
    {
        if (isPlacedVertically(start, end))
        {
            return end.getRow() - start.getRow() + 1;
        }
        else
        {
            return end.getCol() - start.getCol() + 1;
        }
    }
    
    /**
     * Returns the length of a ship
     * @param type
     * @return 
     */
    private static int getShipLength(Ship.ShipType type)
    {
        switch (type) 
        {
            case BATTLESHIP:
                return Battleship.LENGTH;
            case CARRIER:
                return Carrier.LENGTH;
            case CRUISER:
                return Cruiser.LENGTH;
            case SUBMARINE:
                return Submarine.LENGTH;
            case DESTROYER:
                return Destroyer.LENGTH;
            default:

                return 0;
        }
    }
    
    private static void Swap(Coordinate start, Coordinate end) {
        int tempCol = start.getCol();
        int tempRow = start.getRow();
        start.setCol(end.getCol());
        start.setRow(end.getRow());
        end.setCol(tempCol);
        end.setRow(tempRow);
    }
}

