/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.ships;

import edu.pitt.battleshipgame.common.board.Board;
import edu.pitt.battleshipgame.common.board.Coordinate;
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
public class CruiserTest {
    
    private static Cruiser shipInstance;
    
    public CruiserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        shipInstance = new Cruiser(new Coordinate(0,1), new Coordinate(4,5), new Board("Test Board"));
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
     * Test of getLength method, of class Cruiser.
     */
    @Test
    public void testGetLength() {
        int expResult = shipInstance.LENGTH;
        int result = shipInstance.getLength();
        assertEquals("Ship Length != getLength()", expResult, result);
    }

    /**
     * Test of maxAllowed method, of class Cruiser.
     */
    @Test
    public void testMaxAllowed() {
        int expResult = shipInstance.MAX_ALLOWED;
        int result = shipInstance.maxAllowed();
        assertEquals("Ship Max != getMax()", expResult, result);
    }

    /**
     * Test of getName method, of class Cruiser.
     */
    @Test
    public void testGetName() {
        String expResult = shipInstance.NAME;
        String result = shipInstance.getName();
        assertEquals("Ship Name != getName()", expResult, result);
    }

    /**
     * Test of getType method, of class Cruiser.
     */
    @Test
    public void testGetType() {
        Ship.ShipType expResult = shipInstance.TYPE;
        Ship.ShipType result = shipInstance.getType();
        assertEquals("Ship.Type != ShipType.Battleship", expResult, result);
    }
    
}
