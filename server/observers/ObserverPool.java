package de.omi.pfw.gruppe5.server.observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Handles instantiating all observers
 * and holds references to them.
 * <p>
 * @author Andreas Willems
 * @version 12 Dez 2015.
 */
public class ObserverPool {

    /**
     * Holds a reference to the ObserverPool singleton.
     */
    private static ObserverPool instance;
    /**
     * Holds references to all available observers.
     */
    private static List<Observer> observers;

    /**
     * Private constructor.
     */
    private ObserverPool() {
        observers = new ArrayList<>();
    }

    /**
     * Returns an instance of the ObserverPool.
     * @return an object of type ObserverPool
     */
    public static ObserverPool getInstance() {
        if (instance == null) {
            instance = new ObserverPool();
            initObservers();
        }
        return instance;
    }

    /**
     * Returns the available observers.
     * @return a List of observers
     */
    public List<Observer> getObservers() {
        return observers;
    }

    /**
     * Instantiates the observers and adds them to the list.
     */
    private static void initObservers() {
        observers.add(new GameObserver());
        observers.add(new PlayerObserver());
        observers.add(new MoveObserver());
    }
}
