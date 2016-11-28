package cngp.events;

/**
 * Emitted whenever the current player changes.
 * <p>
 * @author Daniel Dannewitz
 * @version 10 DEC 2015
 */
public class PlayerChangedEvent extends Event {

    public PlayerChangedEvent(String message) {
        super(message);
    }
}
