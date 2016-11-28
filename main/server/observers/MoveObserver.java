package server.observers;

import cngp.Constants;
import cngp.events.MoveMadeEvent;
import server.games.GameInterface;
import server.games.GameMap;
import server.games.Player;
import server.server.PlayerMap;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * Observes game moves the players make.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
class MoveObserver implements Observer {

    /**
     * Gets called by an instance of observable.
     * @param o the calling instance
     * @param arg the given argument
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof MoveMadeEvent) {
            MoveMadeEvent event = (MoveMadeEvent) arg;
            String[] params = event.getMessage().split("#");
            String gameId = params[0];
            String move = params[1];
            GameInterface game = GameMap.getInstance().getGame(gameId);
            Vector<String> players = game.getPlayers();
            for (String player : players) {
                Player p = PlayerMap.getInstance().getPlayer(player);
                p.sendMessage(Constants.REQUEST_BROADCAST_MOVE + "#" + move);
            }
        }
    }
}
