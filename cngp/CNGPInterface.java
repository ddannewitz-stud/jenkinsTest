package de.omi.pfw.gruppe5.cngp;

import de.omi.pfw.gruppe5.cngp.events.Event;
import de.omi.pfw.gruppe5.server.games.GameInterface;

import java.util.ArrayList;

/**
 * Interface definition for the CGNP module.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public interface CNGPInterface {

    /**
     * Starts the processing of given CGNP commands
     * and returns the defined results as strings.
     *
     * @param command - the command to process
     * @return a string with the result
     */
    String processCommand(String command);

    /**
     * Register a games as a plugin.
     * @param game - the games to register
     */
    void registerGame(GameInterface game);

    /**
     * Unregister a games plugin.
     * @param game - the games to unregister
     */
    void unregisterGame(GameInterface game);

    /**
     * Returns the list of available games.
     * @return the games as a List.
     */
    ArrayList<GameInterface> getGames();

    /**
     * Notifies all observers.
     * @param event the event to pass to the observers
     */
    void broadcastEvent(Event event);

}
