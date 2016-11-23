package de.omi.pfw.gruppe5.cngp.events;

/**
 * Emitted when a games was created.
 * <p>
 * @author Andreas Willems
 * @version 02 DEC 2015
 */
public class GameRequestEvent extends Event {

    public GameRequestEvent(String message) {
        super(message);
    }
}
