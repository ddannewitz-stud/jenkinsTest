package de.omi.pfw.gruppe5.cngp.events;

import java.net.Socket;

/**
 * Abstract definition of an event.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public class Event {

    protected String message;
    private Socket socket;

    public Event(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSocket(Socket s) {
        socket = s;
    }

    public Socket getSocket() {
        return socket;
    }
}


