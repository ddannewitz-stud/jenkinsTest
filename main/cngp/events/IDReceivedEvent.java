package cngp.events;

/**
 * Emitted when an ID is received.
 * <p>
 * @author Andreas Willems
 * @version 16 Jan 2016
 */
public class IDReceivedEvent extends Event {

    public IDReceivedEvent(String message) {
        super(message);
    }
}
