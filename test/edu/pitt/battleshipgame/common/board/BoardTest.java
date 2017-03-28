/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.board;

import edu.pitt.battleshipgame.common.ships.Ship;
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class Board.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Board instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addShip method, of class Board.
     */
    @Test
    public void testAddShip() {
        System.out.println("addShip");
        Ship ship = null;
        Board instance = null;
        instance.addShip(ship);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesShipOverlap method, of class Board.
     */
    @Test
    public void testDoesShipOverlap() {
        System.out.println("doesShipOverlap");
        Coordinate start = null;
        Coordinate end = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.doesShipOverlap(start, end);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeMove method, of class Board.
     */
    @Test
    public void testMakeMove() {
        System.out.println("makeMove");
        Coordinate move = null;
        Board instance = null;
        Ship expResult = null;
        Ship result = instance.makeMove(move);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveCheck method, of class Board.
     */
    @Test
    public void testMoveCheck() {
        System.out.println("moveCheck");
        Coordinate move = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.moveCheck(move);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canShipFit method, of class Board.
     */
    @Test
    public void testCanShipFit() {
        System.out.println("canShipFit");
        Ship ship = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.canShipFit(ship);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getShipList method, of class Board.
     */
    @Test
    public void testGetShipList() {
        System.out.println("getShipList");
        Board instance = null;
        List<Ship> expResult = null;
        List<Ship> result = instance.getShipList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of areAllShipsSunk method, of class Board.
     */
    @Test
    public void testAreAllShipsSunk() {
        System.out.println("areAllShipsSunk");
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.areAllShipsSunk();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        Board instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString_boolean() {
        System.out.println("toString");
        boolean showShips = false;
        Board instance = null;
        String expResult = "";
        String result = instance.toString(showShips);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
