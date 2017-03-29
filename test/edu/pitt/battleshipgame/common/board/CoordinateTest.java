/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.board;

import java.util.Random;
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
    
    private static Coordinate coordinate;
    
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
        coordinate = new Coordinate("A:1");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorWithInt() {
        int x = 1, y = 2;
        Coordinate coordinate = new Coordinate(x,y);
        assertEquals("Coordinate Column", y, coordinate.getCol());
        assertEquals("Coordinate Row",x, coordinate.getRow());
    }
    
    @Test
    public void testConstructorWithString() {
        Coordinate coordinate = new Coordinate("A:2");
        assertEquals("Coordinate Column", 0, coordinate.getCol());
        assertEquals("Coordinate Row", 1, coordinate.getRow()); //Subtracts 1 in the actual method to the row
    }
    
    /**
     * Test of setCoordinates method, of class Coordinate.
     */
    @Test
    public void testSetCoordinates() {
        //Sets B:1 which should equal 1:0 when converted into ints.
        coordinate.setCoordinates("B:1");
        assertEquals("Coordinate Column", 1, coordinate.getCol());
        assertEquals("Coordinate Row", 0, coordinate.getRow()); //Subtracts 1 in the actual method to the row
    }

    /**
     * Test of setCol method, of class Coordinate.
     */
    @Test
    public void testSetCol() {
        //Set column to value and get the same value back
        Random rand = new Random();
        int randomNumber = rand.nextInt(9) + 1;
        
        coordinate.setCol(randomNumber);
        assertEquals("Set Column", randomNumber, coordinate.getCol());
    }

    /**
     * Test of setRow method, of class Coordinate.
     */
    @Test
    public void testSetRow() {
        //Set column to value and get the same value back
        Random rand = new Random();
        int randomNumber = rand.nextInt(9) + 1;
        
        coordinate.setRow(randomNumber);
        assertEquals("Set Row", randomNumber, coordinate.getRow());
    }

    /**
     * Test of getRow method, of class Coordinate.
     */
    @Test
    public void testGetRow() {
        //Essentially the same test as setting, set a random number and make sure we get the same value back
        Random rand = new Random();
        int randomNumber = rand.nextInt(9) + 1;
        
        coordinate.setRow(randomNumber);
        assertEquals("Get Row", randomNumber, coordinate.getRow());
    }

    /**
     * Test of getCol method, of class Coordinate.
     */
    @Test
    public void testGetCol() {
        //Essentially the same test as setting, set a random number and make sure we get the same value back
        Random rand = new Random();
        int randomNumber = rand.nextInt(9) + 1;
        
        coordinate.setCol(randomNumber);
        assertEquals("Get Column", randomNumber, coordinate.getCol());
    }

    /**
     * Test of columnLookup method, of class Coordinate.
     */
    @Test
    public void testColumnLookup() {
        //Will go through all of the column options and compare them to the int values they should be
        char[] columns = new char[]{'A','B','C','D','E','F','G','H','I','J'};
        int x = 0;
        
        for (char col : columns)
        {
            assertEquals(Coordinate.columnLookup(col), x++);
        }
                
    }

    /**
     * Test of reverseColumnLookup method, of class Coordinate.
     */
    @Test
    public void testReverseColumnLookup() {
        //Will go through all of the column options and compare them to the char values they should be
        char[] columns = new char[]{'A','B','C','D','E','F','G','H','I','J'};
        int x = 0;
        
        for (char col : columns)
        {
            assertEquals(Coordinate.reverseColumnLookup(x++), col);
        }
    }

    /**
     * Test of toString method, of class Coordinate.
     */
    @Test
    public void testToString() {
        //Sets coordinates using both constructors and then compares the toString function
        Coordinate c1 = new Coordinate(1,2);
        assertEquals("C:2", c1.toString());
        
        Coordinate c2 = new Coordinate("A:1");
        assertEquals("A:1", c2.toString());
    }
    
}
