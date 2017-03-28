/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.ships;

import edu.pitt.battleshipgame.common.board.Board;
import edu.pitt.battleshipgame.common.board.Coordinate;
import edu.pitt.battleshipgame.common.ships.Ship.ShipType;
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
public class BattleshipTest {
    
    private static Battleship shipInstance;
    
    public BattleshipTest() 
    {
        //
    }
    
    @BeforeClass
    public static void setUpClass() {
        shipInstance = new Battleship(new Coordinate(0,1), new Coordinate(4,5), new Board("Test Board"));
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
     * Test of getLength method, of class Battleship.
     */
    @Test
    public void testGetLength() {
        int expResult = shipInstance.LENGTH;
        int result = shipInstance.getLength();
        assertEquals("Ship Length != getLength()", expResult, result);
    }

    /**
     * Test of maxAllowed method, of class Battleship.
     */
    @Test
    public void testMaxAllowed() {
        int expResult = shipInstance.MAX_ALLOWED;
        int result = shipInstance.maxAllowed();
        assertEquals("Ship Max != getMax()", expResult, result);
    }

    /**
     * Test of getName method, of class Battleship.
     */
    @Test
    public void testGetName() {
        String expResult = shipInstance.NAME;
        String result = shipInstance.getName();
        assertEquals("Ship Name != getName()", expResult, result);
    }

    /**
     * Test of getType method, of class Battleship.
     */
    @Test
    public void testGetType() {
        ShipType expResult = shipInstance.TYPE;
        ShipType result = shipInstance.getType();
        assertEquals("Ship.Type != ShipType.Battleship", expResult, result);
    }
    
}
