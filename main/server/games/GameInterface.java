package server.games;

import java.util.Vector;

/**
 * Interface definition for a CNGP games plugin.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public interface GameInterface {

    /**
     * Gets the plugin's name.
     * @return the name as string
     */
    String getName();

    /**
     * Handles commands in the context of playing a games.
     *
     * @param command - the command to process
     * @return the response as a string
     */
    String processCommand(String command);

    /**
     * Adds a player's id to the game's instance.
     * @param playerId the player's id
     */
    void addPlayer(String playerId);

    /**
     * Return the registered players.
     * @return the players as string array
     */
    Vector<String> getPlayers();

    /**
     * Returns the game's id.
     * @return the id as String
     */
    String getGameId();

    /**
     * Indicates if the last move of this game was valid.
     *
     * @return the validity of the last move as boolean
     */
    boolean isLastMoveValid();
}
