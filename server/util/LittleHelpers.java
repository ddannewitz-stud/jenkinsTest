package de.omi.pfw.gruppe5.server.util;

import de.omi.pfw.gruppe5.server.observers.ObserverPool;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Utility methods.
 * <p>
 * @author Andreas Willems
 * @version 12 Dez 2015.
 */
public class LittleHelpers {

    public static void registerObservers(Observable observable) {
        ObserverPool pool = ObserverPool.getInstance();
        List<Observer> observers = pool.getObservers();
        observers.forEach(observable::addObserver);
    }
}
