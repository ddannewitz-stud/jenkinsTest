package server.games;

import server.games.tictactoe.TicTacToe;
import server.util.IdGenerator;

/**
 * Creates and manages game instances.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public class GameFactory {

    private static int playerCount = 0;
    private static GameInterface instanceOfTicTacToe;
    private static String lastTicTacToGameId;

    /**
     * Returns an instance of a game of TicTacToe.
     * @param playerId the player's id
     * @return an instance of TicTacToe
     */
    public static GameInterface getTicTacToe(String playerId) {
        if (instanceOfTicTacToe == null) {
            String gameId = IdGenerator.generate();
            lastTicTacToGameId = gameId;
            instanceOfTicTacToe = new TicTacToe(gameId);
        }

        if (playerCount == 2) {
            playerCount = 0;
            String gameId = IdGenerator.generate();
            lastTicTacToGameId = gameId;
            instanceOfTicTacToe = new TicTacToe(gameId);
        }

        if (playerCount < 2) {
            instanceOfTicTacToe.addPlayer(playerId);
            playerCount++;
        }

        return instanceOfTicTacToe;
    }

    /**
     * Returns the id of the last game of TicTacToe.
     * @return the id as string
     */
    public static String getLastTicTacToGameId() {
        return lastTicTacToGameId;
    }

}
