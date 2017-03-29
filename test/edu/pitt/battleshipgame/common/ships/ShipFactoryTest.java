/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pitt.battleshipgame.common.ships;

import edu.pitt.battleshipgame.common.board.Board;
import edu.pitt.battleshipgame.common.board.Coordinate;
import edu.pitt.battleshipgame.common.ships.Ship.ShipType;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author austinpilz
 */
public class ShipFactoryTest {
    
    public ShipFactoryTest() {
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
     * Test of newShipFromType method, of class ShipFactory.
     */
    @Test
    public void testNewShipFromType() 
    {
        ArrayList<Ship.ShipType> shipTypes = new ArrayList<>();
        
        //List of ship types that will be attempted
        shipTypes.add(ShipType.BATTLESHIP);
        shipTypes.add(ShipType.CARRIER);
        shipTypes.add(ShipType.CRUISER);
        shipTypes.add(ShipType.SUBMARINE);
        shipTypes.add(ShipType.DESTROYER);
        
        for (ShipType st : shipTypes)
        {
            Ship returnedShip = ShipFactory.newShipFromType(st, new Coordinate(1,1), new Coordinate(4,5), new Board(""));
            assertEquals(returnedShip.getType(), st);
        }
    }

    /**
     * Test of maxAllowedFromType method, of class ShipFactory.
     */
    @Test
    public void testMaxAllowedFromType() {
        //Test that the max returned values match those defined in the ship type classes
        assertEquals(ShipFactory.maxAllowedFromType(Ship.ShipType.BATTLESHIP), Battleship.MAX_ALLOWED);
        assertEquals(ShipFactory.maxAllowedFromType(Ship.ShipType.CARRIER), Carrier.MAX_ALLOWED);
        assertEquals(ShipFactory.maxAllowedFromType(Ship.ShipType.CRUISER), Cruiser.MAX_ALLOWED);
        assertEquals(ShipFactory.maxAllowedFromType(Ship.ShipType.SUBMARINE), Submarine.MAX_ALLOWED);
        assertEquals(ShipFactory.maxAllowedFromType(Ship.ShipType.DESTROYER), Destroyer.MAX_ALLOWED);
    }

    /**
     * Test of getNameFromType method, of class ShipFactory.
     */
    @Test
    public void testGetNameFromType() {
        //Test the 5 cases return the enum == string
        assertEquals(ShipFactory.getNameFromType(Ship.ShipType.BATTLESHIP), Battleship.NAME);
        assertEquals(ShipFactory.getNameFromType(Ship.ShipType.CARRIER), Carrier.NAME);
        assertEquals(ShipFactory.getNameFromType(Ship.ShipType.CRUISER), Cruiser.NAME);
        assertEquals(ShipFactory.getNameFromType(Ship.ShipType.SUBMARINE), Submarine.NAME);
        assertEquals(ShipFactory.getNameFromType(Ship.ShipType.DESTROYER), Destroyer.NAME);
    }

    /**
     * Test of isPlacementAppropriate method, of class ShipFactory.
     */
    @Test
    public void testIsPlacementAppropriate() {
        
        Board board = new Board("Appropriate");
        ArrayList<String> errors;
        
        //Test if the ship with correct link will pass
        errors = ShipFactory.isPlacementAppropriate(ShipType.BATTLESHIP, new Coordinate(1,1), new Coordinate(1,4), board);
        assertEquals(0, errors.size());
        
        //Test if the ship with incorrect link will fail
        errors = ShipFactory.isPlacementAppropriate(ShipType.BATTLESHIP, new Coordinate(1,1), new Coordinate(1,5), board);
        assertEquals(1, errors.size());
        
        //Test failure if placed diagonally
        errors = ShipFactory.isPlacementAppropriate(ShipType.BATTLESHIP, new Coordinate(1,1), new Coordinate(2,4), board);
        assertEquals(1, errors.size());
        
        //Should fail since overlap would occur
        new Battleship(new Coordinate(1,1), new Coordinate(1,4), board);
        errors = ShipFactory.isPlacementAppropriate(ShipType.BATTLESHIP, new Coordinate(1,3), new Coordinate(2,7), board);
        assertEquals(1, errors.size());
    }
    
}
