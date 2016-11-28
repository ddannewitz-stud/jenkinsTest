package server.server;

import cngp.CNGPImplementation;
import server.util.LittleHelpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Client handler.
 * Actual handling logic for clients.
 *
 * @author Daniel Dannewitz
 * @version 12 Dec 2015.
 */
public class ClientHandler extends Thread {

    /**
     * Input stream.
     */
    private BufferedReader in;

    /**
     * Output stream.
     */
    private PrintWriter out;

    /**
     * Socket.
     */
    private Socket socket;

    /**
     * Running value of handler-thread.
     */
    private boolean running;

    /**
     *  Constructor with one parameter.
     *
     * @param socket socket connection to client.
     */
    public ClientHandler(Socket socket) {
        running = true;
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Actual logic.
     * Accepts client input and forwards it to CNGP.
     */
    @Override
    public void run() {
        CNGPImplementation cngp = new CNGPImplementation(socket);
        LittleHelpers.registerObservers(cngp);

        while(running) {
            try {
                while(in.ready()) {
                    String s = cngp.processCommand(in.readLine());
                    System.out.println("Server: " + s);
                    out.println(s);
                    out.flush();
                }
            } catch (IOException e) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

}
