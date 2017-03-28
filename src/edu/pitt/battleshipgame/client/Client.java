package edu.pitt.battleshipgame.client;

import java.util.ArrayList;
import java.util.Scanner;

import edu.pitt.battleshipgame.common.board.*;
import edu.pitt.battleshipgame.common.ships.*;
import edu.pitt.battleshipgame.common.GameInterface;
import edu.pitt.battleshipgame.common.GameTracker;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Client {
    public static GameInterface gi;
    public static int myPlayerID;
    public static ArrayList<Board> gameBoards;
    public static ArrayList<String> usedMoves;
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String [] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                gi.endGame();
            }
        });
        
        gi = new ClientWrapper();
        myPlayerID = gi.registerPlayer();
        
        System.out.println("You have registered as Player " + myPlayerID);
        System.out.println("Please wait for other players to join");
        
        gi.wait(myPlayerID);
        
        System.out.println("Both Players have joined, starting the game.");
        
        gameBoards = gi.getBoards();
        
        Timer timer = new Timer();
        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time out");
                gi.endGame();
                System.exit(0);
            }
        };
        System.out.println("\nTo quit, please enter 'q' or 's'");
        System.out.println("\nYou have 2min to place all the ships");
        timer.schedule(timertask, 120000);
        placeShips(gameBoards.get(myPlayerID));
        timer.cancel();
        
        if(gi.isGameOver()) {
            System.out.println(gi.receiveMessage());
            System.out.println("The Game is Over!");
            return;
        } else {
            System.out.println("Your board:");
            System.out.println(gameBoards.get(myPlayerID).toString(true));
            gi.setBoards(gameBoards);
            gameLoop();
        }
    }

    public static void placeShips(Board board) {
        String userInput;
        for(Ship.ShipType type : Ship.ShipType.values()) 
        {
            System.out.println("\nYour Board:");
            System.out.println(board.toString(true));
            boolean success = false;
            while(type != Ship.ShipType.NONE && !success) 
            {
                System.out.println("Please enter a start coordinate to place your " + ShipFactory.getNameFromType(type));
                
                Coordinate start = new Coordinate();
                Coordinate end = new Coordinate();
                
                boolean startOk = false;
                boolean endOk = false;
                
                while (!startOk)
                {
                    try
                    {
                        userInput = scan.nextLine().toUpperCase();
                        if (userInput.equals("Q") || userInput.equals("S"))
                        {
                            System.out.println("Disconnecting from game! You Lose!");
                            gi.endGame();
                            System.exit(0);
                        }
                        start.setCoordinates(userInput);
                        startOk = true;
                    }
                    catch (IllegalArgumentException e)
                    {
                           System.out.println("That coordinate is invalid, please try again: ");
                           startOk = false;
                    }
                }
                
                System.out.println("Please enter a end coordinate to place your " + ShipFactory.getNameFromType(type));

                while (!endOk)
                {
                    try
                    {
                        userInput = scan.nextLine().toUpperCase();
                        if (userInput.equals("Q") || userInput.equals("S"))
                        {
                            System.out.println("Disconnecting from game! You Lose!");
                            gi.endGame();
                            System.exit(0);
                        }
                        end.setCoordinates(userInput);
                        endOk = true;
                    }
                    catch (IllegalArgumentException e)
                    {
                           System.out.println("That coordinate is invalid, please try again: ");
                           endOk = false;
                    }
                }
                
                ArrayList errors = ShipFactory.isPlacementAppropriate(type, start, end, board);
                if (errors.size() > 0)
                {
                    success = false;
                    
                    //Print out all of the errors to the user
                    Iterator<String> errorIterator = errors.iterator();
                    while (errorIterator.hasNext()) 
                    {
                        System.out.println(errorIterator.next());
                    }
                }
                else
                {
                    success = true;                    
                    ShipFactory.newShipFromType(type, start, end, board);
                }
            }
        }
    }

    public static void gameLoop() {
        String userInput= "";
        usedMoves = new ArrayList<String>();
        System.out.println("Please wait for the other player to finish placing ships\n");
        gi.setFirstTurn(myPlayerID);
        gi.wait(myPlayerID);
        gi.setBoards(gameBoards);
        
        System.out.println("The game is starting!");
        do {
            // Wait for our turn
            System.out.println("Not your turn. Please wait for the other player to finish\n");
            gi.wait(myPlayerID);
            // Get the updated boards
            gameBoards = gi.getBoards();
            
            if (gi.areAllShipsSunk()) {
                System.out.println("You LOSE");
                System.out.println("The Game is Over!");
                System.exit(0);
            }
 
            System.out.println("You have 30s to place your move");
            System.out.println("Previous moves are: " + Arrays.toString(usedMoves.toArray()));
            
            Coordinate move = new Coordinate();
            Boolean moveOk = false;
            
            Timer timer = new Timer();
            TimerTask timertask = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time out! You Lose!");
                    gi.endGame();
                    System.exit(0);
                }
            };
            timer.schedule(timertask, 30000);
            
            while (!moveOk)
            {
                try
                {
                    userInput = scan.nextLine().toUpperCase();
                    if (userInput.equals("Q") || userInput.equals("S"))
                    {
                        System.out.println("Disconnecting from game! You Lose!");
                        gi.endGame();
                        gi.wait(myPlayerID);
                        System.exit(0);
                    }
                    move.setCoordinates(userInput);
                    if (gameBoards.get((myPlayerID + 1) % GameTracker.MAX_PLAYERS).moveCheck(move))
                        moveOk = true;
                    else
                    {
                        System.out.println("Duplicate fire is not allowed! Please choose another place to move");
                        moveOk = false;
                    }
                }
                catch (IllegalArgumentException e)
                {
                       System.out.println("That coordinate is invalid, please try again: ");
                       moveOk = false;
                }
            }
            
            timer.cancel();
            if(!gi.isGameOver()) {
                Ship ship = gameBoards.get((myPlayerID + 1) % GameTracker.MAX_PLAYERS).makeMove(move);
                if(ship == null) 
                {
                    System.out.println("Miss");
                    gi.sendMessage("The other player MISS");
                } 
                else if (ship.isSunk()) 
                {
                    System.out.println("You sunk " + ship.getName());
                    gi.sendMessage("Your " + ship.getName() + " SUNK");
                } 
                else 
                {
                    System.out.println("Hit");
                    gi.sendMessage("The other player HIT your " + ship.getName());
                }

                // Send the updated boards.
                gi.setBoards(gameBoards);
                System.out.println("Your opponent's board:");
                System.out.println(gameBoards.get((myPlayerID + 1) % GameTracker.MAX_PLAYERS).toString());
                usedMoves.add(userInput);
            }
        } 
        while(!gi.areAllShipsSunk() && !gi.isGameOver());
        System.out.println(gi.receiveMessage());
        System.out.println("The Game is Over!");
        gi.wait(myPlayerID);
    }
}
