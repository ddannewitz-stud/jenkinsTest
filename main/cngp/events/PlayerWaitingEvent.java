package cngp.events;

/**
 * Emitted when the server acknowledges the client is
 * ready and sends it waiting.
 * <p>
 * @author Andreas Willems
 * @version 11 DEC 2015
 */
public class PlayerWaitingEvent extends Event {

    public PlayerWaitingEvent(String message) {
        super(message);
    }
}
