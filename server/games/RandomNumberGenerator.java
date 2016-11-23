package de.omi.pfw.gruppe5.server.games;

import java.util.Random;

/**
 * Generates a random number between 1 and 10.
 * TODO: remove if not needed.
 * @author Daniel Dannewitz
 * @version 09 Dez 2015
 */
public class RandomNumberGenerator {

    /**
     * Generates a random number.
     * Uses private method.
     *
     * @return random number.
     */
    public int generate() {
        return randomNumber(1, 10);
    }

    /**
     * Returns a random number between min and max.
     *
     * @param min minimum number.
     * @param max maximum number.
     *
     * @return random number.
     */
    private int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
