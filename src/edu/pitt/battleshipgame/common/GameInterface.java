package edu.pitt.battleshipgame.common;

import edu.pitt.battleshipgame.common.board.*;
import java.util.ArrayList;

public interface GameInterface {
    int registerPlayer();
    void wait(int playerID);
    ArrayList<Board> getBoards();
    void setBoards(ArrayList<Board> boards);
    boolean isGameOver();
    boolean areAllShipsSunk();
    void setFirstTurn(int playerID);
    void endGame();
    void sendMessage(String s);
    String receiveMessage();
}
