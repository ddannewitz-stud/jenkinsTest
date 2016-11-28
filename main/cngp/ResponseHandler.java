package cngp;

import cngp.events.*;

import java.util.Observable;

/**
 * Handles response commands in the context of the CNGP.
 * <p>
 * @author Andreas Willems
 * @version 10 Dez 2015.
 */
public class ResponseHandler extends Observable {

    private CNGPInterface parent;

    /**
     * Constructor.
     * @param parent a reference to the CNGPImplementation
     */
    public ResponseHandler(CNGPInterface parent) {
        this.parent = parent;
    }

    /**
     * Redirects response commands to the specified handler.
     * @param response the incoming response (parameters)
     * @return the resulting response as string
     */
    protected String handleResponse(String[] response) {
        switch(response[0]) {
            case "ID": return handleIDResponse(response);
            case "PROTOCOL": return handleProtocolResponse(response);
            case "GAME": return handleGameResponse(response);
            case "PLAYER": return handlePlayerResponse(response);
            case "MOVE": return handleMoveResponse(response);
            default:
                return Constants.COMMAND_NOT_SUPPORTED;
        }
    }

    private String handleIDResponse(String[] response) {
        setChanged();
        notifyObservers(new IDReceivedEvent(response[1]));
        return response[1];
    }

    private String handleProtocolResponse(String[] response) {
        switch (response[1]) {
            case "ACCEPT":
                return handleProtocolAccept(response);
            case "REJECT":
                return handleProtocolReject(response);
            default:
                return Constants.COMMAND_NOT_SUPPORTED;
        }
    }

    private String handleProtocolAccept(String[] response) {
        setChanged();
        notifyObservers(new ProtocolAcceptedEvent("protocol accepted"));
        return "PROTOCOL#ACCEPTED";
    }

    private String handleProtocolReject(String[] response) {
        if (response.length < 3) {
            return Constants.COMMAND_NOT_SUPPORTED;
        }
        setChanged();
        notifyObservers(new ProtocolRejectedEvent("protocol rejected"));
        return "PROTOCOL#REJECTED";
    }

    private String handleGameResponse(String[] response) {
        switch (response[1]) {
            case "ACCEPT":
                return handleGameAccept(response);
            case "REJECT":
                return handleGameReject(response);
            case "ACKNOWLEDGE":
                return "OK";
            default:
                return Constants.COMMAND_NOT_SUPPORTED;
        }
    }

    private String handleGameAccept(String[] response) {
        if (response.length < 3) {
            return Constants.COMMAND_NOT_SUPPORTED;
        }
        setChanged();
        notifyObservers(new GameAcceptedEvent(response[2]));
        return response[2];
    }

    private String handleGameReject(String[] response) {
        setChanged();
        notifyObservers(new GameRejectedEvent("games rejected"));
        return "GAME#REJECTED";
    }

    private String handlePlayerResponse(String[] response) {
        switch (response[1]) {
            case "WAITING":
                return handlePlayerWaiting(response);
            case "START":
                return handlePlayerStarted(response);
            default:
                return Constants.COMMAND_NOT_SUPPORTED;
        }
    }

    private String handlePlayerWaiting(String[] response) {
        setChanged();
        notifyObservers(new PlayerWaitingEvent("games started"));
        return "WAITING";
    }

    private String handlePlayerStarted(String[] response) {
        setChanged();
        notifyObservers(new GameStartedEvent("game started"));
        return "PLAYER#STARTED";
    }

    private String handleMoveResponse(String[] response) {
        return "OK";
    }
}
