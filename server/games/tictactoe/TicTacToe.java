package de.omi.pfw.gruppe5.server.games.tictactoe;

import de.omi.pfw.gruppe5.cngp.Constants;
import de.omi.pfw.gruppe5.server.games.GameInterface;

import java.util.Vector;

/**
 * Implements a game of TicTacToe.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
public class TicTacToe implements GameInterface {

    private IGameLogic game;
    private String gameId;
    private Vector<String> players;
    private boolean wasLastMoveValid;

    public TicTacToe(String gameId) {
        this.gameId = gameId;
        game = new GameLogic();
        players = new Vector<>();
    }

    @Override
    public String getName() {
        return "TICTACTOE";
    }

    @Override
    public String processCommand(String command) {

        String[] moveParams = command.split(":");
        int row = Integer.parseInt(moveParams[0]);
        int col = Integer.parseInt(moveParams[1]);

        if (game.makeMove(row, col)) {
            wasLastMoveValid = true;
            if (game.checkWin()) {
                int winner = game.getWinner();
                return Constants.REQUEST_GAME_END + "#" + winner;
            }
            return Constants.RESPONSE_MOVE_ACCEPT;
        }
        wasLastMoveValid = false;
        return Constants.RESPONSE_MOVE_REJECT;
    }

    @Override
    public void addPlayer(String playerId) {
        players.add(playerId);
    }

    public IGameLogic getGame() {
        return game;
    }

    public String getGameId() {
        return gameId;
    }

    public Vector<String> getPlayers() {
        return players;
    }

    @Override
    public boolean isLastMoveValid() {
        return wasLastMoveValid;
    }
}
