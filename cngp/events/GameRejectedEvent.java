package de.omi.pfw.gruppe5.cngp.events;

/**
 * Emitted when the requested games was rejected.
 * <p>
 * @author Andreas Willems
 * @version 11 DEC 2015
 */
public class GameRejectedEvent extends Event {

    public GameRejectedEvent(String message) {
        super(message);
    }
}
