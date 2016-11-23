package de.omi.pfw.gruppe5.server.observers;

import de.omi.pfw.gruppe5.cngp.events.GameRequestEvent;
import de.omi.pfw.gruppe5.server.games.GameFactory;
import de.omi.pfw.gruppe5.server.games.GameInterface;
import de.omi.pfw.gruppe5.server.games.GameMap;

import java.util.Observable;
import java.util.Observer;

/**
 * Watches for game events.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
class GameObserver implements Observer {

    /**
     * Gets called from an observable instance.
     * @param o the calling instance
     * @param arg the given argument
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof GameRequestEvent) {
            GameRequestEvent event = (GameRequestEvent) arg;
            String[] params = event.getMessage().split("#");
            if (params[1].equals("TICTACTOE")) {
                GameInterface tictactoe = GameFactory.getTicTacToe(params[0]);
                GameMap.getInstance().add(tictactoe.getGameId(), tictactoe);
            }
        }
    }
}
