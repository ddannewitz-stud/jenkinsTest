package de.omi.pfw.gruppe5.cngp;

/**
 * Constants used around the protocol implementation.
 * <p>
 * @author Andreas
 * @version 02 Dez 2015.
 */
public class Constants {

    public static final int PROTOCOL_VERSION = 1;
    public static final String DELIMITER = "#";
    public static final String COMMAND_NOT_SUPPORTED = "Command not supported";
    public static final String REQUEST = "REQUEST";
    public static final String REQUEST_PROTOCOL = "REQUEST#PROTOCOL";
    public static final String RESPONSE = "RESPONSE";
    public static final String RESPONSE_PROTOCOL_ACCEPT = "RESPONSE#PROTOCOL#ACCEPT";
    public static final String RESPONSE_PROTOCOL_REJECT = "RESPONSE#PROTOCOL#REJECT";
    public static final String RESPONSE_GAME_ACCEPT = "RESPONSE#GAME#ACCEPT";
    public static final String RESPONSE_GAME_REJECT = "RESPONSE#GAME#REJECT";
    public static final String RESPONSE_PLAYER_WAITING = "RESPONSE#PLAYER#WAITING";
    public static final String RESPONSE_PLAYER_START = "RESPONSE#PLAYER#START";
    public static final String RESPONSE_GAME_ACKNOWLEDGE = "RESPONSE#GAME#ACKNOWLEDGE";
    public static final String RESPONSE_MOVE_ACCEPT = "RESPONSE#MOVE#ACCEPT";
    public static final String RESPONSE_MOVE_REJECT = "RESPONSE#MOVE#REJECT";
    public static final String REQUEST_GAME_END = "REQUEST#GAME#END";
    public static final String RESPONSE_ID = "RESPONSE#ID";
    public static final String REQUEST_BROADCAST_MOVE = "REQUEST#BROADCAST#MOVE";
}
