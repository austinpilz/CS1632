/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.board;

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
public class CoordinateTest {
    
    public CoordinateTest() {
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
     * Test of setCoordinates method, of class Coordinate.
     */
    @Test
    public void testSetCoordinates() {
        System.out.println("setCoordinates");
        String coord = "";
        Coordinate instance = new Coordinate();
        instance.setCoordinates(coord);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCol method, of class Coordinate.
     */
    @Test
    public void testSetCol() {
        System.out.println("setCol");
        int _col = 0;
        Coordinate instance = new Coordinate();
        instance.setCol(_col);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRow method, of class Coordinate.
     */
    @Test
    public void testSetRow() {
        System.out.println("setRow");
        int _row = 0;
        Coordinate instance = new Coordinate();
        instance.setRow(_row);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRow method, of class Coordinate.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        Coordinate instance = new Coordinate();
        int expResult = 0;
        int result = instance.getRow();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCol method, of class Coordinate.
     */
    @Test
    public void testGetCol() {
        System.out.println("getCol");
        Coordinate instance = new Coordinate();
        int expResult = 0;
        int result = instance.getCol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of columnLookup method, of class Coordinate.
     */
    @Test
    public void testColumnLookup() {
        System.out.println("columnLookup");
        char colName = ' ';
        int expResult = 0;
        int result = Coordinate.columnLookup(colName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseColumnLookup method, of class Coordinate.
     */
    @Test
    public void testReverseColumnLookup() {
        System.out.println("reverseColumnLookup");
        int col = 0;
        char expResult = ' ';
        char result = Coordinate.reverseColumnLookup(col);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Coordinate.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Coordinate instance = new Coordinate();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
