package de.omi.pfw.gruppe5.server.util;

import java.util.UUID;

/**
 * Generates a unique ID.
 * @author Daniel Dannewitz
 * @version 12 Dec 2015
 */
public class IdGenerator {
    public static String generate() {
        return formatString(UUID.randomUUID().toString());
    }

    private static String formatString(String uuid) {
        return uuid.replaceAll("-", "");
    }
}