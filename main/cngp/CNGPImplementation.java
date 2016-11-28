package cngp;

import cngp.events.Event;
import server.games.GameInterface;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * Implements the Casual Network Gaming Protocol in it's current
 * version.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public class CNGPImplementation extends Observable implements CNGPInterface {

    private Socket socket;
    private RequestHandler request;
    private ResponseHandler response;

    /**
     * Creates an instance of the CNGP implementation.
     *
     * @param s a socket
     */
    public CNGPImplementation(Socket s) {
        socket = s;
        request = new RequestHandler(this);
        response = new ResponseHandler(this);
    }

    /**
     * Adds a games to the protocol's known games.
     * @param game the games to register
     */
    public void registerGame(GameInterface game) {

    }

    /**
     * Removes the given games from the protocol's known games.
     * @param game the games to unregister
     */
    public void unregisterGame(GameInterface game) {
    }

    /**
     * Returns the list of available games.
     * @return the games as an ArrayList
     */
    public ArrayList<GameInterface> getGames() {
        return null;
    }


    /**
     * Processes the command send from the calling instance.
     *
     * @param command the command to process
     * @return the result as defined by the CNGP
     */
    @Override
    public String processCommand(String command) {
        return parseCommand(command);
    }

    /**
     * Splits up the incoming command into its pieces
     * and distributes the command in regard of its purpose,
     * i.e. request or response.
     *
     * The distributed command contains only the command's parameters.
     *
     * Example: REQUEST#PROTOCOL#1 becomes PROTOCOL#1
     *
     * @param command the incoming command
     * @return the answer from the protocol implementation
     */
    private String parseCommand(String command) {
        //System.out.println(command);
        String[] params = command.split(Constants.DELIMITER);
        switch (params[0]) {
            case Constants.REQUEST:
                return request.handleRequest(getCommandParams(params));
            case Constants.RESPONSE:
                return response.handleResponse(getCommandParams(params));
            default:
                return Constants.COMMAND_NOT_SUPPORTED;
        }
    }

    /**
     * Splits the incoming command into pieces
     * and returns the separated parameters as an
     * array.
     * @param params the command to parse
     * @return an array of Strings
     */
    private String[] getCommandParams(String[] params) {
        return Arrays.copyOfRange(params, 1, params.length);
    }

    /**
     * Notifies observers.
     * @param event the event to pass to the observers
     */
    public void broadcastEvent(Event event) {
        setChanged();
        event.setSocket(socket);
        notifyObservers(event);
    }
}