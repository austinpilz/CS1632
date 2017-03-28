package edu.pitt.battleshipgame.common;

import java.util.ArrayList;
import java.util.List;

import edu.pitt.battleshipgame.common.board.Board;

public class GameTracker {
    public static final int MAX_PLAYERS = 2;
    private int registeredPlayers = 0;
    private ArrayList<Board> gameBoards;
    private GameState state = GameState.INIT;
    private int playerTurn = 0;
    Object lock;
    
    public GameTracker() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                state = state.END;
            }
        });
        // Exists to protect this object from direct instantiation
        lock = new Object();
        gameBoards = new ArrayList<Board>(MAX_PLAYERS);
        System.out.println("Server constructed.");
    }

    public int registerPlayer() {
        synchronized(lock) {
            registeredPlayers++;
            gameBoards.add(new Board("Player " + (registeredPlayers - 1) + " board"));
        }
        return registeredPlayers - 1;
    }

    public void wait(int playerID) {
        switch (state) {
            case INIT:
            {
                System.out.println("Player " + playerID + " is waiting for other players");
                while(registeredPlayers < MAX_PLAYERS) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.err.println(e + " I can't sleep!");
                    }
                }
                state = GameState.PLAYING;
                break;
            }
            case PLAYING:
            {
                while(playerTurn != playerID) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.err.println(e + " I can't sleep!");
                    }
                }
                break;
            }
            default:
                break;
        }
    }
    
    public List<Board> getBoards() {
        return gameBoards;
    }
    
    public void setBoards(ArrayList<Board> boards) {
        if (gameBoards == null)
            gameBoards = boards;
        else {
            if (gameBoards.get(0).getShipList().size() != 0 && gameBoards.get(1).getShipList().size() != 0)
                gameBoards = boards;
            if (gameBoards.get(0).getShipList().size() == 0)
                gameBoards.set(0, boards.get(0));
            if (gameBoards.get(1).getShipList().size() == 0)
                gameBoards.set(1, boards.get(1));
        }
        playerTurn = (playerTurn + 1) % registeredPlayers;
    }
    
    public boolean isGameOver() {
        System.out.println("Checking if the game is over...");
        
        if (state == state.END)
        {
            System.out.println("One player ends the game");
            sendMessage("The other player ends the game\nYou WIN");
            gameBoards = new ArrayList<Board>(MAX_PLAYERS);
            return true;
        }
        return false;
    }
    
    public boolean areAllShipsSunk(){
        System.out.println("Checking if the game is over...");
        
        for(Board board : gameBoards) 
        {
            if(board.areAllShipsSunk()) 
            {
                sendMessage("You WIN");
                return true;
            }
        }
        return false;
    }
    
    public void setFirstTurn(int playerID) {
        playerTurn = (playerID + 1) % registeredPlayers;
    }
    
    public void endGame() {
        if (registeredPlayers > 0)
            registeredPlayers--;
        state = state.END;
        playerTurn = (playerTurn + 1) % MAX_PLAYERS;
    }
    
    private String Message="";
    
    public void sendMessage(String s) {
        Message = s;
    }
    
    public String receiveMessage() {
        return Message;
    }
}
