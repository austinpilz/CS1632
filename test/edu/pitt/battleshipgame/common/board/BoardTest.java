/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.board;

import edu.pitt.battleshipgame.common.ships.Ship;
import edu.pitt.battleshipgame.common.ships.ShipFactory;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author austinpilz
 */
public class BoardTest {
    
    private Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       board = new Board("test board");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Board.
     */
    @Test
    public void testGetName() { 
        assertEquals("test board", board.getName());
    }

    /**
     * Test of addShip method, of class Board.
     */
    @Test
    public void testAddShip() {
        Board newBoard = new Board("newBoard Example");
        newBoard.addShip(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:4"), board));
        
        boolean found = false;
        for (Ship s :newBoard.getShipList())
        {
            if (s.getType().equals(Ship.ShipType.DESTROYER))
            {
                found = true;
            }
                  
        }
            
            assertTrue(found);
        
    }

    /**
     * Test of doesShipOverlap method, of class Board.
     */
    @Test
    public void testDoesShipOverlap() {
        Board newBoard = new Board("newBoard Example");
        newBoard.addShip(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:4"), board));
        assertTrue(newBoard.doesShipOverlap(new Coordinate("A:1"), new Coordinate("A:4")));
        assertFalse(newBoard.doesShipOverlap(new Coordinate("C:1"), new Coordinate("C:4")));
    }

    /**
     * Test of makeMove method, of class Board.
     */
    @Test
    public void testMakeMove() {
        //This adds a new ship, sinks it to make sure make move works properly
        Board newBoard = new Board("newBoard Example");
        newBoard.addShip(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:2"), board));
        newBoard.makeMove(new Coordinate ("A:1"));
        newBoard.makeMove(new Coordinate ("A:2"));
        
        assertTrue(newBoard.areAllShipsSunk());
    }

    /**
     * Test of moveCheck method, of class Board.
     */
    @Test
    public void testMoveCheck() {
        //Sinks a ship and then tries to make a move on an area that was already sunk
        Board newBoard = new Board("newBoard Example");
        newBoard.addShip(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:2"), board));
        newBoard.makeMove(new Coordinate ("A:1"));
        newBoard.makeMove(new Coordinate ("A:2"));
        
        assertFalse(newBoard.moveCheck(new Coordinate ("A:2")));
    }

    /**
     * Test of canShipFit method, of class Board.
     */
    @Test
    public void testCanShipFit() {
        Board newBoard = new Board("newBoard Example");
        assertTrue(newBoard.canShipFit(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:2"), board)));
    }

    /**
     * Test of getShipList method, of class Board.
     */
    @Test
    public void testGetShipList() {
        Board newBoard = new Board("newBoard Example");
        newBoard.addShip(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:2"), board));
        
        boolean found = false;
        for (Ship s :newBoard.getShipList())
        {
            if (s.getType().equals(Ship.ShipType.DESTROYER))
            {
                found = true;
            }
                  
        }
            
        assertTrue(found);
    }

    /**
     * Test of areAllShipsSunk method, of class Board.
     */
    @Test
    public void testAreAllShipsSunk() {
        Board newBoard = new Board("newBoard Example");
        newBoard.addShip(ShipFactory.newShipFromType(Ship.ShipType.DESTROYER, new Coordinate("A:1"), new Coordinate("A:2"), board));
        newBoard.makeMove(new Coordinate ("A:1"));
        newBoard.makeMove(new Coordinate ("A:2"));
        
        assertTrue(newBoard.areAllShipsSunk());
    }
}
