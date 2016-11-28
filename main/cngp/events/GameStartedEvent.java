package cngp.events;

/**
 * Emitted when the games was started.
 * <p>
 * @author Andreas Willems
 * @version 11 DEC 2015
 */
public class GameStartedEvent extends Event {

    public GameStartedEvent(String message) {
        super(message);
    }
}
