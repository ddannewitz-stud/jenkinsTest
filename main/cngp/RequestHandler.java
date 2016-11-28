package cngp;

import cngp.events.*;
import server.games.GameFactory;
import server.games.GameInterface;
import server.games.GameMap;
import server.util.IdGenerator;

import java.util.Observable;

/**
 * Handles request commands in the context of the CNGP.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public class RequestHandler extends Observable {

    private CNGPInterface parent;
    private int playerNumber = 1;

    /**
     * Constructor.
     * @param parent a reference to the CNGPImplementation
     */
    public RequestHandler(CNGPInterface parent) {
        this.parent = parent;
    }

    /**
     * Redirects request to the specified handler.
     * @param request the incoming request (parameters)
     * @return the resulting response as string
     */
    protected String handleRequest(String[] request) {
        switch (request[0]) {
            case "PROTOCOL":
                return handleProtocolRequest(request);
            case "ID":
                return handleIdRequest(request);
            case "GAME":
                return handleGameRequest(request);
            case "PLAYER":
                return handlePlayerReadyRequest(request);
            case "MOVE":
                return handleMoveRequest(request);
            case "BROADCAST":
                return handleBroadcastRequest(request);
            default:
                return Constants.COMMAND_NOT_SUPPORTED;
        }
    }

    /**
     * Handles requests for a protocol handshake.
     * @param request the requests parameters
     * @return the response as string
     */
    private String handleProtocolRequest(String[] request) {
        int versionNumber = Integer.parseInt(request[1]);
        if (versionNumber == Constants.PROTOCOL_VERSION) {
            notifyParent(new ProtocolAcceptedEvent("protocol accepted"));
            return Constants.RESPONSE_PROTOCOL_ACCEPT;
        } else {
            notifyParent(new ProtocolRejectedEvent("protocol rejected"));
            return Constants.RESPONSE_PROTOCOL_REJECT;
        }
    }

    /**
     * Handles requests for changes in games status (start / end).
     * @param request the requests parameters
     * @return the response as string
     */
    private String handleGameRequest(String[] request) {
        if (request[1].equals("END")) {
            return handleGameEndRequest(request);
        } else {
            return handleGameStartRequest(request);
        }
    }

    /**
     * Handles requests for ending a games.
     * @param request the requests parameters
     * @return the response as string
     */
    private String handleGameEndRequest(String[] request) {
        notifyParent(new EndGameRequest("Request to end games"));
        return Constants.RESPONSE_GAME_ACKNOWLEDGE;
    }

    /**
     * Handles requests for starting a games.
     * @param request the requests parameters
     * @return the response as string
     */
    private String handleGameStartRequest(String[] request) {
        if (request.length < 3) {
            return Constants.RESPONSE_GAME_REJECT;
        }
        String playerId = request[1];
        String nameOfGame = request[2];
        notifyParent(new GameRequestEvent(playerId + "#" + nameOfGame));
        String gameId = GameFactory.getLastTicTacToGameId();
        return Constants.RESPONSE_GAME_ACCEPT + "#" + gameId;
    }

    /**
     * Handles requests made to indicate player readiness.
     * @param request the requests parameters
     *                ["PLAYER", "READY", playerid, gameid]
     * @return the response as string
     */
    private String handlePlayerReadyRequest(String[] request) {
        if (request.length < 4) {
            return Constants.COMMAND_NOT_SUPPORTED;
        }
        notifyParent(new PlayerReadyEvent(request[2] + "#" + request[3]));
        return Constants.RESPONSE_PLAYER_WAITING;
    }

    /**
     * Handles requests of games moves and forwards them to the
     * games plugin.
     * @param request the requests parameters
     *                ["MOVE", playerid, gameid, row:col]
     * @return the response as string
     */
    private String handleMoveRequest(String[] request) {
        if (request.length < 4) {
            return Constants.COMMAND_NOT_SUPPORTED;
        }
        GameInterface game = GameMap.getInstance().getGame(request[2]);
        String response = game.processCommand(request[3]);

        if (game.isLastMoveValid()) {
            notifyParent(new MoveMadeEvent(request[2] + "#" + request[3]));
        }

        return response;
    }

    /**
     * Handles requests that broadcast a move a player made.
     * @param request the requests parameters
     * @return the response as string
     */
    private String handleBroadcastRequest(String[] request) {
        notifyParent(new MoveMadeEvent(request[1]));
        return "RESPONSE#MOVE#ACKNOWLEDGE";
    }

    /**
     * Handles requests to get an id.
     * @param request the request's parameters
     * @return the response as string
     */
    private String handleIdRequest(String[] request) {
        String playerId = IdGenerator.generate();
        notifyParent(new PlayerIdRequestEvent(playerId));
        return Constants.RESPONSE_ID + "#" + playerId;
    }

    /**
     * Toggles the player number and returns the current one.
     * @return the current player number (1 or 2)
     */
    private int togglePlayerNumber() {
        if (playerNumber == 1) {
            playerNumber = 2;
            return 1;
        } else {
            playerNumber = 1;
            return 2;
        }
    }

    /**
     * Sends the given event to the parent instance.
     * @param event the event to broadcast
     */
    private void notifyParent(Event event) {
        parent.broadcastEvent(event);
    }
}
