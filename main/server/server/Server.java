package server.server;


import server.util.Callback;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Server implementation.
 *
 * @author Daniel Dannewitz
 * @version 12 Dec 2015.
 */
public class Server extends Thread {

    /**
     * Server Socket.
     */
    private ServerSocket server;

    /**
     * Running value of server.
     */
    private boolean running;

    /**
     * Basic constructor.
     */
    public Server() {
        running = true;
        try {
            server = new ServerSocket(9000);
        } catch (IOException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Actual logic.
     * Accepts a new connection and starts a handler.
     */
    @Override
    public void run() {
        while(running) {
            try {
                Socket client = server.accept();
                ClientHandler ch = new ClientHandler(client);
                ch.start();
            } catch (IOException e) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    /**
     * Starts the server's thread.
     * @param callback a callback object to be called after starting the server
     */
    public void startServer(Callback callback) {
        this.start();
        callback.execute();
    }
}
