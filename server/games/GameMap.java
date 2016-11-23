package de.omi.pfw.gruppe5.server.games;

import java.util.HashMap;

/**
 * Key-Game-Map as singleton.
 *
 * @author Andreas Willems
 * @version 12 Dec 2015
 */
public class GameMap {

    /**
     * Inner class.
     * Holds instance.
     */
    private static class inner {
        private static GameMap gameMap = new GameMap();
    }

    /**
     * HashMap with key-game-pairs.
     */
    private HashMap<String, GameInterface> list;

    /**
     * Private constructor.
     */
    private GameMap() {
        list = new HashMap<>();
    }

    /**
     * Returns instance of map.
     *
     * @return key-game-map.
     */
    public static GameMap getInstance() {
        return inner.gameMap;
    }

    /**
     * Adds a new key-game-pair to map.
     *
     * @param key key of pair.
     * @param game game object.
     */
    public synchronized void add(String key, GameInterface game) {
        list.put(key, game);
    }

    /**
     * Deletes a key-game-pair from map.
     *
     * @param key key of pair.
     */
    public synchronized void del(String key) {
        list.remove(key);
    }

    /**
     * Returns game object of key-game-pair.
     *
     * @param key key of pair.
     *
     * @return Game object.
     */
    public synchronized GameInterface getGame(String key) {
        return list.get(key);
    }
}
