package de.omi.pfw.gruppe5.server.observers;

import de.omi.pfw.gruppe5.cngp.Constants;
import de.omi.pfw.gruppe5.cngp.events.PlayerIdRequestEvent;
import de.omi.pfw.gruppe5.cngp.events.PlayerReadyEvent;
import de.omi.pfw.gruppe5.server.games.Player;
import de.omi.pfw.gruppe5.server.server.PlayerMap;

import java.util.Observable;
import java.util.Observer;

/**
 * Observes events that are related to player actions.
 * <p>
 * @author Andreas Willems
 * @version 12 DEC 2015.
 */
class PlayerObserver implements Observer {

    private static String playerOne;
    private static String playerTwo;

    /**
     * Gets called from an observable instance.
     * @param o the calling instance
     * @param arg the given argument
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof PlayerIdRequestEvent) {
            PlayerIdRequestEvent event = (PlayerIdRequestEvent) arg;
            Player p = new Player(event.getSocket(), event.getMessage());
            PlayerMap.getInstance().add(p.getPlayerId(), p);
        }

        if (arg instanceof PlayerReadyEvent) {
            PlayerReadyEvent event = (PlayerReadyEvent) arg;
            String[] params = event.getMessage().split(Constants.DELIMITER);
            String playerId = params[0];
            String gameId = params[1];

            System.out.println("Player one: " + playerOne);
            System.out.println("Player two: " + playerTwo);

            if (playerOne == null) {
                playerOne = playerId;
                return;
            }

            if (playerTwo == null) {
                playerTwo = playerId;
                //return;
            }
            Player player = PlayerMap.getInstance().getPlayer(playerOne);
            player.sendMessage(Constants.RESPONSE_PLAYER_START);
            Player player2 = PlayerMap.getInstance().getPlayer(playerTwo);
            player2.sendMessage(Constants.RESPONSE_PLAYER_START);
        }
    }
}
