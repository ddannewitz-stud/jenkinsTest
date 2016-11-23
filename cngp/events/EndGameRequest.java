package de.omi.pfw.gruppe5.cngp.events;

/**
 * Emitted whenever the games was requested to end.
 * <p>
 * @author Andreas Willems
 * @version 02 DEC 2015
 */
public class EndGameRequest extends Event {
    public EndGameRequest(String message) {
        super(message);
    }
}
