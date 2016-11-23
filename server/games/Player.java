package de.omi.pfw.gruppe5.server.games;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Player object.
 * @author Daniel Dannewitz, Andreas Willems
 * @version 12 DEC 2015
 */
public class Player {

    /**
     * Socket.
     */
    private Socket socket;

    /**
     *
     */
    private String playerId;

    /**
     * Player number.
     */
    private int playerNumber;

    /**
     * Constructor with two parameters.
     *
     * @param s socket connection.
     * @param playerNumber player number.
     */
    public Player(Socket s, int playerNumber) {
        socket = s;
        this.playerNumber = playerNumber;
    }

    /**
     * Constructor with two parameters.
     * @param s socket connection
     * @param playerId the player's id
     */
    public Player(Socket s, String playerId) {
        this(s, 0);
        this.playerId = playerId;
    }

    /**
     * Returns socket of Player.
     *
     * @return socket of Player.
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * Returns player number.
     *
     * @return player number.
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * Gets the player's id.
     * @return the id as string
     */
    public String getPlayerId() {
        return playerId;
    }

    /**
     * Sends a message to the player's socket.
     * @param responsePlayerStart the message to send
     */
    public void sendMessage(String responsePlayerStart) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(responsePlayerStart);
            out.flush();
        } catch (IOException e) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
