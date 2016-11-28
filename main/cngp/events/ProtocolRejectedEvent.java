package cngp.events;

/**
 * Emitted when the protocol was rejected.
 * <p>
 * @author Andreas Willems
 * @version 11 DEC 2015
 */
public class ProtocolRejectedEvent extends Event {

    public ProtocolRejectedEvent(String message) {
        super(message);
    }
}
