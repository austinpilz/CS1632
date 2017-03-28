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
        Coordinate c1 = new Coordinate(0,0);
        Board board = new Board("Test Board");
        battleshipInstance = new Battleship(c1, c1, board);
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
        assertEquals(expResult, result);
    }

    /**
     * Test of maxAllowed method, of class Battleship.
     */
    @Test
    public void testMaxAllowed() {
        System.out.println("--Testing maxAllowed()--");
        int expResult = battleshipInstance.MAX_ALLOWED;
        int result = battleshipInstance.maxAllowed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Battleship.
     */
    @Test
    public void testGetName() {
        System.out.println("--Testing getName()--");
        String expResult = battleshipInstance.NAME;
        String result = battleshipInstance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getType method, of class Battleship.
     */
    @Test
    public void testGetType() {
        System.out.println("--Testing getType()--");
        ShipType expResult = battleshipInstance.TYPE;
        ShipType result = battleshipInstance.getType();
        assertEquals(expResult, result);
    }
    
}
