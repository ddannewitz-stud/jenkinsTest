package cngp.events;

/**
 * Emitted when the server broadcasts a move another client made.
 * <p>
 * @author Andreas Willems
 * @version 11 DEC 2015
 */
public class MoveMadeEvent extends Event {

    public MoveMadeEvent(String message) {
        super(message);
    }
}
