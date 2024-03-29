package edu.pitt.battleshipgame.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.util.ArrayList;

import edu.pitt.battleshipgame.common.Serializer;
import edu.pitt.battleshipgame.common.board.*;
import edu.pitt.battleshipgame.common.*;

public class ClientWrapper implements GameInterface {
    ServerInterface serverInterface = null;
    int myPlayerID;

    private static ServerInterface getServer() {
        URL url = null;
        try {
            url = new URL("http://localhost:9999/battleship?wsdl");
        } catch (MalformedURLException e) {
            System.err.println(e);
        }
        QName qname = new QName("http://server.battleshipgame.pitt.edu/", "ServerWrapperService");
        Service service = Service.create(url, qname);
        return service.getPort(ServerInterface.class);
    }
    
    public ClientWrapper() {
        serverInterface = getServer();
    }
    
    @Override
    public int registerPlayer() {
        return serverInterface.registerPlayer();
    }
    
    @Override
    public void wait(int playerID) {
        serverInterface.wait(playerID);
    }
    
    @Override
    public void setBoards(ArrayList<Board> boards) {
        serverInterface.setBoards(Serializer.toByteArray(boards));
    }
    
    /**
     * Client side wrapper around the 
     * @return 
     */
    @Override
    public ArrayList<Board> getBoards() {
        return (ArrayList<Board>) Serializer.fromByteArray(serverInterface.getBoards());
    }
    
    public boolean isGameOver() {
        return serverInterface.isGameOver();
    }
    
    public boolean areAllShipsSunk() {
        return serverInterface.areAllShipsSunk();
    }
    
    public void setFirstTurn(int playerID) {
        serverInterface.setFirstTurn(playerID);
    }
    
    public void endGame() {
        serverInterface.endGame();
    }
    
    public void sendMessage(String s) {
        serverInterface.sendMessage(s);
    }
    
    public String receiveMessage() {
        return serverInterface.receiveMessage();
    }
}
