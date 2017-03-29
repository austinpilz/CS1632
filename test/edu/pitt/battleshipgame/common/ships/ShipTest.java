/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.ships;

import edu.pitt.battleshipgame.common.board.Board;
import edu.pitt.battleshipgame.common.board.Coordinate;
import java.util.ArrayList;
import java.util.Collections;
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
public class ShipTest {
    
    private static ShipImpl shipObj;
    
    public ShipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        shipObj = new ShipImpl(new Coordinate(1,1), new Coordinate(2,3), new Board("Test Board"));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCoordinates method, of class Ship.
     */
    @Test
    public void testGetCoordinates() {
        
        Coordinate c1 = new Coordinate (1,1);
        Coordinate c2 = new Coordinate (2,1);
        shipObj = new ShipImpl(c1, c2, new Board("Test Board"));
        
        ArrayList<Coordinate> expResult = new ArrayList<>();
        expResult.add(c1);
        expResult.add(c2);
        ArrayList<Coordinate> result = new ArrayList<>(shipObj.getCoordinates());
        
        //Tests to see if the size is correct
        assertEquals(result.size(), expResult.size());
    }

    /**
     * Test of isSunk method, of class Ship.
     */
    @Test
    public void testIsSunk() {
        //At the beginning with our setup ship, should not be sunk
        assertFalse(shipObj.isSunk());
        
        //In this example, ship is only length (1)
        for (int i = 0; i < shipObj.getLength(); i++)
        {
            shipObj.registerHit();
        }
        
        //Should now be sunken
        assertTrue(shipObj.isSunk());
    }

    /**
     * Test of addBoard method, of class Ship.
     */
    @Test
    public void testAddBoard() {
        Board board = new Board("Test Board");
        shipObj = new ShipImpl(new Coordinate(1,1), new Coordinate(3,5), board);
        
        //Add board gets called upon contruction, so no need to call directly
        ArrayList<Ship> boardShips = new ArrayList<>(board.getShipList());
        
        boolean found = false;
        for (Ship ship : boardShips)
        {
            if (ship.getLength() == shipObj.getLength())
            {
                found = true;
            }
        }
        
        assertTrue(found);
    }

    /**
     * Test of registerHit method, of class Ship.
     */
    @Test
    public void testRegisterHit() {
        for (int i = 0; i < shipObj.getLength(); i++)
        {
            shipObj.registerHit();
        }

        assertTrue(shipObj.isSunk());      
    }

    public class ShipImpl extends Ship {

        public ShipImpl(Coordinate c1, Coordinate c2, Board board) {
            super(c1, c2, board);
        }

        public int getLength() {
            return 1;
        }

        public int maxAllowed() {
            return 1;
        }

        public String getName() {
            return "";
        }

        public ShipType getType() {
            return null;
        }
    }
    
}
