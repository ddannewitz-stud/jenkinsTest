package server.observers;

import cngp.events.GameRequestEvent;
import server.games.GameFactory;
import server.games.GameInterface;
import server.games.GameMap;

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
