package de.omi.pfw.gruppe5.cngp.events;

/**
 * Emitted whenever the current player is ready.
 * <p>
 * @author Andreas Willems
 * @version 02 DEC 2015
 */
public class PlayerReadyEvent extends Event {

    public PlayerReadyEvent(String message) {
        super(message);
    }
}
