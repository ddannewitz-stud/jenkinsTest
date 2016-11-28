package server.server;

import server.games.Player;

import java.util.HashMap;

/**
 * Key-Player-Map as singleton.
 *
 * @author Daniel Dannewitz
 * @version 12 Dec 2015
 */
public class PlayerMap {

    /**
     * Inner class.
     * Holds instance.
     */
    private static class inner {
        private static PlayerMap playermap = new PlayerMap();
    }

    /**
     * HashMap with key-player-pairs.
     */
    private HashMap<String, Player> list;

    /**
     * Private constructor.
     */
    private PlayerMap() {
        list = new HashMap<>();
    }

    /**
     * Returns instance of map.
     *
     * @return key-player-map.
     */
    public static PlayerMap getInstance() {
        return inner.playermap;
    }

    /**
     * Adds a new key-player-pair to map.
     *
     * @param key key of pair.
     * @param player player object.
     */
    public synchronized void add(String key, Player player) {
        list.put(key, player);
    }

    /**
     * Deletes a key-player-pair from map.
     *
     * @param key key of pair.
     */
    public synchronized void del(String key) {
        list.remove(key);
    }

    /**
     * Returns player object of key-player-pair.
     *
     * @param key key of pair.
     *
     * @return Player object.
     */
    public synchronized Player getPlayer(String key) {
        return list.get(key);
    }
}
