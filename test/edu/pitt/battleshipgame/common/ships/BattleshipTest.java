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
    
    private static Battleship battleshipInstance;
    
    public BattleshipTest() 
    {
        //
    }
    
    @BeforeClass
    public static void setUpClass() {
        battleshipInstance = new Battleship(new Coordinate(0,1), new Coordinate(4,5), new Board("Test Board"));
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
        System.out.println("--Testing getLength()--");
        int expResult = battleshipInstance.LENGTH;
        int result = battleshipInstance.getLength();
        assertEquals("Battleship Length != getLength()", expResult, result);
    }

    /**
     * Test of maxAllowed method, of class Battleship.
     */
    @Test
    public void testMaxAllowed() {
        System.out.println("--Testing maxAllowed()--");
        int expResult = battleshipInstance.MAX_ALLOWED;
        int result = battleshipInstance.maxAllowed();
        assertEquals("Battleship Max != getMax()", expResult, result);
    }

    /**
     * Test of getName method, of class Battleship.
     */
    @Test
    public void testGetName() {
        System.out.println("--Testing getName()--");
        String expResult = battleshipInstance.NAME;
        String result = battleshipInstance.getName();
        assertEquals("Battleship Name != getName()", expResult, result);
    }

    /**
     * Test of getType method, of class Battleship.
     */
    @Test
    public void testGetType() {
        System.out.println("--Testing getType()--");
        ShipType expResult = battleshipInstance.TYPE;
        ShipType result = battleshipInstance.getType();
        assertEquals("Battleship.Type != ShipType.Battleship", expResult, result);
    }
    
}
